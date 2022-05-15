package com.spb.houqin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spb.houqin.admin.entity.User;
import com.spb.houqin.admin.mapper.UserMapper;
import com.spb.houqin.admin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public void lockUser(User user) {
        user.setLocked(!user.getLocked());
        user.updateById();
    }

    @Override
    public void delete(User user) {
        user.setDelFlag(true);
        user.updateById();
    }
}
