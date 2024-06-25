package com.thesharegame.portfolioservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name="portfolios")
@Data
@Builder
@AllArgsConstructor
public class PortfolioEnt {

    public PortfolioEnt(){}

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<HoldingEnt> holdings;

    @Column(name="cash")
    private double cash;
}
