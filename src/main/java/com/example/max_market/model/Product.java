package com.example.max_market.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Product",uniqueConstraints = {@UniqueConstraint(name = "productName",columnNames = {})},schema = "public")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productName",unique = true,length = 100,nullable = false)
    private String productName;

    @Column(name = "discription",nullable = true)
    private String discription;
}
