package com.example.demo.service.impl;

import com.example.demo.dao.CardDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.service.CardService;
import org.springframework.stereotype.Service;

/**
 * 服务接口实现
 *
 * @author kancy
 * @since 2024-12-02 19:07:49
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {
    private final CardDao cardDao;

}