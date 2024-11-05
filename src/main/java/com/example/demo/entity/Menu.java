package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author your_author
 * @since 2024-11-05
 */
@Getter
@Setter
@TableName("menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    /**
     * 菜单编码
     */
    @TableField("menuCode")
    private String menuCode;

    /**
     * 菜单名字
     */
    @TableField("menuName")
    private String menuName;

    /**
     * 菜单级别
     */
    @TableField("menuLevel")
    private String menuLevel;

    /**
     * 菜单的父code
     */
    @TableField("menuParentCode")
    private String menuParentCode;

    /**
     * 点击触发的函数
     */
    @TableField("menuClick")
    private String menuClick;

    /**
     * 权限0超级管理员,1表示管理员,2表示普通用户,可以用逗号组合使用
     */
    @TableField("menuRight")
    private String menuRight;

    @TableField("menuComponent")
    private String menuComponent;

    @TableField("menuIcon")
    private String menuIcon;
}
