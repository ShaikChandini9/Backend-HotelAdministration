package com.example.Hotelmanagement.service;

import com.example.Hotelmanagement.dto.AuthResponse;
import com.example.Hotelmanagement.dto.LoginRequest;
import com.example.Hotelmanagement.dto.RegisterRequest;
import com.example.Hotelmanagement.model.User;
import com.example.Hotelmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;


//    private boolean isSuccess = false;
//    private String message = "Invalid login";

    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setConfirmpassword(registerRequest.getConfirmpassword());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setIsAdmin(registerRequest.getIsAdmin());
        userRepository.save(user);
    }

    //    public AuthResponse login(LoginRequest loginRequest) {
//        List<User> users = userRepository.findAll();
//        isSuccess = users.stream().anyMatch(user -> (user.getEmail().equals(loginRequest.getEmail()) &&
//                user.getPassword().equals(loginRequest.getPassword())));
//
//        if (isSuccess) {
//            message = "Valid Login";
//        }
//        if (isSuccess) {
//            return new AuthResponse(message, isSuccess);
//            //return new AuthResponse(user.getEmail());
//        }
//        return null;
//    }
    public AuthResponse login(LoginRequest loginRequest){
        User user =userRepository.findByEmail(loginRequest.getEmail()).get();
        if(loginRequest.getPassword().equals(user.getPassword()))
            return new AuthResponse(user.getEmail(), user.getIsAdmin());

        return null;
    }


}

