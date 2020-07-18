package dev.sukanya.userservice.service;

import dev.sukanya.userservice.dto.UserDTO;
import dev.sukanya.userservice.exceptions.UserAlreadyExistsException;
import dev.sukanya.userservice.model.User;

public interface UserService {

    public User registerUser(UserDTO userDTO) throws UserAlreadyExistsException;
}
