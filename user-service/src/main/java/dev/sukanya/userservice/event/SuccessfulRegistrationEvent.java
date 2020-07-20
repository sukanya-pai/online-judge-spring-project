package dev.sukanya.userservice.event;

import dev.sukanya.userservice.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class SuccessfulRegistrationEvent extends ApplicationEvent {

    private User registeredUser;
    public SuccessfulRegistrationEvent(User registeredUser) {
        super(registeredUser);
        this.registeredUser=registeredUser;
    } //any class extending ApplicationEvent is considered as Event
}
