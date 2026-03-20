package domain;

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

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID emailId;

    private String userId;

    private String emailFrom;

    private String emailTo;

    private String emailSubject;
    @Column(columnDefinition = "BODY")
    private String Body;

    private LocalDateTime sendEmail;

    @Enumerated(EnumType.STRING)
    private EmailStatus statusEmail;

}
