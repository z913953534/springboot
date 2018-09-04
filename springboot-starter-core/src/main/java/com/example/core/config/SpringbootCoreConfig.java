package com.example.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Enzo
 * @Description TODO
 * @date 2018-9-4 11:11
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@PropertySource(value = "classpath:application-core.properties")
public class SpringbootCoreConfig {
}
