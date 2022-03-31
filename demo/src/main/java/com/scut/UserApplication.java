package com.scut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //启用 SpringBoot 的自动配置机制
@MapperScan("com.scut.mapper")     //通过使用@MapperScan可以指定要扫描的Mapper类的包的路径
/*UserApplication类执行main方法，main方法调用SpringApplication的run方法。

        run方法干了两件事：
        创建SpringApplication对象
        利用创建好的SpringApplication对象调用run方法
        在执行SpringApplication的run方法时首先会创建一个SpringApplication类的对象，利用构造方法创建SpringApplication对象时会调用initialize方法。
        */
public class UserApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class, args);
    }

}
