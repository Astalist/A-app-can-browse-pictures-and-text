package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.demo.entity.Card;
import com.example.demo.entity.Usercol;
import com.example.demo.mapper.CardMapper;
import com.example.demo.mapper.UsercolMapper;
import com.example.demo.mapper.UserinfoMapper;
import com.example.demo.util.CloudUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 服务控制器
 *
 * @author kancy
 * @since 2024-12-02 19:07:49
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/card")
public class CardController{
    @Autowired
    CardMapper cardMapper;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    UsercolMapper usercolMapper;

    @ResponseBody
    @GetMapping("/all")
    public List<Card> getAllCard() {
//        System.out.println(cardMapper.selectList(null));
        return cardMapper.selectList(null);
    }

    @ResponseBody
    @PostMapping("/picupdata")
    public Integer updataCard(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            String res=CloudUtil.upload(file);
            String text="";
            String id="";
            Card card=new Card();
            card.setCardpicurl(res);
            card.setCardgoodcnt(0);
            card.setCardtext(text);
            card.setUserid(id);
            cardMapper.insert(card);

            return card.getCardid();
        }
        else{
            System.out.println("error");
        }
        return 0;
    }


    @ResponseBody
    @PutMapping("/textupdata")
    public HashMap updataText(@RequestBody  Card card) throws IOException {
        HashMap result = new HashMap();
        result .put("success",false);
        LambdaUpdateWrapper<Card> uu =new LambdaUpdateWrapper<Card>();
        uu.eq(Card::getCardid,card.getCardid()).set(Card::getCardtext,card.getCardtext()).set(Card::getUserid,card.getUserid());
        int i=cardMapper.update(null,uu);
        if(i==1){
            result.put("success",true);
        }
        return result;
    }


    @ResponseBody
    @GetMapping("/good")
    public List<Usercol> getGoodCard() {
        List<Usercol> idlist = usercolMapper.selectList(null);
        return idlist;
    }

    @ResponseBody
    @PostMapping("/addgood")
    public HashMap addGoodCard(@RequestBody Usercol usercol) {
        HashMap result = new HashMap();
        result.put("success",false);
        int i = usercolMapper.insert(usercol);

        Card card = cardMapper.selectById(usercol.getUserloveid());
        if(card!=null){
            LambdaUpdateWrapper<Card> uu =new LambdaUpdateWrapper<Card>();
            uu.eq(Card::getCardid,card.getCardid()).set(Card::getCardgoodcnt,card.getCardgoodcnt()+1);
            cardMapper.update(null, uu);
        }


        if(i==1){
            result.put("success",true);
        }
        return result;
    }

    @ResponseBody
    @DeleteMapping("/delgood")
    public HashMap delGoodCard(@RequestBody Usercol usercol) {
        HashMap result = new HashMap();
        result.put("success",false);
        QueryWrapper<Usercol> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userloveid",usercol.getUserloveid());
        int i= usercolMapper.delete(queryWrapper);

        Card card = cardMapper.selectById(usercol.getUserloveid());
        if(card!=null){
            LambdaUpdateWrapper<Card> uu =new LambdaUpdateWrapper<Card>();
            uu.eq(Card::getCardid,card.getCardid()).set(Card::getCardgoodcnt,card.getCardgoodcnt()-1);
            cardMapper.update(null, uu);
        }

        if(i==1){
            result.put("success",true);
        }
        return result;
    }


    @ResponseBody
    @PostMapping("/mycard")
    public List<Card> getMyCard(@RequestBody HashMap<String, String> params) {
        String userid = params.get("userId");  // 获取 userId（String 类型）
        List<Card> cardlist = cardMapper.selectList(new QueryWrapper<Card>().eq("userid", userid));
        return cardlist;
    }




    @ResponseBody
    @DeleteMapping("/delmycard")
    public HashMap delMyCard(@RequestBody HashMap<String, String> params) {
        HashMap result = new HashMap();
        result .put("success",false);
        String cardidStr = params.get("cardid");
        String userid = params.get("userid");
        Integer cardid = Integer.valueOf(cardidStr);
        int i = cardMapper.delete(new QueryWrapper<Card>().eq("cardid", cardid).eq("userid", userid));
        if(i==1){
            result.put("success",true);
        }
        return result;
    }

}