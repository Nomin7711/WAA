package edu.miu.nomin.jpa.assignment.entity.dto;

import lombok.Data;

@Data
public class PostDto {
    String title;
    String content;
    public PostDto() {}
    public PostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
