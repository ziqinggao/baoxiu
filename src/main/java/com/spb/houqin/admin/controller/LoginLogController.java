package com.spb.houqin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spb.houqin.admin.entity.LoginLog;
import com.spb.houqin.admin.entity.User;
import com.spb.houqin.admin.service.LoginLogService;
import com.spb.houqin.admin.service.UserService;
import com.spb.houqin.common.base.PageData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;


//作用于模糊搜索处理
@Controller
@RequestMapping("admin/loginLog")
public class LoginLogController {


    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list() {
        return "admin/loginLog/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public PageData<LoginLog> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                   ServletRequest request) {


        String loginName = request.getParameter("loginName");
        String name = request.getParameter("name");


        QueryWrapper<LoginLog> loginLogQueryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(loginName)) {
            loginLogQueryWrapper.like("login_name", loginName);
        }
        loginLogQueryWrapper.orderByDesc("login_time");

        if (StringUtils.isNotEmpty(name)) {

            List<User> users = userService.list(new QueryWrapper<User>().like("user_name", name));
            if (users != null && users.size() > 0) {
                List<String> loginNames = new ArrayList<>();
                users.forEach(r -> {

                    loginNames.add(r.getLoginName());

                });
                loginLogQueryWrapper.in("login_name", loginNames);
            } else {
                loginLogQueryWrapper.in("login_name", "");
            }
        }
        loginLogQueryWrapper.eq("del_flag", 0);

        PageData<LoginLog> loginLogPageData = new PageData<>();
        IPage<LoginLog> loginLogIPage = loginLogService.page(new Page<>(page, limit), loginLogQueryWrapper);
        loginLogPageData.setCount(loginLogIPage.getTotal());
        loginLogPageData.setData(loginLogIPage.getRecords());
        return loginLogPageData;

    }

    @GetMapping("/add")
    public String add() {
        return "admin/tool/add";
    }


}
