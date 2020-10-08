package io.roy.spring.plugins.register.springScan.mime;

import io.roy.spring.plugins.register.springScan.service.OrderService;
import io.roy.spring.plugins.register.springScan.spring.MyApplicationContext;

/**
 * description：
 * author：dingyawu
 * date：created in 7:34 2020/9/30
 * history:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        MyApplicationContext ac = new MyApplicationContext(MyAppConfig.class);
        OrderService orderService = (OrderService)ac.getBean("orderService");
        OrderService orderService1 = (OrderService)ac.getBean("orderService");
        OrderService orderService2 = (OrderService)ac.getBean("orderService");
        OrderService orderService3 = (OrderService)ac.getBean("orderService");
        OrderService orderService4 = (OrderService)ac.getBean("orderService");
        System.out.println(orderService);
        System.out.println(orderService1);
        System.out.println(orderService2);
        System.out.println(orderService3);
        System.out.println(orderService4);
        orderService.test();

    }
}
