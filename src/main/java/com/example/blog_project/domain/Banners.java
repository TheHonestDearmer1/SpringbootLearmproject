package com.example.blog_project.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

@Repository
@Alias("banner_table")
public class Banners {

    private Integer ID;

    private String title;
    private String description;
    private String href;
    @JsonProperty("ID")
    public Integer getID() {
        return ID;
    }
    @JsonProperty("ID")
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
