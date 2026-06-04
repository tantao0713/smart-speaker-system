package com.smartspeaker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ResponseDTO<T> success(T data) {
        return ResponseDTO.<T>builder()
            .code(0)
            .message("success")
            .data(data)
            .build();
    }

    public static <T> ResponseDTO<T> error(Integer code, String message) {
        return ResponseDTO.<T>builder()
            .code(code)
            .message(message)
            .data(null)
            .build();
    }
}
