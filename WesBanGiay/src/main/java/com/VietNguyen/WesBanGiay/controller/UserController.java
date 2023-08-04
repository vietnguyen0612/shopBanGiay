package com.VietNguyen.WesBanGiay.controller;

import com.VietNguyen.WesBanGiay.DTO.LoginRequestDTO;
import com.VietNguyen.WesBanGiay.entity.User;
import com.VietNguyen.WesBanGiay.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/")
    public List<User> getAllUser(){
        return iUserService.getAllUser();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return iUserService.getUserById(id);
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        return iUserService.addUser(user);
    }

    @PutMapping("/edit-user/{id}")
    public User editUser(@RequestBody User newUser,@PathVariable Long id){
        return iUserService.updateUser(id, newUser);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id ){
        return iUserService.deleteUser(id);
    }

    @PostMapping("/user-login")
    public User login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return iUserService.userLogin(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
    }

}
