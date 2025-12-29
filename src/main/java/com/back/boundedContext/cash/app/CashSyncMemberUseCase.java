package com.back.boundedContext.cash.app;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.global.eventPublisher.EventPublisher;
import com.back.shared.cash.dto.CashMemberDto;
import com.back.shared.cash.event.CashMemberCreateEvent;
import com.back.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CashSyncMemberUseCase {
    private final CashMemberRepository cashMemberRepository;
    private final EventPublisher eventPublisher;

    public CashMember syncMember(MemberDto member) {
        boolean isNew = !cashMemberRepository.existsById(member.getId());

        CashMember cashMember = cashMemberRepository.save(
                new CashMember(
                    member.getId(),
                    member.getCreateDate(),
                    member.getModifyDate(),
                    member.getUsername(),
                    "",
                    member.getNickname(),
                    member.getActivityScore()
                )
        );

        if (isNew) {
            eventPublisher.publish(
                    new CashMemberCreateEvent(
                            cashMember.toDto()
                    )
            );
        }

        return cashMember;
    }
}
