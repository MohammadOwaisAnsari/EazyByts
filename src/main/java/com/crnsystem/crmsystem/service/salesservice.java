package com.crnsystem.crmsystem.service;

import com.crnsystem.crmsystem.models.sales;
import com.crnsystem.crmsystem.repository.salesrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class salesservice {

    @Autowired
    private salesrepository salesRepository;

    public List<sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Optional<sales> getSalesById(Long id) {
        return salesRepository.findById(id);
    }

    public sales saveSales(sales sales) {
        return salesRepository.save(sales);
    }

    public void deleteSales(Long id) {
        salesRepository.deleteById(id);
    }
}
