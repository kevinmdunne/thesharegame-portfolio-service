package com.thesharegame.portfolioservice.utils;

import com.thesharegame.portfolioservice.dto.HoldingDto;
import com.thesharegame.portfolioservice.dto.PortfolioDto;
import com.thesharegame.portfolioservice.entity.HoldingEnt;
import com.thesharegame.portfolioservice.entity.PortfolioEnt;

import java.util.ArrayList;
import java.util.List;

public class ModelConverter {

    public static PortfolioDto convertEntToDto(PortfolioEnt portfolioEnt){
        PortfolioDto dto = PortfolioDto.builder()
                .id(portfolioEnt.getId())
                .cash(portfolioEnt.getCash())
                .createDate(portfolioEnt.getCreateDate())
                .modifyDate(portfolioEnt.getModifyDate())
                .build();

        List<HoldingDto> holdings = new ArrayList<>();
        for(HoldingEnt holdingEnt : portfolioEnt.getHoldings()){
            HoldingDto holdingDto = HoldingDto.builder()
                    .amountHeld(holdingEnt.getAmountHeld())
                    .shareId(holdingEnt.getShareId())
                    .createDate(holdingEnt.getCreateDate())
                    .modifyDate(holdingEnt.getModifyDate())
                    .build();
            holdings.add(holdingDto);
        }
        dto.setHoldings(holdings);

        return dto;
    }

    public static PortfolioEnt convertDtoToEnt(PortfolioDto portfolioDto){
        PortfolioEnt ent = PortfolioEnt.builder()
                .id(portfolioDto.getId())
                .cash(portfolioDto.getCash())
                .createDate(portfolioDto.getCreateDate())
                .modifyDate(portfolioDto.getModifyDate())
                .build();

        List<HoldingEnt> holdings = new ArrayList<>();
        for(HoldingDto holdingDto : portfolioDto.getHoldings()){
            HoldingEnt holdingEnt = HoldingEnt.builder()
                    .amountHeld(holdingDto.getAmountHeld())
                    .shareId(holdingDto.getShareId())
                    .createDate(holdingDto.getCreateDate())
                    .modifyDate(holdingDto.getModifyDate())
                    .build();
            holdings.add(holdingEnt);
        }
        ent.setHoldings(holdings);

        return ent;
    }
}
