package com.example.max_market.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.EntityGraph;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User",schema = "public",uniqueConstraints = {@UniqueConstraint(name = "username", columnNames = {})})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username",unique = true,nullable = false)
    private String username;

    @Column(name = "password",nullable = false,length = 255)
    private String password;
}
