package com.example.befit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MealItem extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "custom_food_id")
    private CustomFood customFood;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "calories")
    private Integer calories;

}
