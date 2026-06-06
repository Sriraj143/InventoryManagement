package com.inventory.InventoryManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.inventory.InventoryManagement.Dto.InventorySearchRequest;
import com.inventory.InventoryManagement.Entity.Inventory;
import com.inventory.InventoryManagement.Repository.InventoryRepository;
import com.inventory.InventoryManagement.Specification.InventorySpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

	@Autowired
    private InventoryRepository repository;

    @Override
    public Page<Inventory> searchInventory(
            InventorySearchRequest request,
            int page,
            int size) {

        Pageable pageable =
                PageRequest.of(page, size);

        return repository.findAll(
                InventorySpecification
                        .searchInventory(request),
                pageable);
    }
}
