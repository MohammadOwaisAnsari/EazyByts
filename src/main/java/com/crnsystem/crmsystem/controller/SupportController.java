package com.crnsystem.crmsystem.controller;

import com.crnsystem.crmsystem.models.SupportTicket;
import com.crnsystem.crmsystem.service.supportservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportController {

    @Autowired
    private supportservice supportService;

    @GetMapping
    public List<SupportTicket> getAllSupportTickets() {
        return supportService.getAllSupportTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> getTicketById(@PathVariable Long id) {
        return supportService.getTicketById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SupportTicket createSupportTicket(@RequestBody SupportTicket supportTicket) {
        return supportService.createOrUpdateTicket(supportTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportTicket> updateSupportTicket(@PathVariable Long id,
            @RequestBody SupportTicket supportTicket) {
        return supportService.getTicketById(id)
                .map(existingTicket -> {
                    supportTicket.setId(existingTicket.getId());
                    SupportTicket updatedTicket = supportService.createOrUpdateTicket(supportTicket);
                    return ResponseEntity.ok(updatedTicket);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupportTicket(@PathVariable Long id) {
        return supportService.getTicketById(id)
                .map(existingTicket -> {
                    SupportTicket.deleteTicket(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
