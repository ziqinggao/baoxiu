package com.spb.houqin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spb.houqin.admin.entity.Tool;
import com.spb.houqin.admin.mapper.ToolMapper;
import com.spb.houqin.admin.service.ToolService;
import org.springframework.stereotype.Service;


@Service
public class ToolServiceImpl extends ServiceImpl<ToolMapper, Tool> implements ToolService {
}
