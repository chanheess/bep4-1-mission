package com.back.boundedContext.cash.in;

import com.back.boundedContext.cash.app.CashFacade;
import com.back.boundedContext.cash.domain.CashLog;
import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Slf4j
public class CashDataInit {
    private final CashDataInit self;
    private final CashFacade cashFacade;

    public CashDataInit(@Lazy CashDataInit self, CashFacade cashFacade) {
        this.self = self;
        this.cashFacade = cashFacade;
    }

    @Bean
    @Order(2)
    public ApplicationRunner baseCashDataInitRunner() {
        return args -> {
          self.makeBaseCredits();
        };
    }

    @Transactional
    public void makeBaseCredits() {
        CashMember cashMember1 = cashFacade.findMemberByUsername("user1").get();
        CashMember cashMember2 = cashFacade.findMemberByUsername("user2").get();

        Wallet wallet1 = cashFacade.findWalletByHolder(cashMember1).get();

        if (wallet1.hasBalance()) return;

        wallet1.credit(150_000, CashLog.EventType.충전__무통장입금);
        wallet1.credit(100_000, CashLog.EventType.충전__무통장입금);
        wallet1.credit(50_000, CashLog.EventType.충전__무통장입금);

        Wallet wallet2 = cashFacade.findWalletByHolder(cashMember2).get();

        if (wallet2.hasBalance()) return;

        wallet2.credit(150_000, CashLog.EventType.충전__무통장입금);
    }
}
