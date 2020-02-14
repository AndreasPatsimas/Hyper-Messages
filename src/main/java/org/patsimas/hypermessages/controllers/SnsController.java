package org.patsimas.hypermessages.controllers;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.hypermessages.services.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/sns")
public class SnsController {

    @Autowired
    SnsService snsService;

    @GetMapping(value = "/massive/mail/{subject}/{text}")
    public void sendMassiveEmail(@PathVariable("subject") String subject, @PathVariable("text") String text) {

        log.info("Send email with subject: {} ", subject);

        snsService.sendMassiveMail(subject, text);
    }

    @GetMapping(value = "/add/subscriber/{email}")
    public void addSubscriber(@PathVariable String email) {

        log.info("Add subscriber with email: {} ", email);

        snsService.addSubscriber(email);
    }
}
