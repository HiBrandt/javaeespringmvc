package restcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import restcrud.bean.Department;
import restcrud.bean.Employee;
import restcrud.dao.DepartmentDao;
import restcrud.dao.EmployeeDao;

import java.util.Collection;
import java.util.Map;

/**
 * @program: javaeespringmvc
 * @description: TODO
 * @author: HiBrandt
 * @create: 2021-02-15 11:37
 *
 *
 * 回显功能自己百度去吧 springmvc就有的功能
 **/
@Controller
public class EmpController {

    //自动装配
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     *
     * 处理展示员工信息请求，并将员工信息返回到作用域
     */
    @RequestMapping(value = "emps")
    public String getAll(Map<String,Object>map){  //这个map是将数据返回到作用域的承载map
        Collection<Employee> employees = employeeDao.getAll();  //这个map是员工信息的集合
        map.put("emps",employees);
        return "list";
    }

    /**
     * 跳转到添加员工页面
     * 添加的时候需要把部门信息传过去，让客户去选择部门
     * 所以要把所有的部门信息拿到，返回给作用域
     */
    @RequestMapping(value = "emp",method = RequestMethod.GET)
    public String toAdd(Map<String,Object>map){
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);
        return "add";
    }

    /**
     *
     * 输入完添加页面之后 进行添加的业务逻辑
     * 注意：要重定向到员工信息列表控制层emps  重定向 不能用转发  转发经常会造成表单重复提交的问题
     * 接收客户端传过来的数据  用POJO
     */
    @RequestMapping(value = "emp",method = RequestMethod.POST)
    public String addEmp(Employee employee){    //POJO 接收客户端传过来的数据
        employeeDao.save(employee);
        return "redirect:/emps";  //重定向到emps
    }

    /**
     *
     * 跳转到更新页面
     * 需要接收传过来的员工ID以及把要更新的员工信息返回给作用域
     * 还需要把部门的信息返回过去，供用户选择
     */

    @RequestMapping(value = "emp/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id")Integer id,Map<String,Object> map){

        Employee emp = employeeDao.get(id);
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("emp", emp);
        map.put("depts", depts);
        return "update";
    }

    /**
     *
     * 实现更新的逻辑
     *
     */

    @RequestMapping(value = "emp",method = RequestMethod.PUT)
    public String uodateEmp(Employee employee){ //POJO 接收客户端传过来的数据

        employeeDao.save(employee);
        return "redirect:/emps";  //重定向到emps

    }

    /**
     * 实现删除逻辑
     */
    @RequestMapping(value = "emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
