package com.study.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Component
@ComponentScan("com.study")
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class, TransactionConfig.class})
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {

}
