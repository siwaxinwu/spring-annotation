package io.roy.spring.plugins.register.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * description：
 * author：dingyawu
 * date：created in 16:37 2020/8/6
 * history:
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentBean implements Serializable {
    private static final long serialVersionUID = 2150303941514040528L;
    private Integer id;
    private String name;
}
