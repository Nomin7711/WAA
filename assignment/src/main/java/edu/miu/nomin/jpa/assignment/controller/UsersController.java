package edu.miu.nomin.jpa.assignment.controller;

import edu.miu.nomin.jpa.assignment.entity.Post;
import edu.miu.nomin.jpa.assignment.entity.User;
import edu.miu.nomin.jpa.assignment.entity.dto.PostDto;
import edu.miu.nomin.jpa.assignment.service.PostService;
import edu.miu.nomin.jpa.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        List<Post> posts = user.getPosts();
        for (Post post : posts) {
            postService.save(post);
        }
        return userService.save(user);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.findById(id);
    }
    @GetMapping("/{id}/posts")
    public List<PostDto> getPosts(@PathVariable long id) {
        User user = userService.findById(id);
        if (user == null) return null;
        List<Post> posts = user.getPosts();
        if (posts != null && !posts.isEmpty()) {
            return posts.stream()
                    .map(post -> postService.convertToPostDTO(post))
                    .collect(Collectors.toList());
        }
        return null;
    }
    @GetMapping("/more-than-one-post")
    public List<User> getUsersWithMoreThanOnePost() {
        return userService.getUsersWithMoreThanOnePost();
    }
}
