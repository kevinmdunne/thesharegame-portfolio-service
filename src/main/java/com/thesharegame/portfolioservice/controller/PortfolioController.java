package com.thesharegame.portfolioservice.controller;

import com.thesharegame.portfolioservice.dto.PortfolioDto;
import com.thesharegame.portfolioservice.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("portfolio")
@Slf4j
public class PortfolioController {

    private PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService){
        this.portfolioService = portfolioService;
    }

    @GetMapping("/{id}")
    public PortfolioDto getPortfolioById(@PathVariable String id){
        log.info("Calling getPortfolioById");
        return this.portfolioService.getPortfolioById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable String id){
        log.info("Calling deletePortfolio");
        this.portfolioService.deletePortfolio(id);
    }

    @PostMapping("/")
    public PortfolioDto savePortfolio(@RequestBody PortfolioDto portfolioDto){
        log.info("Calling savePortfolio");
        return this.portfolioService.savePortfolio(portfolioDto);
    }

    @GetMapping("/addDummyData")
    public PortfolioDto addDummyData(){
        log.info("Calling addDummyData");
        return this.portfolioService.addDummyData();
    }
}
