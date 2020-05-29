package org.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON으로 반환하는 컨트롤러 생성
//ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌.
@RestController
public class HelloController {

    //HTTP method인 GET의 요청을 받을 수 있는 API 생성.
    //예전엔 @RequestMapping(method = RequestMethod.GET)으로 사용됨.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/re")
    public String re(){
        return "rerere";
    }

}
