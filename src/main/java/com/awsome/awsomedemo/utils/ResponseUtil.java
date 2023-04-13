package com.awsome.awsomedemo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yao Yuanming
 * @date: 2023/4/9 16:49
 * @Description:
 */
public class ResponseUtil {

    // 无参数版本
    public static <T> ResponseEntity<Map<String, Object>> success() {
        return success(null, 0, "Success");
    }

    public static <T> ResponseEntity<Map<String, Object>> success(T data) {
        return success(data, 0, "Success");
    }

    public static <T> ResponseEntity<Map<String, Object>> success(T data, int code) {
        return success(data, code, "Success");
    }

    public static <T> ResponseEntity<Map<String, Object>> success(T data, String message) {
        return success(data, 0, message);
    }

    public static <T> ResponseEntity<Map<String, Object>> success(T data, int code, String message) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("code", code);
        responseBody.put("data", data);
        responseBody.put("message", message);
        responseBody.put("success", true);

        return ResponseEntity.ok(responseBody);
    }

    public static ResponseEntity<Map<String, Object>> error() {
        return error(HttpStatus.BAD_REQUEST, "Error");
    }

    public static ResponseEntity<Map<String, Object>> error(String message) {
        return error(HttpStatus.BAD_REQUEST, message);
    }

    public static ResponseEntity<Map<String, Object>> error(HttpStatus status) {
        return error(status, "Error");
    }

    public static ResponseEntity<Map<String, Object>> error(HttpStatus status, String message) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("code", status.value());
        responseBody.put("message", message);
        responseBody.put("success", false);

        return ResponseEntity.status(status).body(responseBody);
    }
}

