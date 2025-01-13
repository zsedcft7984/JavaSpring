//프로젝트명+ Application.java 파일은 
//스프링 부트로 만든 프로그램에 시작을 담당하는 파일로 필수
package com.testsite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Application 클래스에는 반드시  @SpringBootApplication이 적용되어야 한다.
//이 애너테이션을 통해 스프링 부트 애플리케이션을 시작할수 있다.
@SpringBootApplication
public class SbbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbbApplication.class, args);
    }
}
