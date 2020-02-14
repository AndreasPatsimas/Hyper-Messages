package org.patsimas.hypermessages.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Value("${email.address.from}")
    private String from;

    @Value("${email.address.to}")
    private String to;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendMail(String subject, String text) throws MailException {

        log.info("Sending email message to {} started", to);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);

        log.info("Sending email message completed");
    }
}
