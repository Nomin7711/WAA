package edu.miu.nomin.jpa.assignment.repository.impl;

import edu.miu.nomin.jpa.assignment.entity.Post;
import edu.miu.nomin.jpa.assignment.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static List<Post> posts = new ArrayList<>();
    static {
        posts.add(new Post(1l, "Harry Poter", "Child book", "J.K.Rowling"));
        posts.add(new Post(2l, "Alice wonderland", "Advanture book", "Bob"));
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Post save(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public void delete(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }

    @Override
    public Post update(Post post) {
        Post updatedPost = findById(post.getId());
        if (updatedPost != null) {
            updatedPost.setTitle(post.getTitle());
            updatedPost.setContent(post.getContent());
            updatedPost.setAuthor(post.getAuthor());
            return updatedPost;
        }
        return null;
    }
}
