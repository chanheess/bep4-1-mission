package com.back.global.jpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@Getter
public abstract class BaseIdAndTimeManual extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}