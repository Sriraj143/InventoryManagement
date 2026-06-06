package com.inventory.InventoryManagement.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.InventoryManagement.Dto.InventorySearchRequest;
import com.inventory.InventoryManagement.Entity.Inventory;
import com.inventory.InventoryManagement.Service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Validated
public class InventoryController {

	@Autowired
    private InventoryService service;

    @GetMapping("/search")
    public ResponseEntity<Page<Inventory>> searchInventory(

            @RequestBody(required = false)
            InventorySearchRequest request,

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size) {

        if(request == null){
            request = new InventorySearchRequest();
        }

        return ResponseEntity.ok(
                service.searchInventory(
                        request,
                        page,
                        size));
    }
}
