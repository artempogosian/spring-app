package ru.geekbrains.spring.first.app.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Order() {
    }

    public Order(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", title=" + title;
    }
}
