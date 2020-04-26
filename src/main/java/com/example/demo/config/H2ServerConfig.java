package com.example.demo.config;


import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;


/**
 * 기본포트 9092
 * http://homoefficio.github.io/2019/10/09/IntelliJ%EC%97%90%EC%84%9C-H2-%EC%97%B0%EA%B2%B0%ED%95%98%EA%B3%A0-JPA-Console-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0/
 */

@Profile("local")
@Configuration
public class H2ServerConfig {

    @Bean
    public Server h2TcpServer() throws SQLException{
        return Server.createTcpServer().start();
    }
}
