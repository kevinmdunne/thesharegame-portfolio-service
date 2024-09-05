package com.thesharegame.portfolioservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class HoldingDto {
    private String id;
    private String shareId;
    private int amountHeld;
    private Instant createDate;
    private Instant modifyDate;
}
