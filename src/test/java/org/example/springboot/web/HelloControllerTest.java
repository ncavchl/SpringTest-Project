package org.example.springboot.web;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class) //스프링실행자 사용 - 스프링부트 테스트와 JUnit 사이에 연결자 역할.
@WebMvcTest(controllers = HelloController.class) //
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc; //웹 API를 테스트할 때 사용. 스프링 MVC 테스트 시작. HTTP GET, POST의 API테스트 가능.

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) // /hello 주소로 HTTP GET 요청 함.
                .andExpect(status().isOk()) // 결과 검증. http header status 검증, 200 404 500
                .andExpect(content().string(hello)); // 응답 본문 내용을 검증. controller에서 hello 리턴하기 때문에 이 값이 맞는지 검증.

    }

    @Test
    public void helloDtd_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(name)))
                .andExpect(jsonPath("$.amount", Matchers.is(amount)));;
    }
}