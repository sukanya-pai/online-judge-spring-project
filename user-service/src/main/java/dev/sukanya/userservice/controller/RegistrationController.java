package dev.sukanya.userservice.controller;

import dev.sukanya.userservice.dto.ResponseDTO;
import dev.sukanya.userservice.dto.UserDTO;
import dev.sukanya.userservice.dto.UserResponseDTO;
import dev.sukanya.userservice.model.User;
import dev.sukanya.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //--> we can pass JSON objects too
//if @Controller --> expects we will give name of html page we want to view
public class RegistrationController {
    @Autowired  //Autowired --> For Dependency Injection in AOP programming
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseDTO<?> registerUser(@RequestBody UserDTO userDTO){
        try{
            User user = userService.registerUser(userDTO);
            return new ResponseDTO<UserResponseDTO>(HttpStatus.OK, new UserResponseDTO(user.getId(),user.getEmail(),user.getFullName(),user.isActive()));
        }catch(Exception e){
            return new ResponseDTO<String>(HttpStatus.OK, "User with email already exists!");
        }

    }
}
