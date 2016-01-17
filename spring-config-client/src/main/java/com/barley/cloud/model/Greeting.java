package com.barley.cloud.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class Greeting {

    @Value("${default.greeting}")
    String defaultValue;

    public String getDefaultValue() {
        return defaultValue;
    }
}
