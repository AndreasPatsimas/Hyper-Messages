package org.patsimas.hypermessages.services;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
public interface MailService {

    void sendMail(String subject, String text) throws MailException;
}
