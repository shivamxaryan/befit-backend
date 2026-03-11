package com.example.befit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "foods")
@Data
public class Food extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String foodName;

    @Column(name = "calories", nullable = false)
    private Integer calories;
}
