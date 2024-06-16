package com.thesharegame.portfolioservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name="portfolios")
@Data
@Builder
public class PortfolioEnt {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    @OneToMany
    private List<HoldingEnt> holdings;

    @Column(name="cash")
    private double cash;
}
