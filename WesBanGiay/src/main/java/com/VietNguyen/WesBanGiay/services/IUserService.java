package com.VietNguyen.WesBanGiay.services;

import com.VietNguyen.WesBanGiay.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> getAllUser();

    public Optional<User> getUserById(Long id);
    public User addUser(User user);

    public User updateUser(Long id, User user);
    public String deleteUser(Long id);
    public User userLogin(String email, String password);
}
