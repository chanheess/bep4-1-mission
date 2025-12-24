package com.back.boundedContext.post.domain;


import com.back.boundedContext.member.domain.Member;
import com.back.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "POST_POST_COMMENT")
@Entity
@NoArgsConstructor
public class PostComment extends BaseIdAndTime {
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    private PostMember author;
    @Column(columnDefinition = "TEXT")
    private String content;

    public PostComment(Post post, PostMember author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }
}
