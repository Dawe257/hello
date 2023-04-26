package com.dzhenetl.hello.controller;

import com.dzhenetl.hello.dto.HelloDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/{firstname}")
    public String hello(@PathVariable("firstname") String firstname, @RequestParam("lastname") String lastname) {
        return String.format("{\"message\":\"Hello %s %s\"}", firstname, lastname);
    }

    @PostMapping
    public String hello(@RequestBody HelloDto helloDto) {
        return String.format("{\"message\":\"Hello %s %s\"}", helloDto.getFirstname(), helloDto.getLastname());
    }
}
