package com.junyu.forum.config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : xrj
 * @Date : 2020/10/18 15:16
 */
@Configuration
public class EsConfig {


    @Bean
    public JestClient jestClient(){
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                //连接es的配置
                .Builder("http://192.168.0.11:9200")
                .multiThreaded(true).build());

        return factory.getObject();
    }
}
