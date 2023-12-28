package com.etabli.reservation.controller;

import com.etabli.reservation.model.Table;
import com.etabli.reservation.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public ResponseEntity<List<Table>> getAllTables() {
        return ResponseEntity.ok(tableService.getAllTables());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Table> getTableById(@PathVariable Long id) {
        return tableService.getTableByid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFund().build());
    }

    @PostMapping
    public ResponseEntity<Table> creatTable(@RequestBody Table table) {
        return ResponseEntity.ok(tableService.createTable(table));
    }

    @PutMapping("/{id")
    public ResponseEntity<Table> updateTable(@PathVariable Long id, @RequestBody Table table) {
        return tableServiceupdateTable(id, table)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id")
    public ResponseEntity<?> deleteTable(@PathVariable Long id) {
        if (tableService.deletTable(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

