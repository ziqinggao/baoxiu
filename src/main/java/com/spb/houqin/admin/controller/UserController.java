package com.spb.houqin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spb.houqin.admin.entity.OperationLog;
import com.spb.houqin.admin.entity.Password;
import com.spb.houqin.admin.entity.User;
import com.spb.houqin.admin.service.OperationLogService;
import com.spb.houqin.admin.service.UserService;
import com.spb.houqin.common.base.PageData;
import com.spb.houqin.common.base.ResponseEntity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OperationLogService operationLogService;

    @GetMapping("/list")
    public String list(){
        return "admin/user/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public PageData<User> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                               @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                               ServletRequest request){
        String userName = request.getParameter("userName");
        String locked = request.getParameter("locked");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String delFlag = request.getParameter("delFlag");

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(userName)){
            userQueryWrapper.like("user_name",userName);
        }
        if(StringUtils.isNotEmpty(locked)){
            userQueryWrapper.eq("locked",locked);
        }
        if(StringUtils.isNotEmpty(phone)){
            userQueryWrapper.like("phone",phone);
        }
        if(StringUtils.isNotEmpty(sex)){
            userQueryWrapper.like("sex",sex);
        }
        if (StringUtils.isNotEmpty(delFlag)){
            userQueryWrapper.eq("del_flag",delFlag);
        }

        userQueryWrapper.in("role_name","??????","?????????");

        PageData<User> userPageData = new PageData<>();
        IPage<User> userIPage = userService.page(new Page<>(page,limit),userQueryWrapper);
        userPageData.setCount(userIPage.getTotal());
        userPageData.setData(userIPage.getRecords());
        return userPageData;
    }

    @PostMapping("lock")
    @ResponseBody
    public ResponseEntity lock(@RequestParam(value = "id", required = false) String id, HttpSession session) {
        if (org.apache.commons.lang3.StringUtils.isBlank(id)) {
            return ResponseEntity.failure("????????????");
        }
        User user = userService.getById(id);
        if (user == null) {
            return ResponseEntity.failure("???????????????");
        }
        userService.lockUser(user);

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("??????");
        operationLog.setMsg(loginInfo.getUserName() + "??????????????????" + user.getUserName());
        operationLogService.save(operationLog);
        return ResponseEntity.success("????????????");
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity delelte(String id,HttpSession session){
        User user = userService.getById(id);
        userService.delete(user);

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("??????");
        operationLog.setMsg(loginInfo.getUserName() + "??????????????????" + user.getUserName());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    /**
     * ??????
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "admin/user/add";
    }

    @PostMapping("add")
    @ResponseBody
    public ResponseEntity add(@RequestBody User user,HttpSession session){

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("login_name",user.getLoginName());
        List<User> userList = userService.list(userQueryWrapper);
        if(CollectionUtils.isNotEmpty(userList)){
            return ResponseEntity.failure("?????????????????????");
        }

        user.setLocked(false);
        user.setDelFlag(false);
        user.setCreateDate(new Date());
        userService.save(user);

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("??????");
        operationLog.setMsg(loginInfo.getUserName() + "??????????????????" + user.getUserName());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    @GetMapping("edit")
    public String edit(String id, ModelMap modelMap){
        modelMap.put("user",userService.getById(id));
        return "admin/user/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    public ResponseEntity edit(@RequestBody User user,HttpSession session){
        Integer age = user.getAge();
        if(age < 18 || age > 70){
            return ResponseEntity.failure("???????????????18-70??????");
        }
        User oldUser = userService.getById(user.getId());

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("login_name",user.getLoginName());
        List<User> userList = userService.list(userQueryWrapper);
        for (User u : userList) {
            //??????loginName
            if(u.getLoginName().equals(user.getLoginName()) && !u.getLoginName().equals(oldUser.getLoginName())){
                return ResponseEntity.failure("?????????????????????");
            }
        }
        oldUser.setUserName(user.getUserName());
        oldUser.setLoginName(user.getLoginName());
        oldUser.setPhone(user.getPhone());
        oldUser.setSex(user.getSex());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setRoleName(user.getRoleName());
//        oldUser.setUpdateDate(new Date());
        userService.updateById(oldUser);

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("??????");
        operationLog.setMsg(loginInfo.getUserName() + "??????????????????" + user.getUserName());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    @GetMapping("/self")
    public String self(HttpSession session,ModelMap modelMap){
        User user = (User) session.getAttribute("adminInfo");
        modelMap.put("selfInfo",userService.getById(user.getId()));
        return "admin/self";
    }

    @PostMapping("update")
    @ResponseBody
    public ResponseEntity update(@RequestBody User user,HttpSession session){
        User oldUser = userService.getById(user.getId());
        oldUser.setUserName(user.getUserName());
        oldUser.setLoginName(user.getLoginName());
        oldUser.setPhone(user.getPhone());
        oldUser.setSex(user.getSex());
        oldUser.setAge(user.getAge());
        oldUser.setRoleName(user.getRoleName());
//        oldUser.setUpdateDate(new Date());
        userService.updateById(oldUser);

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("??????");
        operationLog.setMsg(loginInfo.getUserName() + "??????????????????" + oldUser.getUserName());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    @PostMapping("updatePassword")
    @ResponseBody
    public ResponseEntity update(@RequestBody Password password, HttpSession session){


      User user = (User) session.getAttribute("adminInfo");
        if (!user.getPassword().equals(password.getOldPassword())){
            return ResponseEntity.failure("???????????????");
        }

        if (!password.getNewPassword().equals(password.getEnsurePassword())){
            return ResponseEntity.failure("??????????????????");
        }

        user.setPassword(password.getNewPassword());
        userService.updateById(user);

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("????????????");
        operationLog.setMsg(loginInfo.getUserName() + "???????????????" + user.getUserName() + "?????????");
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    @RequestMapping("/lockAll")
    @ResponseBody
    public ResponseEntity lockAll(){
        List<User> userList = userService.list(null);
        userList.forEach(r->{
            r.setLocked(true);
            r.updateById();
        });
        return ResponseEntity.success(null);
    }


}
