package ru.itgirls.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique=true)
    private String name;

    private String surname;

    @NotNull
    private String email;

    @NotNull
    //private UserRole role;

    @NotNull
    private boolean enabled;

    @NotNull
    private String password;



}
