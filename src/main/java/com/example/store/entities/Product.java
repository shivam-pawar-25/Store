package com.example.store.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Product Name is require")
    @Column(nullable = false)
    private String name;

    private String description;

    private String category;

    @NotNull(message = "Product price is require")
    @DecimalMin(value="0.0" , inclusive = false , message = "Price must be dreater then 0")
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull(message = "Stock quantity is require")
    @Min(value = 0 , message = "Stock must be greater then 0")
    @Column(nullable = false , name= "stock_quantity")
    private int stockQuantity;

    //relations
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

}
