package com.etabli.reservation.service;

import com.etabli.reservation.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public List<Table>  getAllTables() {

    }

    public Optional<Table> getTableById(Long id) {

    }

    public Table createTable(Table table) {

    }

    public Optional<Table> updateTable(Long id, Table table) {

    }

    public boolean deleteTable(Long di) {

    }
}
