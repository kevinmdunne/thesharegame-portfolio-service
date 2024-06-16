package com.thesharegame.portfolioservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name="holdings")
@Data
@Builder
public class HoldingEnt {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    @Column(name="share_id", length=255, nullable=false)
    private String shareId;

    @Column(name="amount_held", nullable=false)
    private int amountHeld;
}
