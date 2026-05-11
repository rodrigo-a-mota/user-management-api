package com.rodrigo.user_management_api.service;

import com.rodrigo.user_management_api.model.User;
import com.rodrigo.user_management_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return  userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }

    public User updateUser(Long id, User user) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());

        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        User user =  getUserById(id);
        userRepository.delete(user);
    }

}
