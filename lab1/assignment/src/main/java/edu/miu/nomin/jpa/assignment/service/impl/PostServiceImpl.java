package edu.miu.nomin.jpa.assignment.service.impl;

import edu.miu.nomin.jpa.assignment.entity.Post;
import edu.miu.nomin.jpa.assignment.repository.PostRepository;
import edu.miu.nomin.jpa.assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.delete(id);
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.update(post);
    }
}
