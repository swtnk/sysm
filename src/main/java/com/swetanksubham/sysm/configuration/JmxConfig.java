package com.swetanksubham.sysm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@Configuration
@EnableMBeanExport(registration=RegistrationPolicy.IGNORE_EXISTING)
public class JmxConfig {
    
}
