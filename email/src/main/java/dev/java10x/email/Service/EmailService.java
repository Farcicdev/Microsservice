package dev.java10x.email.Service;

import dev.java10x.email.domain.Email;
import dev.java10x.email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    private final EmailRepository emailRepository;

    private String emailFrom = "${MAIL_USERNAME}";

    public void sendEmail(Email emailModel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(emailModel.getEmailTo());
        message.setSubject(emailModel.getEmailSubject());
        message.setText(emailModel.getBody());
        mailSender.send(message);

        emailRepository.save(emailModel);
    }


}
