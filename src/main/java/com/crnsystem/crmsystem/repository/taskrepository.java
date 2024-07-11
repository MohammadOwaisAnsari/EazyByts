package com.crnsystem.crmsystem.repository;

import com.crnsystem.crmsystem.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskrepository extends JpaRepository<Task, Long> {
}
