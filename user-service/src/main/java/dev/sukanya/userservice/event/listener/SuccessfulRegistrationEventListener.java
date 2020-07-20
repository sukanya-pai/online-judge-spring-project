package dev.sukanya.userservice.event.listener;

import dev.sukanya.userservice.event.SuccessfulRegistrationEvent;
import dev.sukanya.userservice.model.User;
import dev.sukanya.userservice.model.VerificationToken;
import dev.sukanya.userservice.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SuccessfulRegistrationEventListener implements ApplicationListener<SuccessfulRegistrationEvent> {

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Override
    public void onApplicationEvent(SuccessfulRegistrationEvent successfulRegistrationEvent) {
        //what should i do when i get this event
        User registeredUser = successfulRegistrationEvent.getRegisteredUser();

        //TODO: send email to verify user

        VerificationToken token = new VerificationToken(registeredUser);

        verificationTokenRepository.save(token);
    }
}
