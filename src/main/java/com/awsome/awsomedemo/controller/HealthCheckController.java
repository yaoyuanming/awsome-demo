package com.awsome.awsomedemo.controller;

import com.awsome.awsomedemo.utils.ResponseUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yao Yuanming
 * @date: 2023/2/25 16:08
 * @Description:
 */

@RestController("HealthCheckController")
@RequestMapping(value = "/healthCheck")
public class HealthCheckController {

    @GetMapping(value = "/getStatus")
    public ResponseEntity checkHealth() {
        return ResponseUtil.success("Hello World!");
    }
}
