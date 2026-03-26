package dev.java10x.user.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String name;

    @Column(name = "email", unique = true)
    private String email;

}
