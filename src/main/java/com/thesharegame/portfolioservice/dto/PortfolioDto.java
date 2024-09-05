package com.thesharegame.portfolioservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class PortfolioDto {

    private String id;
    private List<HoldingDto> holdings;
    private double cash;
    private Instant createDate;
    private Instant modifyDate;
}
