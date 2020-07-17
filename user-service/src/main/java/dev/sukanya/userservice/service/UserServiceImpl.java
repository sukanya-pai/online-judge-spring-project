package dev.sukanya.userservice.service;

import dev.sukanya.userservice.dto.UserDTO;
import dev.sukanya.userservice.model.User;
import dev.sukanya.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service    //Service says Spring Boot that this is a bean and make sure this bean is created
@Transactional  //for all methods of service, give transactional properties same as database
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Override
    public User registerUser(UserDTO userDTO) throws Exception{
        if(userRepository.findByEmail(userDTO.getEmail())!=null){
            //User already exists, throw exception
            throw new Exception("User already exists!");
        }

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setActive(false);

        // Spring allows us to send password Encoder --> SpringSecurity Comes into picture. --> defined in SecurityConfig
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        //When a person logs in, we will again encrypt the password with same algorithm
        //We compare the encrypted password with what we have
        //There is no need of decrypting password.
        //Companies generally dont store the password for security concerns

        User savedUser = userRepository.save(user); //This savedUser object will have ID saved in DB

        return savedUser;
    }
}
