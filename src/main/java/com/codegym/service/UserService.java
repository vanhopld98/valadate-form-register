package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean save(User user) {
        List<User> users = (List<User>) findAll();
        for (User user1 : users) {
            if (user.getUserName().equals(user1.getUserName())) {
                return false;
            }
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public Page<User> findAllByLastNameContaining(String lastName, Pageable pageable) {
        return userRepository.findAllByLastNameContaining(lastName, pageable);
    }

    @Override
    public boolean isLogin(User user){
        List<User> users = (List<User>) findAll();
        for (int i = 0; i < users.size(); i++) {
            if (user.getUserName().equals(users.get(i).getUserName()) && user.getPassword().equals(users.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
}
