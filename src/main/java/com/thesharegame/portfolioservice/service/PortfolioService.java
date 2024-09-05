package com.thesharegame.portfolioservice.service;

import com.thesharegame.portfolioservice.dto.PortfolioDto;
import com.thesharegame.portfolioservice.entity.HoldingEnt;
import com.thesharegame.portfolioservice.entity.PortfolioEnt;
import com.thesharegame.portfolioservice.exceptions.NotFoundException;
import com.thesharegame.portfolioservice.repository.PortfolioRepository;
import com.thesharegame.portfolioservice.utils.ModelConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService {

    private PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository){
        this.portfolioRepository = portfolioRepository;
    }

    public PortfolioDto getPortfolioById(String id) throws NotFoundException {
        Optional<PortfolioEnt> portfolioEntOptional = this.portfolioRepository.findById(id);
        if(portfolioEntOptional.isPresent()) {
            PortfolioEnt portfolioEnt = portfolioEntOptional.get();
            return ModelConverter.convertEntToDto(portfolioEnt);
        }
        throw new NotFoundException();
    }

    public void deletePortfolio(String id){
        this.portfolioRepository.deleteById(id);
    }

    @Transactional
    public PortfolioDto savePortfolio(PortfolioDto portfolioDto){
        PortfolioEnt ent = ModelConverter.convertDtoToEnt(portfolioDto);
        PortfolioEnt savedEnt = this.portfolioRepository.save(ent);
        return ModelConverter.convertEntToDto(savedEnt);
    }

    public PortfolioDto addDummyData(){
        PortfolioEnt portfolioEnt = new PortfolioEnt();
        portfolioEnt.setCash(105);
        HoldingEnt holdingEnt = new HoldingEnt();
        holdingEnt.setShareId("abcd");
        holdingEnt.setAmountHeld(5);
        portfolioEnt.getHoldings().add(holdingEnt);

        PortfolioEnt savedEnt = this.portfolioRepository.save(portfolioEnt);
        return ModelConverter.convertEntToDto(savedEnt);
    }

}
