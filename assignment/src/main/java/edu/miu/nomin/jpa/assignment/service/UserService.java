package edu.miu.nomin.jpa.assignment.service;

import edu.miu.nomin.jpa.assignment.entity.User;
import edu.miu.nomin.jpa.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public User findByName(String username) {
        return userRepository.findByName(username);
    }
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getUsersWithMoreThanOnePost(){
        return userRepository.findUsersWithMoreThanOnePost();
    }

}
