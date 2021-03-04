package com.madura.Crud.Application.repos;

import com.madura.Crud.Application.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
