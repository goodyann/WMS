package com.wms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
