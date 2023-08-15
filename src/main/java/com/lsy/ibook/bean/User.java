package com.lsy.ibook.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * POJO: plain old java object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {
    @TableId(value = "yhbh",type = IdType.AUTO)
    private String yhbh;
    @TableField("yhm")
    private String yhm;
    private String pwd;
    private String yhnc;
    private String yhsf;
    private String sex;
    private String yhtx;
    private String sjh;
    private String email;
    private String zcsj;
}
