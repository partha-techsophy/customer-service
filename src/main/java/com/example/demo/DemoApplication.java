package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class DemoApplication {

    private static final String MESSAGE_BUNDLE = "messages/error_messages";

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * Error messages to log or send as error message to client.
     * This can be configured to support internationalisation
     *
     * @return
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames(MESSAGE_BUNDLE);
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }

}
