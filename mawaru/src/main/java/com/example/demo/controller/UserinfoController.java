package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.UserinfoMapper;
import com.example.demo.service.UserinfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 服务控制器
 *
 * @author kancy
 * @since 2024-12-02 14:15:36
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/userinfo")
public class UserinfoController{
    @Autowired
    UserinfoMapper userinfoMapper;

    @ResponseBody
    @PostMapping("/login")
    public Userinfo login(@RequestBody Userinfo userinfo){
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userinfo.getUserid())
                    .eq("userPassword",userinfo.getUserpassword());
        Userinfo user = userinfoMapper.selectOne(queryWrapper);
        if(user != null){
            System.out.println(user.getUsername());
            return user;
        }else{
            System.out.println("没有值");
            return null;
        }
    }
}