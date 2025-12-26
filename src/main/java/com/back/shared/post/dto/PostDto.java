package com.back.shared.post.dto;

import com.back.boundedContext.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostDto {
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private int authorId;
    private String authorName;
    private String title;
    private String content;

    public PostDto(Post post) {
        this(
                post.getId(),
                post.getCreateDate(),
                post.getModifyDate(),
                post.getAuthor().getId(),
                post.getAuthor().getNickname(),
                post.getTitle(),
                post.getContent()
        );
    }
}
