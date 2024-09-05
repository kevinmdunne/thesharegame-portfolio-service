package com.thesharegame.portfolioservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="portfolios")
@Data
@Builder
@AllArgsConstructor
public class PortfolioEnt {

    public PortfolioEnt(){
        this.holdings = new ArrayList<>();
    }

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<HoldingEnt> holdings;

    @Column(name="cash")
    private double cash;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Instant createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Instant modifyDate;
}
