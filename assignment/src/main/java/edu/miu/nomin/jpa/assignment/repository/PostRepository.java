package edu.miu.nomin.jpa.assignment.repository;

import edu.miu.nomin.jpa.assignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
}
