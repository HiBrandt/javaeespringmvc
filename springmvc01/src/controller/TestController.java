package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: javaeespringmvc
 * @description: TODO
 * @author: HiBrandt
 * @create: 2021-01-04 21:53
 **/
@Controller
//@RequestMapping("/mvc")
public class TestController {


    /**
     * @RequestMapping:设置请求映射，把请求和控制层中的方法设置映射的关系
     * 当请求路径和@RequestMapping的value属性值一致时，则该注解所标注的方法即为处理请求的方法
     * @RequestMapping可以加在类上，也可以加在方法上
     * 若类和方法上都加得有，应该一层一层的访问，先访问类，在访问类中的方法
     * @RequestMapping属性：
     * ①method：用来设置请求方式，只有客户端发送请求的方式和method的值一致，才能处理请求。 (超链接是get 表单提交是post)
     * ②params:用来设置客户端传到服务器的数据，支持表达式
     */

    @RequestMapping(value="hello"
            /*method=RequestMethod.POST,
			params= {"username","age!=12"}*/)
    public String name() {

        System.out.println("Success");
        return "hello";
    }

    /**
     * springMVC支持Ant方式的请求路径
     * 在Ant中，有3中匹配符
     * *:任意字符
     * ?:任意一个字符
     * **:任意多层目录
     */
    @RequestMapping(value="/*/ant??/**/testAnt")
    public String testAnt() {
        System.out.println("SUCCESS:testAnt");
        return "hello";
    }

    /**
     * 映射请求占位符
     * 以前：localhost:8080/springMVC01/testREST?id=1001&username=admin
     * 现在：localhost:8080/springMVC01/testREST/1001/admin
     */
    @RequestMapping("/testREST/{id}/{username}")
    public String testREST(@PathVariable("id")Integer id, @PathVariable("username")String username) {
        System.out.println("id:"+id+",username="+username);
        return "hello";
    }

}
