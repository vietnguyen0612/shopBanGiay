package com.VietNguyen.WesBanGiay.services;

import com.VietNguyen.WesBanGiay.entity.User;
import com.VietNguyen.WesBanGiay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        if(user != null){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        if(user != null){
            User user1 = userRepository.getById(id);
            if(user1 != null) {
                user1.setAdminId(user.getAdminId());
                user1.setEmail(user.getEmail());
                user1.setCustomerId(user.getCustomerId());
                user1.setPhoneNumber(user.getPhoneNumber());
                user1.setFullName(user.getFullName());
                user1.setSellId(user.getSellId());
                user1.setPassword(user.getPassword());

                return userRepository.save(user1);
            }
        }
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            return "no use by id";
        }
        userRepository.deleteById(id);
        return "User with id " +id+ " has been deleted success!";
    }

    @Override
    public User userLogin(String email, String password) {
        if(userRepository.findByEmailAndPassword(email, password) != null){
            User user1 = userRepository.findByEmailAndPassword(email, password);
            return user1;
        }
        return null;
    }
}
