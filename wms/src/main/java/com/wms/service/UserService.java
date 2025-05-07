package com.wms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * <p>
 *  Service
 * </p>
 *
 * @author wms
 * @since 2025-05-01
 */
public interface UserService extends IService<User> {

    IPage<User> pageC(IPage<User> page);

    IPage<User> pageCC(Page<User> page, Wrapper wrapper);
}
