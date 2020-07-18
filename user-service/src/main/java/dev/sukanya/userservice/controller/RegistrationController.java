package dev.sukanya.userservice.controller;

import dev.sukanya.userservice.dto.ResponseDTO;
import dev.sukanya.userservice.dto.UserDTO;
import dev.sukanya.userservice.dto.UserResponseDTO;
import dev.sukanya.userservice.exceptions.UserAlreadyExistsException;
import dev.sukanya.userservice.model.User;
import dev.sukanya.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController //--> we can pass JSON objects too
//if @Controller --> expects we will give name of html page we want to view
public class RegistrationController {
    @Autowired  //Autowired --> For Dependency Injection in AOP programming
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseDTO<?> registerUser(@RequestBody @Valid UserDTO userDTO, BindingResult result){
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            List<String> errorMessages = new ArrayList<String>();
            for (ObjectError error:
                 errors) {
                errorMessages.add(error.getDefaultMessage());
            }
            return new ResponseDTO<List<String>>(HttpStatus.BAD_REQUEST, errorMessages);
        }
        try{
            User user = userService.registerUser(userDTO);
            return new ResponseDTO<UserResponseDTO>(HttpStatus.OK, new UserResponseDTO(user.getId(),user.getEmail(),user.getFullName(),user.isActive()));
        }catch(UserAlreadyExistsException e){
            return new ResponseDTO<String>(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
