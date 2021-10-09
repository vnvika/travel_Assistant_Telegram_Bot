package org.vnvika.travelassistanttelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@AutoConfigurationPackage
public class TravelAssistantTelegramBotApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TravelAssistantTelegramBotApplication.class, args);
    }

}
