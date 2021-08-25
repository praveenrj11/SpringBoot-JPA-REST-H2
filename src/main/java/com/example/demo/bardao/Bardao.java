package com.example.demo.bardao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.BarItem;

public interface Bardao extends JpaRepository<BarItem, Integer> {

}
