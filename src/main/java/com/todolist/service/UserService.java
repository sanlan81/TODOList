package com.todolist.service;


import com.todolist.bean.UserRegistrationBean;
import com.todolist.entity.User;
import com.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public void createUser(UserRegistrationBean userRegistrationBean) {
        User user = new User();
        user.setFirstName(userRegistrationBean.getFirstName());
        user.setPassword(userRegistrationBean.getPassword());
        userRepository.save(user);
    }

    public User getUser(String name) {
        return userRepository.findOneByFirstName(name);
    }
}
