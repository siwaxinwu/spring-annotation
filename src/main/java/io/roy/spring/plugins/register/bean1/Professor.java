package io.roy.spring.plugins.register.bean1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description：
 * author：dingyawu
 * date：created in 11:25 2020/9/29
 * history:
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Professor {


    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }
    @Autowired
    public void setTeacher(Teacher teacher) {
        System.out.println("set 方法执行");
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Professor{" +  "Teacher=" + teacher + '}';
    }
}
