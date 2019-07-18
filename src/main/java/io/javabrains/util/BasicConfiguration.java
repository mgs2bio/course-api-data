package io.javabrains.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//The problem with @Value is that you would have your configuration values 
//distributed through out your application. A better option would be to have a centralized approach using @ConfigurationProperties.

@Component
@ConfigurationProperties("basic")
public class BasicConfiguration {

	private boolean value;
    private String message;
    private int number;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
