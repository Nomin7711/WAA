package edu.miu.nomin.jpa.assignment.service;

import edu.miu.nomin.jpa.assignment.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post savePost(Post post);
    void deletePost(Long id);
    Post updatePost(Post post);
}
