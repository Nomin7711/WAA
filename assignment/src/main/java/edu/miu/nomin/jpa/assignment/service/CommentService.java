package edu.miu.nomin.jpa.assignment.service;

import edu.miu.nomin.jpa.assignment.entity.Comment;
import edu.miu.nomin.jpa.assignment.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }
}
