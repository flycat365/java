package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Menu;
import com.example.demo.entity.User;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author your_author
 * @since 2024-11-05
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping("/list")
    public Result list(@RequestParam(value = "roleId", required = false, defaultValue = "") String roleId) {
        // 如果 roleId 是空字符串，返回所有菜单项
        if (roleId.isEmpty()) {
            List<Menu> list = menuService.lambdaQuery().list();
            if (list.isEmpty()) {
                return Result.fail();
            }
            return Result.suc(list);
        } else {
            // 使用 like 条件来匹配 menuRight 字段中的值
            List<Menu> list = menuService.lambdaQuery()
                    .like(Menu::getMenuRight, "%" + roleId + "%")
                    .list();
            if (list.isEmpty()) {
                return Result.fail();
            }
            return Result.suc(list);
        }
    }
}
