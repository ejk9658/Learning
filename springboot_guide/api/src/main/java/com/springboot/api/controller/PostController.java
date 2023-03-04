package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/post-api")
public class PostController {
    // http://localhost:9080/api/v1/post-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String postExample() {
        return "Hello POST API";
    }

    // @RequestBody와 Map을 활용한 POST API 구현
    // mamber를 JSON 형식으로 보냄 (Postman에서 raw JSON으로 테스트)
    // http://localhost:9080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return sb.toString();
    }

    // DTO 객체를 통한 POST 메서드 구현
    // mamber를 JSON 형식으로 보냄 (Postman에서 raw JSON으로 테스트)
    // http://localhost:9080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
