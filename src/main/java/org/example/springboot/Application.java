package org.example.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.
SpringBootApplication;

@SpringBootApplication
//프로젝트의 메인 클래스
//내장 WAS  - 언제 어디서나 같은 환경에 스프링 부트 배포 가능
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
