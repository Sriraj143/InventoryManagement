package com.inventory.InventoryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.inventory.InventoryManagement.Entity.Inventory;

@Repository
public interface InventoryRepository extends
        JpaRepository<Inventory, Long>,
        JpaSpecificationExecutor<Inventory> {
}
