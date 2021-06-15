package ru.geekbrains.spring.first.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    // экспериментировал с валидацией через атрибуты; не получилось
    @DecimalMin("1.00")
    @Positive
    @NotNull
    @Size(min = 1)
    @Min(value = 1, message = "Price should not be less than 1")
    private int price;
}
