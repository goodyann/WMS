package com.wms.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p>
 *  Mapper Interface
 * </p>
 *
 * @author wms
 * @since 2025-05-01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage<User> pageC(IPage<User> page);

    IPage<User> pageCC(Page<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
