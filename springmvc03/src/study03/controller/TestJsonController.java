package study03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study03.bean.Employee;
import study03.dao.EmployeeDao;

import java.util.Collection;

/**
 * @program: javaeespringmvc
 * @description: TODO
 * @author: HiBrandt
 * @create: 2021-02-15 18:32
 *
 * json
 * 1.dispatchServerlet加上 mvc驱动。（加上驱动才能让jackson起作用：将java对象自动转换为json，不然jackson没有用）
 *     注意是自动就转了哦
 * 2.配置jackson 的jar包
 * 3.在controller加上注解@ResponseBody
 * 4.将要响应给客户端的数据作为方法的返回值 返回给客户端
 *
 *
 **/

@Controller
public class TestJsonController {

    @Autowired
    private EmployeeDao dao;

    @RequestMapping(value = "testJson") //没写method的话 post和get都可以访问
    @ResponseBody   //加上这个注解就意味着该响应方法不再作为页面的跳转而是作为响应体返回给客户端数据
    public Collection<Employee> testJson(){
        Collection<Employee> emps = dao.getAll();
        return emps;
    }

}
