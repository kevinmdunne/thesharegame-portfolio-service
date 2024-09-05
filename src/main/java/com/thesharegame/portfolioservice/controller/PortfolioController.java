package com.thesharegame.portfolioservice.controller;

import com.thesharegame.portfolioservice.dto.PortfolioDto;
import com.thesharegame.portfolioservice.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("portfolio")
public class PortfolioController {

    private PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService){
        this.portfolioService = portfolioService;
    }

    @GetMapping("/{id}")
    public PortfolioDto getPortfolioById(@PathVariable String id){
        return this.portfolioService.getPortfolioById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable String id){
        this.portfolioService.deletePortfolio(id);
    }

    @PostMapping("/")
    public PortfolioDto savePortfolio(@RequestBody PortfolioDto portfolioDto){
        return this.portfolioService.savePortfolio(portfolioDto);
    }

    @GetMapping("/addDummyData")
    public PortfolioDto addDummyData(){
        return this.portfolioService.addDummyData();
    }
}
