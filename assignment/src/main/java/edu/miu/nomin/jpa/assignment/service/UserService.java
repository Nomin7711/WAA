package edu.miu.nomin.jpa.assignment.service;

import edu.miu.nomin.jpa.assignment.annotation.ExecutionTime;
import edu.miu.nomin.jpa.assignment.entity.User;
import edu.miu.nomin.jpa.assignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User findByName(String username) {
        return userRepository.findByName(username);
    }

    @ExecutionTime
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getUsersWithMoreThanOnePost(){
        return userRepository.findUsersWithMoreThanOnePost();
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> getUsersWithMoreThanNPost(int n) {
        return userRepository.findUsersWithMoreThanNPosts(n);
    }
    public List<User> getUsersWithTitle(String title) {
        return userRepository.findUsersWithTitle(title);
    }

}
