package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.QueryPageParam;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author your_author
 * @since 2024-10-30
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public List<User> List(){
        return userService.list();
    }


    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }
    @PostMapping("/save1")
    public boolean saveOrMod(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
//    @PostMapping("/listp")
//    public Res listP(@RequestBody User user) {
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        if (user != null && StringUtils.isNotBlank(user.getName())) {
//            lambdaQueryWrapper.like(User::getName, user.getName());
//        }
//        return userService.list(lambdaQueryWrapper);
//    }

    @PostMapping("/listPage")
    public Result listP(@RequestBody QueryPageParam query) {
        System.out.println(query);

        HashMap<String, Object> param = query.getParam();
        String name = param != null ? (String) param.get("name") : null;

        System.out.println("name===" + name);

        // 检查分页参数
        int pageSize = query.getPageSize() > 0 ? query.getPageSize() : 10;
        int pageNum = query.getPageNum() > 0 ? query.getPageNum() : 1;

        Page<User> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (name != null) {
            lambdaQueryWrapper.like(User::getName, name);
        }

        IPage<User> result = userService.page(page, lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());

        // 使用 Result 类构建响应对象
        return Result.suc(result.getRecords(), result.getTotal());
    }
    @PostMapping("/listPagec")
//    public List<User> listP(@RequestBody User user){
    public List<User> listPc(@RequestBody QueryPageParam query){
        System.out.println(query);

        HashMap param = query.getParam();
        String name = (String)param.get("name");

        System.out.println("name==="+ (String)param.get("name"));
        //System.out.println("size==="+query.getPageSize());


//        System.out.println("name===" + (String)param.get("name"));
//        System.out.println("no===" + (String)param.get("no"));
//        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper();
//        lambdaQueryWrapper.like(User::getName,user.getName());
//        return userService.list(lambdaQueryWrapper);
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(User::getName, name);

//        IPage result = userService.pagec(page);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName, name);
        IPage result = userService.pagecc(page,lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());

        return result.getRecords();
    }
    @PostMapping("/listPagec1")
//    public List<User> listP(@RequestBody User user){
    public Result  listPc1(@RequestBody QueryPageParam query){
        System.out.println(query);

        HashMap param = query.getParam();
        String name = (String)param.get("name");

        System.out.println("name==="+ (String)param.get("name"));
        //System.out.println("size==="+query.getPageSize());


//        System.out.println("name===" + (String)param.get("name"));
//        System.out.println("no===" + (String)param.get("no"));
//        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper();
//        lambdaQueryWrapper.like(User::getName,user.getName());
//        return userService.list(lambdaQueryWrapper);
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(User::getName, name);

//        IPage result = userService.pagec(page);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName, name);
        IPage result = userService.pagecc(page,lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());

        return Result.suc(result.getRecords(), result.getTotal());
    }
}
