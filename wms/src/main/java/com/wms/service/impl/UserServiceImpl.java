package com.wms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.entity.User;
import com.wms.mapper.UserMapper;
import com.wms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * <p>
 *  Service IMplementation
 * </p>
 *
 * @author wms
 * @since 2025-05-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public IPage<User> pageC(IPage<User> page) {
        return userMapper.pageC(page);
    }

    @Override
    public IPage<User> pageCC(Page<User> page, Wrapper wrapper) {
        return userMapper.pageCC(page, wrapper);
    }
}
