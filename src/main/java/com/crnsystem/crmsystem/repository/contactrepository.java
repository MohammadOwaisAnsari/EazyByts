package com.crnsystem.crmsystem.repository;

import com.crnsystem.crmsystem.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactrepository extends JpaRepository<Contact, Long> {
}
