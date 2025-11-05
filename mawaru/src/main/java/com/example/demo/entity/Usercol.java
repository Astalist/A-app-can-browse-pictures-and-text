package com.example.demo.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (card)实体类
 *
 * @author kancy
 * @since 2024-12-02 19:07:49
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user217")
public class Usercol extends Model<Usercol> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * cardid
     */
    @TableId
    private Integer userloveid;


}