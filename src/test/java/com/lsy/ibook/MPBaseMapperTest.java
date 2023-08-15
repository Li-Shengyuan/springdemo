package com.lsy.ibook;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lsy.ibook.bean.User;
import com.lsy.ibook.dao.DemoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MPBaseMapperTest {
    @Autowired
    DemoMapper userMapper;

    @Test
    void testSelect(){
        User user = new User();
        user.setYhm("dufu");
        user.setPwd("123456");

        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("yhm","lisi");
        boolean ret = userMapper.exists(wrapper);
        System.out.println(ret);
    }

    @Test
    void test1(){
        User user = userMapper.selectById(1);
//        demoMapper.deleteById(1);
        user.setYhbh(null);
        user.setYhm("aaa");
        int ret = userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    void test2(){
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("pwd","123456").eq("sex","男");
        userMapper.selectList(wrapper);
    }

    @Test
    void test3(){
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.like("yhm","a");
        wrapper.select("yhm","pwd");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    void test4(){
        UpdateWrapper<User> wrapper = Wrappers.update();
        wrapper.like("yhm","a");

        User user = null;
        userMapper.update(user,wrapper);
    }
}
