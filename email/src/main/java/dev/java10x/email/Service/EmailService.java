package dev.java10x.email.Service;

import dev.java10x.email.domain.Email;
import dev.java10x.email.domain.EmailStatus;
import dev.java10x.email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    private final EmailRepository emailRepository;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public void sendEmail(Email emailModel) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getEmailSubject());
            message.setText(emailModel.getBody());

            // seta data antes
            emailModel.setSendEmail(LocalDateTime.now());

            mailSender.send(message);

            // sucesso
            emailModel.setStatusEmail(EmailStatus.SENT);

        } catch (Exception e) {

            // erro no envio
            emailModel.setSendEmail(LocalDateTime.now());
            emailModel.setStatusEmail(EmailStatus.FAILED);

            System.out.println("Erro ao enviar email: " + e.getMessage());
        }

        // sempre salva (sucesso ou erro)
        emailRepository.save(emailModel);
    }

}
