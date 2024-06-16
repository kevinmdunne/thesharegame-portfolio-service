package com.thesharegame.portfolioservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HoldingDto {
    private String id;
    private String shareId;
    private int amountHeld;
}
