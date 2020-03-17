package com.bjsxt.controller;

import com.bjsxt.pojo.Demo;
import com.bjsxt.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.util.List;

@Controller
public class DemoController {
//    @RequestMapping("demo")
//    public String demo(@RequestParam(value = "name1") String name,@RequestParam(value = "age1")int age){
//        System.out.println("执行demo"+name+"  "+age );
//        return "main.jsp";
//    }

    @RequestMapping("demo")
    public String demo(People peo, HttpServletRequest req){
        System.out.println("执行demo" + peo);
        req.setAttribute("demo123","测试");
        return "main.jsp";
    }

    @RequestMapping("page")
    public String page(@RequestParam(defaultValue = "2")int pageSize,@RequestParam(defaultValue = "1")int pageNumber){
        System.out.println(pageSize+" "+pageNumber);
        return "main.jsp";

    }
    @RequestMapping("demo2")
    public String demo2(@RequestParam(required = true)String name){
        System.out.println("name 是 SQL 的查询条件,必须要传 递 name 参数"+name);
        return "main.jsp";
    }

    //    @RequestMapping("demo2")
    //    public String demo2(){
    //        System.out.println("demo2");
    //        return "main1.jsp";
    //    }

    @RequestMapping("demo5")
    public String demo5(String name, int age, @RequestParam("hover")List<String> abc){
        System.out.println(name + " " + age + " " + abc);
        return "main.jsp";
    }

    @RequestMapping("demo6")
    public String demo6(Demo demo){
        System.out.println(demo);
        return "main.jsp";
    }

    @RequestMapping("demo8/{id1}/{name}")
    public String demo8(@PathVariable String name, @PathVariable("id1") int age){
        System.out.println(name + "  " + age);
        return "/main.jsp";
    }

    @RequestMapping("demo9")
    public String demo9(){
        System.out.println("转发");
        return "redirect:/main.jsp";
    }

    @RequestMapping("demo10")
    public String demo10(){
        return "forward:demo11";
    }

    @RequestMapping("demo11")
    public String demo11(){
        System.out.println("demo11");
        return "main";
    }

    @RequestMapping(value = "demo12")
    @ResponseBody
    public People demo12(){
        People p = new People();
        p.setAge(12);
        p.setName("张三");
        return p;
    }


}
