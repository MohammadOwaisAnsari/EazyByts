package com.crnsystem.crmsystem.repository;

import com.crnsystem.crmsystem.models.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface supportrepository extends JpaRepository<SupportTicket, Long> {
}
