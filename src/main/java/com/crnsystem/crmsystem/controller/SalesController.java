package com.crnsystem.crmsystem.controller;

import com.crnsystem.crmsystem.models.sales;
import com.crnsystem.crmsystem.service.salesservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private salesservice salesService;

    @GetMapping
    public List<sales> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<sales> getSalesById(@PathVariable Long id) {
        return salesService.getSalesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public sales createSales(@RequestBody sales sales) {
        return salesService.saveSales(sales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<sales> updateSales(@PathVariable Long id, @RequestBody sales salesDetails) {
        return salesService.getSalesById(id)
                .map(sales -> {
                    sales.setDealName(salesDetails.getDealName());
                    sales.setAssignedTo(salesDetails.getAssignedTo());
                    sales.setDealValue(salesDetails.getDealValue());
                    sales.setStatus(salesDetails.getStatus());
                    sales updatedSales = salesService.saveSales(sales);
                    return ResponseEntity.ok(updatedSales);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSales(@PathVariable Long id) {
        return salesService.getSalesById(id)
                .map(sales -> {
                    salesService.deleteSales(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
