package com.back.boundedContext.market.domain;

import com.back.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MARKET_PRODUCT")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseIdAndTime {
    @ManyToOne(fetch = FetchType.LAZY)
    private MarketMember seller;
    private String sourceTypeCode;
    private int sourceId;
    private String name;
    private String description;
    private int price;
    private int salePrice;
}
