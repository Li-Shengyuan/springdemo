package com.lsy.ibook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsy.ibook.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper extends BaseMapper<User> {

}