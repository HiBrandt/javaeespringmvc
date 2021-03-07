package controller;

import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: javaeespringmvc
 * @description: TODO
 * @author: HiBrandt
 * @create: 2021-02-14 15:27
 **/


@Controller
public class ParamController {

    /**
     * 在springMVC获取客户端传递的数据的方式：
     * 1、在处理请求的方法中，加入相对应的形参，保证形参参数名和传递的数据的参数名保持一致，就可以自动赋值
     * value：当不满足赋值条件时，可以使用value属性，指定映射关系
     * required：设置形参是否必须被赋值，默认为true，必须赋值，若设置为false，则不必须赋值，因此形参的值为null
     * defaultValue：若形参所获得的值为null，则设置一个默认值，用在分页和模糊查询中
     */
    @RequestMapping(value = "param")
    public String param1(@RequestParam(value="username", required=false, defaultValue="lb")String name, String password, String age){
        System.out.println("username="+name+",password="+password+",age="+age);
        return "hello";
    }

    /**
     * 可以使用POJO获取客户端数据，要求实体类对象中的属性名一定要和页面中表单元素的name属性值一致，且支持级联关系（Address是User的属性）
     * 可以通过设置形参的方式，获取servletAPI
     */
	@RequestMapping(value="/param2", method=RequestMethod.POST)
	public String param(User user, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");  //方式①通过request获取参数
		System.out.println(user);  //方式②通过POJO user获取参数信息
		System.out.println(username);
		return "hello";
	}

    /**
     * 获取请求头信息
     * @RequestHeader：在处理请求的方法上，获取请求头信息，用法和@RequestParam一致
     */
	/*@RequestMapping(value="/param", method=RequestMethod.POST)
	public String param3(@RequestHeader("Accept-Language")String AcceptLanguage) {
		System.out.println("AcceptLanguage="+AcceptLanguage);
		return "hello";
	}*/

    /**
     * 获取Cookie信息
     * @CookieValue：在处理请求的方法上，获取cookie信息，用法和@RequestParam一致
     */
	/*@RequestMapping(value="/param", method= RequestMethod.POST)
	public String param4(@CookieValue(value="JSESSIONID")String JSESSIONID) {
		System.out.println("JSESSIONID="+JSESSIONID);
		return "hello";
	}*/

    /**
     * springMVC处理请求过程中，往作用域中放值有以下三种方式
     * 总结：根据ModelAndView源码调试，不管使用以下那种方式，最终都会把model数据和view数据封装到一个ModelAndView中
     */

    /*@RequestMapping(value="/param", method=RequestMethod.POST)
	public ModelAndView param() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "root");//往request作用域中放值
		mav.setViewName("hello");//设置视图名称，实现页面跳转
		return mav;
	}*/

	/*@RequestMapping(value="/param", method=RequestMethod.POST)
	public String param(Map<String, Object> map) {
		map.put("username", "admin");//向作用域中放值
		return "hello";//返回视图名称
	}*/

    /*@RequestMapping(value="/param", method=RequestMethod.POST)
    public String param(Model model, String username) {
        System.out.println(username);
        model.addAttribute("username", "张三");//向作用域中放值
        return "hello";//返回视图名称
    }*/


}
