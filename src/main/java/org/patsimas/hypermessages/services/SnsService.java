package org.patsimas.hypermessages.services;

import org.springframework.stereotype.Service;

@Service
public interface SnsService {

    void sendMassiveMail(String subject, String text);

    void addSubscriber(String email);
}
