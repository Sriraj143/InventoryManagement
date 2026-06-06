package com.inventory.InventoryManagement.Service;

import org.springframework.data.domain.Page;

import com.inventory.InventoryManagement.Dto.InventorySearchRequest;
import com.inventory.InventoryManagement.Entity.Inventory;

public interface InventoryService {

    Page<Inventory> searchInventory(
            InventorySearchRequest request,
            int page,
            int size);

}

