package com.example.befit.entity;

import com.example.befit.entity.Enum.MealType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table(name = "meals")
@Entity
public class Meal extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "meal_type")
    private MealType mealType;

    @Column(name = "meal_date")
    private LocalDate mealDate;
}
