//package com.example.PlayGround.PlayGround.Config;
//
//import org.h2.tools.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.sql.SQLException;
//
//@Configuration
//public class H2ServerConfig {
//
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server inMemoryH2DatabaseaServer() throws SQLException {
//
//        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");  // For Application 1, use port 9091
//    }
//}
