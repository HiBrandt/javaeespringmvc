package study03.bean;

import org.springframework.stereotype.Component;

/**
 * @program: javaeespringmvc
 * @description: TODO
 * @author: HiBrandt
 * @create: 2021-02-16 17:05
 **/

@Component
public class Teacher {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher() {
        System.out.println("Teacher的无参构造器");
    }
}
