package com.example.demo.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (userinfo)实体类
 *
 * @author kancy
 * @since 2024-12-02 14:15:36
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("userinfo")
public class Userinfo extends Model<Userinfo> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * userid
     */
    @TableId
	private String userid;
    /**
     * username
     */
    private String username;
    /**
     * userpassword
     */
    private String userpassword;
    /**
     * userpic
     */
    private String userpic;

}