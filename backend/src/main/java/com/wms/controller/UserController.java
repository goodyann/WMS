package com.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.HashBiMap;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  frontendController
 * </p>
 *
 * @author wms
 * @since 2025-05-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    // Save
    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    // Modification
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user) {
        return userService.updateById(user);
    }

    // Save or Modify
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    // Delete
    @GetMapping("/delete")
    public boolean delete(Integer id) {
        return userService.removeById(id);
    }

    // Query
    @PostMapping("/query")
    public List<User> Query(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, user.getName());
        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
//    public List<User> ListPage(@RequestBody HashMap map) {
    public List<User> ListPage(@RequestBody QueryPageParam query) {
        System.out.println(query);
        System.out.println("num===" + query.getPageNum());
        System.out.println("size===" + query.getPageSize());

        HashMap param = query.getParam();
        String name = (String) param.get("name");
//        System.out.println("name===" + (String)param.get("name"));
//        System.out.println("no===" + (String)param.get("no"));
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(User::getName, user.getName());
//        return userService.list(lambdaQueryWrapper);

//        Page<User> page = new Page<>(1, 2);
        // or
        Page<User> page =  new Page<>();
//        page.setCurrent(1);
//        page.setPages(2);
        page.setCurrent(query.getPageNum());
        page.setPages(query.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);

        IPage<User> result = userService.page(page, lambdaQueryWrapper);
        System.out.println(result.getTotal());
        return result.getRecords();
    }

    @PostMapping("/listPageCC")
//    public List<User> ListPage(@RequestBody HashMap map) {
    public List<User> ListPageC(@RequestBody QueryPageParam query) {
        System.out.println(query);
        System.out.println("num===" + query.getPageNum());
        System.out.println("size===" + query.getPageSize());

        HashMap param = query.getParam();
        String name = (String) param.get("name");
//        System.out.println("name===" + (String)param.get("name"));
//        System.out.println("no===" + (String)param.get("no"));
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(User::getName, user.getName());
//        return userService.list(lambdaQueryWrapper);

//        Page<User> page = new Page<>(1, 2);
        // or
        Page<User> page =  new Page<>();
//        page.setCurrent(1);
//        page.setPages(2);
        page.setCurrent(query.getPageNum());
        page.setPages(query.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);

//        IPage<User> result = userService.pageC(page);
        IPage<User> result = userService.pageCC(page, lambdaQueryWrapper);
        System.out.println(result.getTotal());
        return result.getRecords();
    }

    @PostMapping(value = "/listPageCCC", produces = "application/json;charset=UTF-8")
//    public List<User> ListPage(@RequestBody HashMap map) {
    public Result ListPageCC(@RequestBody QueryPageParam query) {
        System.out.println(query);
        System.out.println("num===" + query.getPageNum());

        HashMap param = query.getParam();
        String name = (String) param.get("name");

        Page<User> page =  new Page<>();
        page.setCurrent(query.getPageNum());
        page.setPages(query.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);

        IPage<User> result = userService.pageCC(page, lambdaQueryWrapper);
        System.out.println(result.getTotal());
        return Result.suc(result.getTotal(), result.getRecords());
//        return Result.suc();
    }

//    @GetMapping("/test")
//    public Result test() {
//        return Result.suc("test data");
//    }

}
