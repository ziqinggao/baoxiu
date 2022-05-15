package com.spb.houqin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spb.houqin.admin.entity.LoginLog;
import com.spb.houqin.admin.entity.User;
import com.spb.houqin.admin.service.LoginLogService;
import com.spb.houqin.admin.service.UserService;
import com.spb.houqin.common.base.ResponseEntity;
import com.spb.houqin.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;


@RequestMapping("admin")
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;


    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user, HttpSession session) throws UnknownHostException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("login_name", user.getLoginName());
        User oldUser = userService.getOne(userQueryWrapper);

        LoginLog loginLog = new LoginLog();

        //新建InetAddress读取ip 以string承接
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
//        String md5Str = MD5Util.getMD5Str(user.getPassword());

        if (oldUser == null) {
            loginLog.setLoginName(user.getLoginName());

            loginLog.setIp(ip);
//            loginLog.getIp("127.0.0.1");
            loginLog.setMsg("登录失败");
            loginLog.setReason("用户不存在");
            loginLog.setLoginTime(new Date());
            loginLogService.save(loginLog);
            return ResponseEntity.failure("用户不存在");
        }

        if (!oldUser.getPassword().equals(user.getPassword())) {
            loginLog.setLoginName(user.getLoginName());
            loginLog.setIp(ip);
            loginLog.setMsg("登录失败");
            loginLog.setReason("密码不正确");
            loginLog.setLoginTime(new Date());
            loginLogService.save(loginLog);
            return ResponseEntity.failure("密码不正确");
        }

        if (oldUser.getLocked()) {
            loginLog.setLoginName(user.getLoginName());
            loginLog.setIp(ip);
            loginLog.setMsg("登录失败");
            loginLog.setReason("该账户被锁定");
            loginLog.setLoginTime(new Date());
            loginLogService.save(loginLog);
            return ResponseEntity.failure("该账户被锁定");
        }

        if (oldUser.getDelFlag()) {
            loginLog.setLoginName(user.getLoginName());
            loginLog.setIp(ip);
            loginLog.setMsg("登录失败");
            loginLog.setReason("该用户已删除");
            loginLog.setLoginTime(new Date());
            loginLogService.save(loginLog);
            return ResponseEntity.failure("该用户已删除");
        }


        session.setAttribute("adminInfo", oldUser);

        loginLog.setLoginName(user.getLoginName());
        loginLog.setIp(ip);
        loginLog.setMsg("登录成功");
        loginLog.setLoginTime(new Date());
        loginLogService.save(loginLog);
        return ResponseEntity.success(null);

    }

    @GetMapping("/exit")
    public String adminExit(HttpSession session) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();

        User user = (User) session.getAttribute("adminInfo");
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginName(user.getLoginName());
        loginLog.setIp(ip);
        loginLog.setMsg("退出登录");
        loginLog.setLoginTime(new Date());
        loginLogService.save(loginLog);

        session.removeAttribute("adminInfo");
        return "admin/login";
    }



}
