package ru.geekbrains.spring.first.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.first.app.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
