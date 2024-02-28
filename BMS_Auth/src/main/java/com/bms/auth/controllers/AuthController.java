package com.bms.auth.controllers;

import com.bms.auth.controllers.utils.UserControllerUtils;
import com.bms.auth.dto.UserDTO.UserLoginDTO;
import com.bms.auth.dto.UserDTO.UserSignUpDTO;
import com.bms.auth.dto.sessionDTO.SessionDTO;
import com.bms.auth.models.Session;
import com.bms.auth.models.User;
import com.bms.auth.service.AuthService;
import com.bms.auth.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserSignUpDTO userDTO){
        User user = this.authService.signup(userDTO.getEmail(), userDTO.getPassword());
        UserSignUpDTO userSignUpDTO = UserControllerUtils.convertUserToUserSignUpDTO(user);
        return new ResponseEntity<>("User Created with email: "+userSignUpDTO.getEmail(), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<UserLoginDTO> login(@RequestBody UserSignUpDTO userDTO){
        Session session = this.authService.login(userDTO.getEmail(), userDTO.getPassword());
        User user = session.getUser();
        UserLoginDTO userLoginDTO = UserControllerUtils.convertSessionToUserLoginDTO(user);
        MultiValueMapAdapter<String, String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add(HttpHeaders.SET_COOKIE, "auth-token=" + session.getToken());
        return new ResponseEntity<>(userLoginDTO, headers, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody SessionDTO sessionDTO){
        this.authService.logout(sessionDTO.getToken(), sessionDTO.getUserId());
        return new ResponseEntity<>("Logged out successfully", HttpStatus.OK);
    }

    @GetMapping("/session")
    public ResponseEntity<List<Session>> getAllSessions(){
        List<Session> sessions = this.userService.getAllSessions();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }
}
