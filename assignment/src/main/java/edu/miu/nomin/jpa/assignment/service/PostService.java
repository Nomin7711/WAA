package edu.miu.nomin.jpa.assignment.service;

import edu.miu.nomin.jpa.assignment.entity.Post;
import edu.miu.nomin.jpa.assignment.entity.dto.PostDto;
import edu.miu.nomin.jpa.assignment.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Post save(Post post) {
        return postRepository.save(post);
    }
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }
    public List<Post> getAll(){
        return postRepository.findAll();
    }
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
    public Post update(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
            return postRepository.save(existingPost);
        }
        return null;
    }
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
    public PostDto convertToPostDTO(Post post) {
        return modelMapper.map(post, PostDto.class);
    }
    public List<PostDto> findByTitle(String title) {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> posts = postRepository.findByTitle(title);
        posts.forEach(post -> postDtos.add(convertToPostDTO(post)));
        return postDtos;
    }
}
