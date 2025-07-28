package com.teac.inclusion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // Ejemplo: "ALUMNO", "DOCENTE", etc.

    @Column(length = 255)
    private String description; // Ejemplo: "Representante legal"

    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;
}







