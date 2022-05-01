package com.umusic.trackfinder.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseDTO<T> {
    private Integer status = 200;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Integer getStatus() {
        return status;
    }

    public ResponseDTO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseDTO setData(T data) {
        this.data = data;
        return this;
    }
}
