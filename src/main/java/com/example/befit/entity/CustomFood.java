package com.example.befit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "custom_foods")
@Entity
public class CustomFood extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name", nullable = false)
    private String customFoodName;

    @Column(name = "calories", nullable = false)
    private Integer calories;
}
