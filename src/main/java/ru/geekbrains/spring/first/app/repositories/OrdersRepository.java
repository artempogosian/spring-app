package ru.geekbrains.spring.first.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.first.app.model.Order;

@Component
public interface OrdersRepository extends JpaRepository<Order, Long> {
}
