package com.crnsystem.crmsystem.repository;

import com.crnsystem.crmsystem.models.sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface salesrepository extends JpaRepository<sales, Long> {
}
