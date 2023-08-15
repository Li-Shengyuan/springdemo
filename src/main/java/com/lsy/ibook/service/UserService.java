package com.lsy.ibook.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lsy.ibook.bean.User;
import com.lsy.ibook.dao.UserMapper;
import com.lsy.ibook.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user){
       return userMapper.insert(user) > 0;
    }

    public boolean deleteById(Integer id){
        return userMapper.deleteById(id) > 0;
    }

    public boolean updateUser(User user){
        return userMapper.updateById(user) > 0;
    }

    public User selectUser(User user){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("yhm",user.getYhm())
                .eq("pwd",user.getPwd());
        return userMapper.selectOne(wrapper);
    }

    public ArrayList<User> listUsers(User u){
        //wrapper: 封装查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(StringUtil.isNotEmpty(u.getYhm())){
            wrapper.like("yhm",u.getYhm());
        }
        if(StringUtil.isNotEmpty(u.getZcsj())){
            wrapper.like("zcsj",u.getZcsj());
        }
        if(StringUtil.isNotEmpty(u.getYhsf())){
            wrapper.eq("yhsf",u.getYhsf());
        }
        if(StringUtil.isNotEmpty(u.getSjh())){
            wrapper.like("sjh",u.getSjh());
        }
        if(StringUtil.isNotEmpty(u.getEmail())){
            wrapper.like("email",u.getEmail());
        }
        if(StringUtil.isNotEmpty(u.getSex())){
            wrapper.eq("sex",u.getSex());
        }
        //执行查询
        ArrayList<User> list = (ArrayList<User>) userMapper.selectList(wrapper);
        for(User user : list){
           if(StringUtil.isNotEmpty(user.getYhsf())){
               if(user.getYhsf().equals("1")){
                   user.setYhsf("管理员");
               }else if(user.getYhsf().equals("2")){
                   user.setYhsf("普通管理员");
               }else if(user.getYhsf().equals("3")){
                   user.setYhsf("买家");
               }
           }
        }
        //返回查询结果
        return list;
    }

    public boolean selectByYhm(String yhm){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("yhm",yhm);
        return userMapper.exists(wrapper);
    }
}
