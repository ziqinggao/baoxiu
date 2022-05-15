package com.spb.houqin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spb.houqin.admin.entity.LoginLog;
import com.spb.houqin.admin.mapper.LoginLogMapper;
import com.spb.houqin.admin.service.LoginLogService;
import org.springframework.stereotype.Service;


@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
}
