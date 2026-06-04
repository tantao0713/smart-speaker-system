package com.smartspeaker.utils;

import com.smartspeaker.dto.ResponseDTO;

/**
 * 响应工具类
 */
public class ResponseUtils {
    public static <T> ResponseDTO<T> success(T data) {
        return ResponseDTO.success(data);
    }
    
    public static <T> ResponseDTO<T> error(String message) {
        return ResponseDTO.error(1, message);
    }
    
    public static <T> ResponseDTO<T> error(Integer code, String message) {
        return ResponseDTO.error(code, message);
    }
}
