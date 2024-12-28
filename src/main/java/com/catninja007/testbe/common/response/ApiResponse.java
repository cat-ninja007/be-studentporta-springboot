package com.catninja007.testbe.common.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@ToString
public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private boolean success = false;
    private T data;

    // Constructor
    public ApiResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;

        if (statusCode == HttpStatus.OK.value()) {
            this.success = true;
        }
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message) {
        return success(HttpStatus.OK.value(), message, null);
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        return success(HttpStatus.OK.value(), message, data);
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(int statusCode, String message, T data) {
        ApiResponse<T> apiResponse = new ApiResponse<>(statusCode, message);
        apiResponse.setSuccess(true);
        apiResponse.setData(data);
        return ResponseEntity.status(statusCode).body(apiResponse);
    }
}
