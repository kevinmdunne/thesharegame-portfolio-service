package com.thesharegame.portfolioservice.repository;

import com.thesharegame.portfolioservice.entity.PortfolioEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<PortfolioEnt, String> {
}
