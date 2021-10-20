package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IGeneralService<User> {
    Page<User> findAllByLastNameContaining(String lastName, Pageable pageable);
    boolean isLogin(User user);
}
