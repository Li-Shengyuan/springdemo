package com.lsy.ibook;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsy.ibook.bean.User;
import com.lsy.ibook.dao.DemoMapper;
import com.lsy.ibook.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringdemoApplicationTests {
    @Autowired
    DemoService demoService;

    @Autowired
    DemoMapper demoMapper;

    @Test
    void test2(){
        int pageNo = 2;
        Page<User> page = demoMapper.selectPage(new Page<>(pageNo, 10), null);
        long total = page.getTotal();
        List<User> list = page.getRecords();
        System.out.println(total);
        list.forEach(System.out::println);
    }

    @Test
    void test(){
/*        User user = new User();
        user.setYhm("aabb");
        user.setYhbh("35");
//        demoService.save(user);

        demoService.removeById(user);

        user.setYhbh("34");
        demoService.updateById(user);*/

        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.like("yhm","a").eq("yhsf","1");
        List<User> list = demoService.list(wrapper);
        list.forEach(System.out::println);
    }

}
