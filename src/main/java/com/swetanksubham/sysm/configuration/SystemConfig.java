package com.swetanksubham.sysm.configuration;

import java.lang.management.ManagementFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.management.OperatingSystemMXBean;

@Configuration
public class SystemConfig {

    @Bean
    OperatingSystemMXBean sunOperatingSystemMXBean() {
        return (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

}
