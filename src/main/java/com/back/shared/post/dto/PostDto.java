package com.back.shared.post.dto;

import com.back.standard.modelType.CanGetModelTypeCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostDto implements CanGetModelTypeCode {
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private int authorId;
    private String authorName;
    private String title;
    private String content;

    @Override
    public String getModelTypeCode() {
        return "Post";
    }
}
