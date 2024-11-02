package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "R0LE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String name;

    @Column(name = "label", nullable = false)
    private String label;

}
