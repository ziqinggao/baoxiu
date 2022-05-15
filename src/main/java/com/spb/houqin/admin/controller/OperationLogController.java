package com.spb.houqin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spb.houqin.admin.entity.OperationLog;
import com.spb.houqin.admin.service.OperationLogService;
import com.spb.houqin.common.base.PageData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

@Controller
@RequestMapping("admin/operationLog")
public class OperationLogController {


    @Autowired
    private OperationLogService operationLogService;

    @GetMapping("/list")
    public String list(){
        return "admin/operationLog/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public PageData<OperationLog> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                       @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                       ServletRequest request){
        String userName = request.getParameter("userName");

        QueryWrapper<OperationLog> operationLogQueryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(userName)){
            operationLogQueryWrapper.like("user_name",userName);
        }

        operationLogQueryWrapper.eq("del_flag", 0);
        operationLogQueryWrapper.orderByDesc("action_time");

        PageData<OperationLog> operationLogPageData = new PageData<>();
        IPage<OperationLog> operationLogIPage = operationLogService.page(new Page<>(page,limit),operationLogQueryWrapper);
        operationLogPageData.setCount(operationLogIPage.getTotal());
        operationLogPageData.setData(operationLogIPage.getRecords());
        return operationLogPageData;
    }



}
