package com.back.boundedContext.payout.app;

import com.back.boundedContext.payout.domain.Payout;
import com.back.boundedContext.payout.domain.PayoutMember;
import com.back.boundedContext.payout.out.PayoutMemberRepository;
import com.back.boundedContext.payout.out.PayoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayoutCreatePayoutUseCase {
    private final PayoutMemberRepository payoutMemberRepository;
    private final PayoutRepository payoutRepository;

    public Payout createPayout(int payeeId) {
        PayoutMember payoutMember = payoutMemberRepository.getReferenceById(payeeId);

        Payout payout = payoutRepository.save(
                new Payout(
                        payoutMember
                )
        );

        return payout;
    }
}