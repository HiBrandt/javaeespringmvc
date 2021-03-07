package study03.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import study03.bean.Teacher;

/**
 * @program: javaeespringmvc
 * @description: TODO
 * @author: HiBrandt
 * @create: 2021-02-16 11:20
 *
 * 拦截器：也可以使用拦截器对请求进行拦截处理，用户可以自定义拦截器来实现特定的功能
 * 执行流程： 请求-->监听器-->过滤器-->DispatchServerlet-->拦截器-->Controller
 * 其中拦截器分为三个方法：
 *   ①	preHandle()：作用在Controller之前
 *   ②	postHandle()：作用在Controller return之前(向客户端返回响应前被调用)
 *   ③	afterCompletion():作用在return后了，常用于对资源的一些操作
 * 自定义拦截器需要在配置文件中配置:
 *   <mvc:interceptors>
    <!-- 声明自定义拦截器 -->
     <bean id="firstHandlerInterceptor"
    class="com.atguigu.springmvc.interceptors.FirstHandlerInterceptor"></bean>
     </mvc:interceptors>
 *
 * 当有多个拦截器时的执行顺序
 * preHandle：按照拦截器数组的正向顺序执行
 * postHandle：按照拦截器数组的反向顺序执行
 * afterCompletion：按照拦截器数组的反向顺序执行
 *
 * 当多个拦截器的preHandle有不同的值时
 * 第一个返回false，第二个返回false：只有第一个preHandle会执行
 * 第一个返回true，第二个返回false：两个（全部）拦截器的preHandle都会执行
 * 但是（全部）postHandle都不会执行，而afterCompletion只有第一个（返回false的拦截器之前的所有afterCompletion）会执行
 * 第一个返回false，第二个返回true:只有第一个的preHandle会执行
 *
 * =================异常=========================
 * SpringMVC 异常处理：
 *  Spring MVC 通过 HandlerExceptionResolver  处理程序的异常，HandlerExceptionResolver两个实现类：
 *     DefaultHandlerExceptionResolver 特殊的异常处理 不用我们管属于
 *     SimpleMappingExceptionResolver :
 *        如果希望对所有异常进行统一处理，可以使用 SimpleMappingExceptionResolver，
 *        它将异常类名映射为视图名，即发生异常时使用对应的视图报告异常，（意思就是跳转到错误页面）
 *  在自定义异常的时候需要在 SpringMVC 的配置文件中配置上bean: SimpleMappingExceptionResolver


 *
 */
@Controller
public class TestInterceptorController {

    /**
     *
     * 测试拦截器的
     */
    @RequestMapping(value = "testInterceptor",method = RequestMethod.GET)
    public String testInterceptor(){

        //顺便测试一下整合Spring和SpringMVC的整合
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher teacher = ac.getBean("teacher", Teacher.class);

        return "success";
    }

    /**
     *
     * 测试SpringMVC处理异常的
     *
     */

    @RequestMapping(value = "testSimpleMappingExceptionResolver",method = RequestMethod.GET)
    public String testtestSimpleMappingExceptionResolver(){
        //自己造的算术异常
        String[] s = new String[10];
        System.out.println(s[11]);
        return "success";
    }


}
