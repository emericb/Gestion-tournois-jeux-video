package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.User;
import org.project.gestiontournoisjeuxvideo.repository.UserRepository;
import org.project.gestiontournoisjeuxvideo.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String username, String password, String email, Role role) {
        if (userRepository.findByEmail(email) != null) {
            return null;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);

        return userRepository.save(user);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}

