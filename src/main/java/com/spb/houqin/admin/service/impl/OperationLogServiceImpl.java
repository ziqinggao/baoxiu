package com.spb.houqin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spb.houqin.admin.entity.OperationLog;
import com.spb.houqin.admin.mapper.OperationLogMapper;
import com.spb.houqin.admin.service.OperationLogService;
import org.springframework.stereotype.Service;


@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {
}
