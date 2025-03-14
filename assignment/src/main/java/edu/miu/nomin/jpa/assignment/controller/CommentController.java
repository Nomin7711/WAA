package edu.miu.nomin.jpa.assignment.controller;

import edu.miu.nomin.jpa.assignment.entity.Comment;
import edu.miu.nomin.jpa.assignment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping
    public List<Comment> getComments() {
        return commentService.findAll();
    }
    @GetMapping("/{id}")
    public Comment getComment(@PathVariable Long id) {
        return commentService.findById(id);
    }
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

}
