package com.wangwei.springboot;

import com.wangwei.domain.Girl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangwei on 2018/1/10.
 */
@Configuration
public class BeanFactoryConfiguration {

    @Bean
    public Girl createGirl(){
        return new Girl();
    }
}
