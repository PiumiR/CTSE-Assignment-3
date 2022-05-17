package com.example.item.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.item.service.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {

	Item findByItemId(Long itemId);

}
