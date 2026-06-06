package com.inventory.InventoryManagement.TestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
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
    void searchInventory_WithRequest_ShouldReturnPage() {

        InventorySearchRequest request = new InventorySearchRequest();

        Page<Inventory> page =
                new PageImpl<>(Collections.singletonList(new Inventory()));

        when(service.searchInventory(request, 0, 10))
                .thenReturn(page);

        ResponseEntity<Page<Inventory>> response =
                controller.searchInventory(request, 0, 10);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(page, response.getBody());

        verify(service).searchInventory(request, 0, 10);
    }

    @Test
    void searchInventory_WhenRequestIsNull_ShouldCreateNewRequest() {

        Page<Inventory> page =
                new PageImpl<>(Collections.emptyList());

        when(service.searchInventory(any(InventorySearchRequest.class),
                eq(0),
                eq(10)))
                .thenReturn(page);

        ResponseEntity<Page<Inventory>> response =
                controller.searchInventory(null, 0, 10);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(page, response.getBody());

        verify(service)
                .searchInventory(any(InventorySearchRequest.class),
                        eq(0),
                        eq(10));
    }

    @Test
    void searchInventory_WithCustomPagination_ShouldReturnPage() {

        InventorySearchRequest request = new InventorySearchRequest();

        Page<Inventory> page =
                new PageImpl<>(Collections.emptyList());

        when(service.searchInventory(request, 2, 5))
                .thenReturn(page);

        ResponseEntity<Page<Inventory>> response =
                controller.searchInventory(request, 2, 5);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(page, response.getBody());

        verify(service).searchInventory(request, 2, 5);
    }
}
