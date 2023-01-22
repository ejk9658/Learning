package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    // @RequestBody와 Map을 활용한 PUT 메서드 구현
    // mamber를 JSON 형식으로 보냄 (Postman에서 raw JSON으로 테스트)
    // http://localhost:9080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();
        putData.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return sb.toString();
    }

    // DTO 객체를 통한 PUT 메서드 구현
    // mamber를 JSON 형식으로 보냄 (Postman에서 raw JSON으로 테스트)
    // http://localhost:9080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
    // http://localhost:9080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

//    // ResponseEntity를 활용한 PUT 메서드 구현
//    // http://localhost:9080/api/v1/put-api/member3
//    @PutMapping(value = "/member3")
//    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
//        return ResponseEntity
//                .status(HttpStatus.ACCEPTED)
//                .body(memberDto);
//    }
}
