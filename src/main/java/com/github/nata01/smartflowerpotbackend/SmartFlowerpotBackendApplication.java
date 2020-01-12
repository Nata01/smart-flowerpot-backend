package com.github.nata01.smartflowerpotbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SmartFlowerpotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartFlowerpotBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(DeviceRepository deviceRepository){
        return args -> {
            Action watering1 = new Action();
            watering1.setSentAt(Timestamp.valueOf(LocalDateTime.now()));
            watering1.setType(ActionType.WATERING);
            watering1.setPayload("{\"duration\": 2, \"units\": \"seconds\"}");

            Device waterer = new Device();
            waterer.setMac("address");
            waterer.setActions(List.of(watering1));
            watering1.setDevice(waterer);

            deviceRepository.save(waterer);

            System.out.println(waterer);
        };
    }
}
