package edu.miu.nomin.jpa.assignment.service;

import edu.miu.nomin.jpa.assignment.entity.Comment;
import edu.miu.nomin.jpa.assignment.entity.Role;
import edu.miu.nomin.jpa.assignment.repository.CommentRepository;
import edu.miu.nomin.jpa.assignment.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    public Role findByRole(String role) {return roleRepository.findByRole(role);}
}
