package com.spb.houqin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spb.houqin.admin.entity.Maintain;
import com.spb.houqin.admin.entity.OperationLog;
import com.spb.houqin.admin.entity.Tool;
import com.spb.houqin.admin.entity.User;
import com.spb.houqin.admin.service.MaintainService;
import com.spb.houqin.admin.service.OperationLogService;
import com.spb.houqin.admin.service.ToolService;
import com.spb.houqin.admin.service.UserService;
import com.spb.houqin.common.base.AjaxResult;
import com.spb.houqin.common.base.PageData;
import com.spb.houqin.common.base.ResponseEntity;
import com.spb.houqin.common.util.DateUtil;
import com.spb.houqin.common.util.FileUpload;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("admin/maintain")
public class MaintainController {

    @Autowired
    private ToolService toolService;

    @Autowired
    private MaintainService maintainService;

    @Autowired
    private UserService userService;

    @Autowired
    private OperationLogService operationLogService;

    @GetMapping("/list")
    public String list(){
        return "admin/maintain/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public PageData<Maintain> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                   @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                   ServletRequest request, HttpSession session){
        User loginInfo = (User) session.getAttribute("adminInfo");
        String number = request.getParameter("number");
        String type = request.getParameter("type");
        String satus = request.getParameter("satus");

        QueryWrapper<Maintain> maintainQueryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(number)){
            maintainQueryWrapper.like("number",number);
        }
        if(StringUtils.isNotEmpty(type)){
            maintainQueryWrapper.eq("type",type);
        }
        if(StringUtils.isNotEmpty(satus)){
            maintainQueryWrapper.like("satus",satus);
        }
        maintainQueryWrapper.eq("del_flag", 0);

        //数据权限
        if(loginInfo.getRoleName().equals("员工")){
            maintainQueryWrapper.eq("userid2",loginInfo.getId());
        }else if (loginInfo.getRoleName().equals("维修工")){
            maintainQueryWrapper.eq("userid",loginInfo.getId());
            maintainQueryWrapper.eq("satus",4);
        }

