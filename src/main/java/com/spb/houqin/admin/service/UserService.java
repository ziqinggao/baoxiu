package com.spb.houqin.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spb.houqin.admin.entity.User;

public interface UserService extends IService<User> {
    void lockUser(User user);

    void delete(User user);
}
