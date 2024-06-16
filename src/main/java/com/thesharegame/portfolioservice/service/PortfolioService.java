package com.thesharegame.portfolioservice.service;

import com.thesharegame.portfolioservice.dto.PortfolioDto;
import com.thesharegame.portfolioservice.entity.PortfolioEnt;
import com.thesharegame.portfolioservice.repository.PortfolioRepository;
import com.thesharegame.portfolioservice.utils.ModelConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class PortfolioService {

    private PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository){
        this.portfolioRepository = portfolioRepository;
    }

    public PortfolioDto getPortfolioById(String id){
        Optional<PortfolioEnt> portfolioEntOptional = this.portfolioRepository.findById(id);
        if(portfolioEntOptional.isPresent()) {
            PortfolioEnt portfolioEnt = portfolioEntOptional.get();
            return ModelConverter.convertEntToDto(portfolioEnt);
        }
        return null;
    }

    public void deletePortfolio(String id){
        this.portfolioRepository.deleteById(id);
    }

    public PortfolioDto savePortfolio(PortfolioDto portfolioDto){
        PortfolioEnt ent = ModelConverter.convertDtoToEnt(portfolioDto);
        PortfolioEnt savedEnt = this.portfolioRepository.save(ent);
        return ModelConverter.convertEntToDto(savedEnt);
    }

}
