package com.inventory.InventoryManagement.TestController;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;

import com.inventory.InventoryManagement.Contoller.InventoryController;
import com.inventory.InventoryManagement.Dto.InventorySearchRequest;
import com.inventory.InventoryManagement.Entity.Inventory;
import com.inventory.InventoryManagement.Service.InventoryService;

@ExtendWith(MockitoExtension.class)
class InventoryControllerTest {

    @Mock
    private InventoryService service;

    @InjectMocks
    private InventoryController controller;

    @Test
    void testSearchInventory() {

        // Arrange
        Inventory inventory = new Inventory();
        inventory.setId(1L);
        inventory.setName("Galaxy S24");

        Page<Inventory> page =
                new PageImpl<>(Collections.singletonList(inventory));

        when(service.searchInventory(
                org.mockito.ArgumentMatchers.any(InventorySearchRequest.class),
                org.mockito.ArgumentMatchers.eq(0),
                org.mockito.ArgumentMatchers.eq(10)))
                .thenReturn(page);

        // Act
        ResponseEntity<Page<Inventory>> response =
                controller.searchInventory(
                        "Galaxy S24",
                        "Electronics",
                        "Samsung",
                        "Hyderabad",
                        0,
                        10);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().getTotalElements());
        assertEquals("Galaxy S24",
                response.getBody().getContent().get(0).getName());
    }
}
