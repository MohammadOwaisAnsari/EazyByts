package com.crnsystem.crmsystem.controller;

import com.crnsystem.crmsystem.models.Contact;
import com.crnsystem.crmsystem.service.contactservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private contactservice contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        return contactService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        return contactService.getContactById(id)
                .map(contact -> {
                    contact.setName(contactDetails.getName());
                    contact.setEmail(contactDetails.getEmail());
                    contact.setPhone(contactDetails.getPhone());
                    contact.setCompany(contactDetails.getCompany());
                    contact.setJobTitle(contactDetails.getJobTitle());
                    contact.setAddress(contactDetails.getAddress());
                    Contact updatedContact = contactService.saveContact(contact);
                    return ResponseEntity.ok(updatedContact);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable Long id) {
        return contactService.getContactById(id)
                .map(contact -> {
                    contactService.deleteContact(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
