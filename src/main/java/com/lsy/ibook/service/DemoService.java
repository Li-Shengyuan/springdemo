package com.lsy.ibook.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsy.ibook.bean.User;
import com.lsy.ibook.dao.DemoMapper;
import org.springframework.stereotype.Service;

@Service
public class DemoService extends ServiceImpl<DemoMapper, User> {

}
