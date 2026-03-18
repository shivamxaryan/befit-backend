# 🥗 Be-Fit Fitness Calorie Tracker (Backend)

## 📌 Overview

This project is a **Fitness Calorie Tracking Backend** built using **Java Spring Boot**.
The main goal is to provide accurate calorie tracking with support for **Indian foods** and **user-defined custom meals (like thali)**.

Unlike many existing apps, this system allows users to:

* Track daily calorie intake
* Add **custom foods** with their own calorie values
* Log meals (breakfast, lunch, dinner, snacks)
* Compare consumed calories with a **daily goal**

---

## 🚀 Features

### ✅ User Features

* User registration & profile
* Set **daily calorie goal**
* Track daily calorie consumption

### ✅ Food Features

* Predefined food database
* Add **custom foods** (e.g., "Lunch Thali - 650 calories")

### ✅ Meal Tracking

* Log meals (breakfast, lunch, dinner, snacks)
* Add multiple food items in a meal
* Supports both:

  * System foods
  * Custom foods

### ✅ Calorie Tracking

* Automatic calorie calculation per meal
* Daily calorie summary:

  * Total consumed
  * Remaining calories

---

## 🏗️ Tech Stack

* **Backend**: Java, Spring Boot
* **Database**: PostgreSQL
* **ORM**: JPA / Hibernate
* **Build Tool**: Maven

---

## 🗄️ Database Schema

### https://dbdiagram.io/d/Fitness-Application-69b1591c77d079431b5ba6d7

## 🔄 Application Flow

### Step 1: User Setup

* User registers
* Sets daily calorie goal (e.g., 2200 kcal)

---

### Step 2: Add Foods

* Use system foods OR
* Create custom food:

```json
{
  "name": "Lunch Thali",
  "calories": 650
}
```

---

### Step 3: Log Meals

Example:

```json
{
  "mealType": "lunch",
  "foods": [
    { "foodId": "roti", "quantity": 2 },
    { "customFoodId": "thali", "quantity": 1 }
  ]
}
```

---

### Step 4: Calorie Calculation

Example:

* 2 Roti = 240 kcal
* Dal = 180 kcal
* Custom Thali = 650 kcal

**Total = 1070 kcal**

---

### Step 5: Daily Summary

```text
Goal: 2200 kcal
Consumed: 1070 kcal
Remaining: 1130 kcal
```

---

## 📈 Future Enhancements

* Macronutrients (protein, carbs, fats)
* Diet plan recommendations
* Weight tracking
* Analytics dashboard

---

## 💡 Why This Project?

This project demonstrates:

* Clean database design
* Real-world backend architecture
* Scalable API design
* Practical problem-solving (Indian food tracking)

---

## 🧠 Learning Outcomes

* REST API design
* Database relationships
* Backend architecture
* Handling real-world data (meals, calories)

---

## 🏁 Conclusion

This is a **production-ready MVP backend** for a calorie tracking application with a focus on **simplicity, scalability, and real-world usability**.

---
