package com.tejas.comicverse.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {

    @GetMapping("/api/test")
    public String test() {
        return "JWT Authentication Working";
    }
}
