package com.example.demo.dao;

import lombok.extern.slf4j.Slf4j;
import com.example.demo.entity.Card;
import com.example.demo.mapper.CardMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * (card)数据DAO
 *
 * @author kancy
 * @since 2024-12-02 19:07:49
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@Repository
public class CardDao extends ServiceImpl<CardMapper, Card> {

}