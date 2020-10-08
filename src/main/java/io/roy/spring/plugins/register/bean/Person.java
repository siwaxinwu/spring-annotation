package io.roy.spring.plugins.register.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * description：Person(name=binghe, age=18, randomNumber=61.28133738660453, systemPropertiesName=Windows 10)
 * author：dingyawu
 * date：created in 14:12 2020/9/28
 * history:
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 7387479910468805194L;

    //注入一个普通的字符串
    @Value("roy")
    private String name;
    @Value("#{20-2}")
    private Integer age;

    //注入表达式结果
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    // 注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    @Value("${person.nickName}")
    private String nickName;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
