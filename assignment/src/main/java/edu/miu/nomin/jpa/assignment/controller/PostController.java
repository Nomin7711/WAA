package edu.miu.nomin.jpa.assignment.controller;

import edu.miu.nomin.jpa.assignment.entity.Post;
import edu.miu.nomin.jpa.assignment.entity.dto.PostDto;
import edu.miu.nomin.jpa.assignment.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @PutMapping
    public Post updatePost(@RequestBody Post post) {
        return postService.update(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }

    @GetMapping("/findByTitle/{title}")
    public List<PostDto> findByTitle(@PathVariable String title) {
        return postService.findByTitle(title);
    }
}
