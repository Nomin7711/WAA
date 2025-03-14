package edu.miu.nomin.jpa.assignment.controller;

import edu.miu.nomin.jpa.assignment.entity.Comment;
import edu.miu.nomin.jpa.assignment.entity.Post;
import edu.miu.nomin.jpa.assignment.entity.User;
import edu.miu.nomin.jpa.assignment.entity.dto.PostDto;
import edu.miu.nomin.jpa.assignment.service.PostService;
import edu.miu.nomin.jpa.assignment.service.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Autowired
    EntityManager entityManager;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getPosts(@PathVariable long id) {
        User user = userService.getUserById(id);
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

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteById(id);
    }
    @GetMapping("/more-than-n-post/{n}")
    public List<User> getUsersWithMoreThanNPost(@PathVariable int n) {
        return userService.getUsersWithMoreThanNPost(n);
    }

    @GetMapping("/findUsersWithTitle/{title}")
    public List<User> findUsersWithTitle(@PathVariable String title) {
        return userService.getUsersWithTitle(title);
    }
    @GetMapping("/{id}/posts/{postId}")
    public Post getUser(@PathVariable long id, @PathVariable long postId) {
        User user = userService.getUserById(id);
        if (user == null) return null;
        return user.getPosts().stream().filter(post -> post.getId() == postId).findFirst().orElse(null);
    }
    @GetMapping("/{id}/posts/{postId}/comments/{commentId}")
    public Comment getUserComment(@PathVariable long id, @PathVariable long postId, @PathVariable long commentId) {
        User user = userService.getUserById(id);
        if (user == null) return null;
        List<Post> posts = user.getPosts();
        if (posts == null || posts.isEmpty()) return null;
        Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().orElse(null);
        if (post == null) return null;
        return post.getComments().stream().filter(c -> c.getId() == commentId).findFirst().orElse(null);
    }
    @GetMapping("/test")
    public String test() {
        User user = userService.findByName("test");
        List<Post> posts = user.getPosts();
        entityManager.detach(user);
        posts.get(0).setAuthor("test");
        return "done";
    }
}
