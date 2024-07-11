package com.crnsystem.crmsystem.service;

import com.crnsystem.crmsystem.models.SupportTicket;
import com.crnsystem.crmsystem.repository.supportrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class supportservice {

    @Autowired
    private static supportrepository supportrepository;

    public static List<SupportTicket> getAllTickets() {
        return supportrepository.findAll();
    }

    public Optional<SupportTicket> getTicketById(Long class1) {
        return supportrepository.findById(class1);
    }

    public SupportTicket createOrUpdateTicket(SupportTicket ticket) {
        return supportrepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        supportrepository.deleteById(id);
    }

    public Optional<SupportTicket> getTicketById(Class<Long> class1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTicketById'");
    }

    public List<SupportTicket> getAllSupportTickets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSupportTickets'");
    }

}
