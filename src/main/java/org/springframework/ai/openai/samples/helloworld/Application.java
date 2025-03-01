package org.springframework.ai.openai.samples.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.gwb.util","org.springframework.ai.openai.samples.*","org.springframework.ai.*","import dev.langchain4j.service.spring.*"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("********************************AI项目启动成功！****************************");

    }

}
