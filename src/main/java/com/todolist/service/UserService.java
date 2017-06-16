package com.todolist.service;


import com.todolist.bean.UserRegistrationBean;
import com.todolist.entity.User;
import com.todolist.repository.UserRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MapperFacade mapperFacade;


    @Autowired
    public UserService(UserRepository userRepository, MapperFacade mapperFacade) {
        this.userRepository = userRepository;
        this.mapperFacade = mapperFacade;
    }

    public void createUser(UserRegistrationBean userRegistrationBean) {
        User user = new User();
        user.setFirstName(userRegistrationBean.getFirstName());
        user.setPassword(userRegistrationBean.getPassword());
        //User user = mapperFacade.map(userRegistrationBean, User.class);
        userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findOne(id);
    }
}
