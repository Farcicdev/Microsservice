package dev.java10x.email.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Email {

    private final long srialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;

    private UUID userId;

    private String emailFrom;

    private String emailTo;

    private String emailSubject;

    @Column(columnDefinition = "TEXT")
    private String Body;

    private LocalDateTime sendEmail;

    @Enumerated(EnumType.STRING)
    private EmailStatus statusEmail;

}
