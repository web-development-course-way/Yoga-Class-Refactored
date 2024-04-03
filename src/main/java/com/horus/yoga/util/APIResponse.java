package com.horus.yoga.util;

import com.horus.yoga.constant.Constant;
import org.springframework.http.HttpStatus;

public class APIResponse<T> {

    private final int status;
    private final String message;
    private final T data;
    private final Long timestamp;

    public APIResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> APIResponse<T> ok(T data) {
        return new APIResponse<>(HttpStatus.OK.value(), Constant.SUCCESS, data);
    }

    public static <T> APIResponse<T> error(int status, String message) {
        return new APIResponse<>(status, message, null);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
