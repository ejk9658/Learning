package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    // @PathVariable에 변수명을 매핑하는 방법
    // http://localhost:9080/api/v1/delete-api/{String 값}
    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        return variable;
    }

    // @RequestParam을 활용한 DELETE 메서드 구현
    // http://localhost:9080/api/v1/delete-api/request1?email=value
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email) {
        return "e-mail : "+email;
    }
}
