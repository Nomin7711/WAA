package edu.miu.nomin.jpa.assignment.repository;

import edu.miu.nomin.jpa.assignment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
