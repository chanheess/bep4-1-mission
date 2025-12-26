package com.back.boundedContext.market.app;

import com.back.boundedContext.market.domain.Cart;
import com.back.boundedContext.market.domain.MarketMember;
import com.back.boundedContext.market.out.CartRepository;
import com.back.boundedContext.market.out.MarketMemberRepository;
import com.back.global.rsData.RsData;
import com.back.shared.market.dto.MarketMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MarketCreateCartUseCase {
    private final MarketMemberRepository marketMemberRepository;
    private final CartRepository cartRepository;

    public RsData<Cart> createCart(MarketMemberDto member) {
        MarketMember marketMember = marketMemberRepository.getReferenceById(member.getId());

        Cart cart = new Cart(marketMember);
        cartRepository.save(cart);

        return new RsData<>(
                "201-1",
                "장바구니가 생성되었습니다.",
                cart
        );
    }
}
