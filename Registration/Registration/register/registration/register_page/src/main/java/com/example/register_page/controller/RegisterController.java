package com.example.register_page.controller;

import com.example.register_page.model.Register;
import com.example.register_page.repository.RegisterRepository;
import com.example.register_page.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RegisterController {

    private final RegisterService registerService;
    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterController(RegisterService registerService, RegisterRepository registerRepository) {
        this.registerService = registerService;
        this.registerRepository = registerRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createRegister(@RequestBody Register register) {

        // Check if user with same fullname exists
        if (registerRepository.existsById(register.getFullname())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User with fullname \"" + register.getFullname() + "\" already exists");
        }

        // Password match check
        if (!register.getPassword().equals(register.getConfirmpassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Password and Confirm Password do not match");
        }

        // Save user
        registerRepository.save(register);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registration successful for fullname: " + register.getFullname());
    }
}
