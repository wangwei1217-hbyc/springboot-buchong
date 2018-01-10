package com.wangwei.springboot;

import com.google.gson.Gson;
import com.wangwei.domain.Girl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * -@SpringBootApplication默认扫描包的路径时是当前包及其子包,可以通过scanBasePackages指定.
 * ----exclude:排除指定的配置类。值为Class。  测试不能排除不是配置类的类
 * ----excludeName:排除指定的配置类，值为String。类的全路径   测试不能排除不是配置类的类
 *
 * app.setBannerMode(Banner.Mode.OFF);关闭Springboot输出Banner
 *
 * 自定义Banner方法;
 * 1,classpath下放一个banner.txt文件（文件名字固定）。文件名称也可自定义，但必须在application.properties中配置属性banner.location=my.txt
 * 2,classpath下放一个banner.jpg图片（格式支持jpg,png,gif）.图片名称也可自定义，需在application.properties中配置属性banner.image.location=my.jpg
 * 3,banner.charset=UTF-8设置banner的编码格式,默认UTF-8
 *
 *
 * SpringApplication.setDefaultProperties(Map<String, Object> defaultProperties)
 * SpringApplication.setDefaultProperties(Properties defaultProperties)
 * -----给配置项设置默认值。配置项优先级：application.properties > SpringApplication.setDefaultProperties
 *   >getEnvironment().getProperty("sys.host","127.0.0.1") >  @Value("${sys.host:localhost}")
 */
//@SpringBootApplication(scanBasePackages = {"com.wangwei"},excludeName = {"org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration"})
@SpringBootApplication(scanBasePackages = {"com.wangwei"})
public class App {
    @Value("${sys.host:localhost}")
    private String sysHost;
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
//        app.setBannerMode(Banner.Mode.OFF);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("sys.host","192.168.1.1");
        app.setDefaultProperties(params);
        ConfigurableApplicationContext context = app.run(args);

        System.out.println(context.getBean(Girl.class));
        System.out.println(context.getBean(Gson.class));

        System.out.println(context.getEnvironment().getProperty("sys.host","127.0.0.1"));
        System.out.println(context.getBean(App.class).sysHost);
        context.close();
    }
}
