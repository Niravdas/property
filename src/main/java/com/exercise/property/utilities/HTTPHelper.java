package com.exercise.property.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;


/**
 * @author Niravdas
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HTTPHelper implements Serializable {

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    private Integer status;
    private String data;
    private String message;
    private String token;

    public HTTPHelper() {
    }

    public HTTPHelper(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public HTTPHelper(Integer status, Object data, String message) throws JsonProcessingException {

        this.status = status;
        this.data = null == data ? "{}" : new ObjectMapper().writeValueAsString(data);
        this.message = message;
    }

    public HTTPHelper(Integer status, String data, String message, String token) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.token = token;
    }
}
