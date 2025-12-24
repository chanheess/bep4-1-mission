package com.back.boundedContext.post.app;

import com.back.boundedContext.post.domain.PostMember;
import com.back.boundedContext.post.out.PostMemberRepository;
import com.back.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostMemberJoinedUseCase {
    private final PostMemberRepository postMemberRepository;

    public PostMember joinedMember(MemberDto member) {
        PostMember postMember = new PostMember(member);
        return postMemberRepository.save(postMember);
    }
}
