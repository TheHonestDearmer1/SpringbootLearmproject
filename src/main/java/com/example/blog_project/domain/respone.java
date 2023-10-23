package com.example.blog_project.domain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;

@Repository
@JsonInclude(JsonInclude.Include.NON_NULL)
public class respone {
    private Integer status_code;
    private String status_msg;

    private Integer user_id;
    private String token;

    @JsonProperty("DataList")
    public Object getDataList() {
        return DataList;
    }


    @JsonProperty("DataList")
    public void setDataList(Object dataList) {
        DataList = dataList;
    }

    private Object DataList;
    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public String getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