        PageData<Maintain> maintainPageData = new PageData<>();
        IPage<Maintain> toolIPage = maintainService.page(new Page<>(page,limit),maintainQueryWrapper);
        List<Maintain> list = toolIPage.getRecords();
        list.forEach(r->{
            r.setRoleName(loginInfo.getRoleName());
        });
        toolIPage.setRecords(list);
        maintainPageData.setCount(toolIPage.getTotal());
        maintainPageData.setData(toolIPage.getRecords());
        return maintainPageData;
    }

    @GetMapping("/add")
    public String add(ModelMap modelMap){
        //维修工
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("role_name", "维修工");
        List<User> users = userService.list(userQueryWrapper);
        modelMap.put("userList", users);
        return "admin/maintain/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity add(@RequestBody Maintain maintain, HttpSession session){
        maintain.setCreateDate(new Date());
        String str = String.valueOf(System.currentTimeMillis());
        maintain.setNumber("WX"+str.substring(str.length()-6,str.length()-1));

        User loginInfo = (User) session.getAttribute("adminInfo");
        maintain.setUserid2(loginInfo.getId());
        maintain.setUsername2(loginInfo.getUserName());

        User userInfo = userService.getById(maintain.getUserid());
        maintain.setUsername(userInfo.getUserName());
        maintainService.save(maintain);


        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("报修");
        operationLog.setMsg(loginInfo.getUserName()+"报修了"+maintain.getRemarks());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    /**
     * 图片上传
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public Map uploadPicture(@RequestParam("file") MultipartFile file, HttpServletRequest servletRequest)
            throws IOException {
        String path = "D:/logs/upload/houqin/";
        String src = servletRequest.getScheme() + "://" + servletRequest.getServerName() + ":" + servletRequest.getLocalPort();

        return FileUpload.upload(file, path, src);
    }

    @GetMapping("/weixiu")
    public String weixiu(ModelMap modelMap,String id){
        List<Tool> tools = toolService.list(new QueryWrapper<Tool>().eq("del_flag",0));
        modelMap.put("tools", tools);
        //维修工
        modelMap.put("maintain", maintainService.getById(id));
        return "admin/maintain/weixiu";
    }

    @PostMapping("/weixiu")
    @ResponseBody
    public ResponseEntity weixiu(@RequestBody Maintain maintain,HttpSession session){
        Maintain oldMaintain = maintainService.getById(maintain.getId());
        oldMaintain.setAmount(maintain.getAmount());
        oldMaintain.setSatus(maintain.getSatus());
        oldMaintain.setHandleTime(DateUtil.getDateByStr(maintain.getHandleTimeStr()));
        oldMaintain.setToolid(maintain.getToolid());

        Tool tool = toolService.getById(maintain.getToolid());

        if (Integer.parseInt(tool.getAmount()) < Integer.parseInt(maintain.getAmount())){{
            return ResponseEntity.failure("工具数量不足");
        }}

        tool.setAmount(String.valueOf(Integer.parseInt(tool.getAmount())- Integer.parseInt(maintain.getAmount())));
        toolService.updateById(tool);

        oldMaintain.setToolname(tool.getName());

        oldMaintain.setRemark2(maintain.getRemark2());
        oldMaintain.updateById();

        User userInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(userInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("维修");
        operationLog.setMsg(oldMaintain.getUsername()+"维修了"+oldMaintain.getNumber() + ";使用工具 : " + tool.getName() + ";消耗数量为："+maintain.getAmount() );
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    @PostMapping("/bohui")
    @ResponseBody
    public ResponseEntity bohui(String id,HttpSession session){
        Maintain oldMaintain = maintainService.getById(id);

        //状态为3 为驳回
        oldMaintain.setSatus("3");
        oldMaintain.updateById();

        User userInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(userInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("驳回");
        operationLog.setMsg("管理员驳回了"+oldMaintain.getNumber());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    @PostMapping("/tongguo")
    @ResponseBody
    public ResponseEntity tongguo(String id,HttpSession session){
        Maintain oldMaintain = maintainService.getById(id);

        //状态为4 为通过
        oldMaintain.setSatus("4");
        oldMaintain.updateById();

        User userInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(userInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("通过审核");
        operationLog.setMsg("管理员审核通过"+oldMaintain.getNumber());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }


    @GetMapping("/pingjia")
    public String pingjia(ModelMap modelMap,String id){
        modelMap.put("maintain", maintainService.getById(id));
        return "admin/maintain/pingjia";
    }

    @PostMapping("/pingjia")
    @ResponseBody
    public ResponseEntity pingjia(@RequestBody Maintain maintain,HttpSession session){
        Maintain oldMaintain = maintainService.getById(maintain.getId());

        User userInfo = (User) session.getAttribute("adminInfo");
        if (!userInfo.getId().equals(oldMaintain.getUserid2())){
            return ResponseEntity.failure("此维修单不是您创建的，您无法进行评价");
        }

        oldMaintain.setScore(maintain.getScore());
        oldMaintain.setEvaluate(maintain.getEvaluate());

        oldMaintain.updateById();

        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(userInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("评价");
        operationLog.setMsg("评价了编号为："+maintain.getNumber() +"的维修单；"+ "维修人员是：" + oldMaintain.getUsername());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    @GetMapping("/edit")
    public String edit(String id, ModelMap modelMap){
        Maintain maintain = maintainService.getById(id);
        modelMap.put("maintain", maintainService.getById(id));
        Tool tool = toolService.getById(maintain.getToolid());
        modelMap.put("maintain",maintain);
        modelMap.put("tool",tool);

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("role_name", "维修工");
        List<User> users = userService.list(userQueryWrapper);
        modelMap.put("userList", users);

        QueryWrapper<User> userQueryWrapper2 = new QueryWrapper<>();
        userQueryWrapper.eq("role_name", "员工");
        List<User> users2 = userService.list(userQueryWrapper2);
        modelMap.put("userList2", users2);

        return "admin/maintain/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity edit(@RequestBody Maintain maintain,HttpSession session){
        Maintain oldMaintain = maintainService.getById(maintain.getId());
        oldMaintain.setPlace(oldMaintain.getPlace());
        oldMaintain.setType(oldMaintain.getType());
        oldMaintain.setSatus(oldMaintain.getSatus());
        oldMaintain.setRemarks(oldMaintain.getRemarks());
        oldMaintain.setHandleTime(DateUtil.getDateByStr(maintain.getHandleTimeStr()));
        oldMaintain.setUserid2(maintain.getUserid2());
        User user2 = userService.getById(maintain.getUserid2());
        oldMaintain.setUsername2(user2.getUserName());
        oldMaintain.setUserid(maintain.getUserid());
        User user = userService.getById(maintain.getUserid());
        oldMaintain.setUsername(user.getUserName());
        oldMaintain.setScore(maintain.getScore());
        oldMaintain.setEvaluate(maintain.getEvaluate());
        oldMaintain.updateById();

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("编辑");
        operationLog.setMsg("管理员："+loginInfo.getUserName() + "编辑了编号为：" + maintain.getNumber() + "维修单");
        operationLogService.save(operationLog);
        return ResponseEntity.success(null);
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity del(String id,HttpSession session){
        Maintain maintain = maintainService.getById(id);
        maintain.setDelFlag(true);
        maintain.updateById();

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("删除");
        operationLog.setMsg("管理员："+loginInfo.getUserName() + "删除了编号为：" + maintain.getNumber() + "维修单");
        operationLogService.save(operationLog);
        return ResponseEntity.success(null);
    }

    @GetMapping( "/statics")
    public String toStatics(){
        return "admin/maintain/statics";
    }
    @GetMapping( "/statics2")
    public String toStatics2(){
        return "admin/maintain/statics2";
    }
    @GetMapping( "/statics3")
    public String toStatics3(){
        return "admin/maintain/statics3";
    }


    //管理员统计
    @ResponseBody
    @GetMapping( "/getStatics")
    public AjaxResult getStatics(String name){

        List<Map> list = maintainService.getStatics66(name);
        List<Map> result = new ArrayList<>();
        list.forEach(r->{
            Map map = new HashMap();
            if (r.get("status").equals("4")){
                map.put("name","未维修");
            }else if (r.get("status").equals("2")){
                map.put("name","已维修");
            }else if (r.get("status").equals("3")){
                map.put("name","驳回");
            }
            map.put("value",r.get("num"));
            result.add(map);
        });
        return AjaxResult.success(result);
    }


    @ResponseBody
    @GetMapping( "/getStatics1")
    public AjaxResult getStatics1(HttpSession session){
        User user = (User) session.getAttribute("adminInfo");

        List<Map> list = maintainService.getStatics1(user.getId());
        List<Integer> result = new ArrayList(12);
        for (int i = 0;i<12;i++){
            result.add(0);
        }
        for (int i =1;i<=12;i++){
            for (int j = 0;j<list.size();j++){
                if (i == Integer.parseInt(list.get(j).get("month").toString())){
                    result.add(i-1,Integer.parseInt(list.get(j).get("num").toString()));
                }
            };
        }
        return AjaxResult.success(result);
    }

    @ResponseBody
    @GetMapping( "/getStatics2")
    public AjaxResult getStatics2(HttpSession session){
        User user = (User) session.getAttribute("adminInfo");

        List<Map> list = maintainService.getStatics2(user.getId());


        List<Map> result = new ArrayList<>();
        list.forEach(r->{
            Map map = new HashMap();
            if (r.get("status").equals("1")){
                map.put("name","未维修");
            }else {
                map.put("name","已维修");
            }
            map.put("value",r.get("num"));
            result.add(map);
        });
        return AjaxResult.success(result);
    }

    @ResponseBody
    @GetMapping( "/getStatics3")
    public AjaxResult getStatics3(HttpSession session){
        User user = (User) session.getAttribute("adminInfo");

        List<Map> list = maintainService.getStatics3(user.getId());
        List<Integer> result = new ArrayList(12);
        for (int i = 0;i<12;i++){
            result.add(0);
        }
        for (int i =1;i<=12;i++){
            for (int j = 0;j<list.size();j++){
                if (i == Integer.parseInt(list.get(j).get("month").toString())){
                    result.add(i-1,Integer.parseInt(list.get(j).get("num").toString()));
                }
            };
        }
        return AjaxResult.success(result);
    }

    @ResponseBody
    @GetMapping( "/getStatics4")
    public AjaxResult getStatics4(HttpSession session){
        User user = (User) session.getAttribute("adminInfo");

        List<Map> list = maintainService.getStatics4(user.getId());

        List<Map> result = new ArrayList<>();
        list.forEach(r->{
            Map map = new HashMap();
            if (r.get("status").equals("1")){
                map.put("name","未维修");
            }else {
                map.put("name","已维修");
            }
            map.put("value",r.get("num"));
            result.add(map);
        });
        return AjaxResult.success(result);
    }

    @ResponseBody
    @GetMapping( "/getStatics5")
    public AjaxResult getStatics5(HttpSession session){
        User user = (User) session.getAttribute("adminInfo");

        List<Map> list = maintainService.getStatics5();

        List<Map> result = new ArrayList<>();
        list.forEach(r->{
            Map map = new HashMap();
            if (r.get("status").equals("4")){
                map.put("name","未维修");
            }else if (r.get("status").equals("2")){
                map.put("name","已维修");
            }else if (r.get("status").equals("3")){
                map.put("name","驳回");
            }

            map.put("value",r.get("num"));
            result.add(map);
        });
        return AjaxResult.success(result);
    }

    @ResponseBody
    @GetMapping( "/getStatics6")
    public AjaxResult getStatics6(){

        Map<String,List> result = maintainService.getStatics6();

        return AjaxResult.success(result);
    }

    @ResponseBody
    @GetMapping( "/getStatics7")
    public AjaxResult getStatics7(){
        List<Map> result = maintainService.getStatics8();
        return AjaxResult.success(result);
    }

}
