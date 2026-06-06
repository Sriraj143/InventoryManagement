package com.inventory.InventoryManagement.Specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.inventory.InventoryManagement.Dto.InventorySearchRequest;
import com.inventory.InventoryManagement.Entity.Inventory;

import jakarta.persistence.criteria.Predicate;

public class InventorySpecification {

    public static Specification<Inventory> searchInventory(
            InventorySearchRequest request) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(request.getName()!=null){
                predicates.add(
                    cb.like(
                       cb.lower(root.get("name")),
                       "%" + request.getName().toLowerCase() + "%"
                    )
                );
            }

            if(request.getCategory()!=null){
                predicates.add(
                    cb.equal(root.get("category"),
                    request.getCategory())
                );
            }

            if(request.getSubCategory()!=null){
                predicates.add(
                    cb.equal(root.get("subCategory"),
                    request.getSubCategory())
                );
            }

            if(request.getSeller()!=null){
                predicates.add(
                    cb.equal(root.get("seller"),
                    request.getSeller())
                );
            }

            if(request.getLocation()!=null){
                predicates.add(
                    cb.equal(root.get("location"),
                    request.getLocation())
                );
            }

            if(request.getBrand()!=null){
                predicates.add(
                    cb.equal(root.get("brand"),
                    request.getBrand())
                );
            }

            if(request.getModel()!=null){
                predicates.add(
                    cb.equal(root.get("model"),
                    request.getModel())
                );
            }

            if(request.getMinPrice()!=null){
                predicates.add(
                    cb.greaterThanOrEqualTo(
                    root.get("price"),
                    request.getMinPrice())
                );
            }

            if(request.getMaxPrice()!=null){
                predicates.add(
                    cb.lessThanOrEqualTo(
                    root.get("price"),
                    request.getMaxPrice())
                );
            }

            if(request.getMinStock()!=null){
                predicates.add(
                    cb.greaterThanOrEqualTo(
                    root.get("stock"),
                    request.getMinStock())
                );
            }

            if(request.getMaxStock()!=null){
                predicates.add(
                    cb.lessThanOrEqualTo(
                    root.get("stock"),
                    request.getMaxStock())
                );
            }

            return cb.and(
                predicates.toArray(new Predicate[0])
            );
        };
    }
}
