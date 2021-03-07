package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: javaeespringmvc
 * @description: TODO
 * @author: HiBrandt
 * @create: 2021-02-14 10:50
 *
 * 处理增删改查 但是没办法处理 改和删 （增是post请求 查是get服务端都可以识别）
 * 那就用HiddenHttpMethodFilter 来处理改和删 对请求在进行相应之前作出处理 可以看web.xml的注释
 *
 *
 *
 *
 **/
@Controller
public class RESTController {

    //查
    @RequestMapping(value = "testRESTGet/{id}",method = RequestMethod.GET)
    public String restGET(@PathVariable(value="id") Integer id){
        System.out.println(id);
        return "hello";
    }
    //增
    @RequestMapping(value = "testRESTPost",method = RequestMethod.POST)
    public String restPOST(){
        return "hello";
    }

    // PUT 改
    @RequestMapping(value = "testRESTPost",method = RequestMethod.PUT)
   // @ResponseBody()
    public String restPUT(){
        return "hello";
    }
    // DETLTE 删
    @RequestMapping(value = "testRESTDelete/{id}",method = RequestMethod.DELETE)
   // @ResponseBody()
    public String restDETLTE(@PathVariable(value="id") Integer id){
        System.out.println(id);
        return "hello";
    }



}
