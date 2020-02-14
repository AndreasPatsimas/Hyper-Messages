package org.patsimas.hypermessages.controllers;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.hypermessages.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping(value = "/mail/{subject}/{text}")
    public void sendEmail(@PathVariable("subject") String subject, @PathVariable("text") String text) {

        log.info("Send email with subject: {} ", subject);

        mailService.sendMail(subject, text);
    }
}
