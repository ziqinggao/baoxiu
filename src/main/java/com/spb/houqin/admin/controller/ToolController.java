package com.spb.houqin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spb.houqin.admin.entity.OperationLog;
import com.spb.houqin.admin.entity.Tool;
import com.spb.houqin.admin.entity.User;
import com.spb.houqin.admin.service.OperationLogService;
import com.spb.houqin.admin.service.ToolService;
import com.spb.houqin.common.base.PageData;
import com.spb.houqin.common.base.ResponseEntity;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/tool")
public class ToolController {


    @Autowired
    private ToolService toolService;

    @Autowired
    private OperationLogService operationLogService;

    @GetMapping("/list")
    public String list(){
        return "admin/tool/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public PageData<Tool> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                               @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                               ServletRequest request){
        String name = request.getParameter("name");

        QueryWrapper<Tool> toolQueryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(name)){
            toolQueryWrapper.like("name",name);
        }
        toolQueryWrapper.eq("del_flag", 0);

        PageData<Tool> toolPageData = new PageData<>();
        IPage<Tool> toolIPage = toolService.page(new Page<>(page,limit),toolQueryWrapper);
        toolPageData.setCount(toolIPage.getTotal());
        toolPageData.setData(toolIPage.getRecords());
        return toolPageData;
    }

    @GetMapping("/add")
    public String add(){
        return "admin/tool/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity add(@RequestBody Tool tool, HttpSession session){

        QueryWrapper<Tool> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",tool.getName());
        List<Tool> toolList = toolService.list(queryWrapper);
        if (toolList.size() > 0){
            return ResponseEntity.failure("该工具已存在");
        }

        tool.setCreateDate(new Date());
        toolService.save(tool);

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("添加");
        operationLog.setMsg(loginInfo.getUserName() + "添加了工具：" + tool.getName());
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

    @GetMapping("/edit")
    public String edit(String id, ModelMap modelMap){
        Tool tool = toolService.getById(id);
        modelMap.put("tool",tool);
        return "admin/tool/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity edit(@RequestBody Tool tool,HttpSession session){

        QueryWrapper<Tool> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",tool.getName());
        List<Tool> toolList = toolService.list(queryWrapper);
        if (toolList.size() > 1){
            return ResponseEntity.failure("该工具已存在");
        }

        Tool oldTool = toolService.getById(tool.getId());
//        oldTool.setUpdateDate(new Date());
        oldTool.setAmount(tool.getAmount());
        oldTool.setMoney(tool.getMoney());
        oldTool.setName(tool.getName());
        oldTool.setImg(tool.getImg());
        oldTool.updateById();

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("编辑");
        operationLog.setMsg(loginInfo.getUserName() + "编辑了工具：" + tool.getName());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity del(String id,HttpSession session){
        Tool tool = toolService.getById(id);
        tool.setDelFlag(true);
        tool.updateById();

        User loginInfo = (User) session.getAttribute("adminInfo");
        OperationLog operationLog = new OperationLog();
        operationLog.setUserName(loginInfo.getUserName());
        operationLog.setActionTime(new Date());
        operationLog.setAction("删除");
        operationLog.setMsg(loginInfo.getUserName() + "删除了工具：" + tool.getName());
        operationLogService.save(operationLog);

        return ResponseEntity.success(null);
    }

}
