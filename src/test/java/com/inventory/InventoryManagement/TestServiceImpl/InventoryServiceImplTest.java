package com.inventory.InventoryManagement.TestServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.data.jpa.domain.Specification;

import com.inventory.InventoryManagement.Dto.InventorySearchRequest;
import com.inventory.InventoryManagement.Entity.Inventory;
import com.inventory.InventoryManagement.Repository.InventoryRepository;
import com.inventory.InventoryManagement.Service.InventoryServiceImpl;

@ExtendWith(MockitoExtension.class)
class InventoryServiceImplTest {

    @Mock
    private InventoryRepository repository;

    @InjectMocks
    private InventoryServiceImpl service;

    @Test
    void searchInventory_ShouldReturnPageOfInventory() {

        InventorySearchRequest request =
                new InventorySearchRequest();

        Inventory inventory =
                new Inventory();

        Page<Inventory> expectedPage =
                new PageImpl<>(Collections.singletonList(inventory));

        when(repository.findAll(
                any(Specification.class),
                any(org.springframework.data.domain.Pageable.class)))
                .thenReturn(expectedPage);

        Page<Inventory> actualPage =
                service.searchInventory(request, 0, 10);

        assertEquals(expectedPage, actualPage);

        verify(repository).findAll(
                any(Specification.class),
                any(org.springframework.data.domain.Pageable.class));
    }

    @Test
    void searchInventory_ShouldReturnEmptyPage() {

        InventorySearchRequest request =
                new InventorySearchRequest();

        Page<Inventory> expectedPage =
                Page.empty();

        when(repository.findAll(
                any(Specification.class),
                any(org.springframework.data.domain.Pageable.class)))
                .thenReturn(expectedPage);

        Page<Inventory> actualPage =
                service.searchInventory(request, 1, 5);

        assertEquals(0, actualPage.getTotalElements());

        verify(repository).findAll(
                any(Specification.class),
                any(org.springframework.data.domain.Pageable.class));
    }
}
