package com.etabli.reservation.service;

import com.etabli.reservation.model.Table;
import com.etabli.reservation.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Optional<Table> getTableById(Long id) {
        return tableRepository.findById(id);
    }

    public Table createTable(Table table) {
        return tableRepository.save(table);
    }

    public Optional<Table> updateTable(Long id, Table tableDetails) {
        return tableRepository.findById(id).map(existingTable -> {
            existingTable.setNumber(tableDetails.getNumber());
            return tableRepository.save(existingTable);
        });
    }

    public boolean deleteTable(Long id) {
        return tableRepository.findById(id).map(table -> {
            tableRepository.delete(table);
            return true;
        }).orElse(false);
    }
}
