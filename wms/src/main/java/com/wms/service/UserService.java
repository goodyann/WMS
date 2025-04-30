package com.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> listAll();
}
