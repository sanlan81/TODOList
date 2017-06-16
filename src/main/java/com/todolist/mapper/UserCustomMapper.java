/*package com.todolist.mapper;

import com.todolist.bean.UserRegistrationBean;
import com.todolist.entity.User;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserCustomMapper extends CustomMapper<User ,UserRegistrationBean>{
    @Override
    public void mapAtoB(User user, UserRegistrationBean userRegistrationBean, MappingContext context) {

        Optional.ofNullable(userRegistrationBean.getFirstName())
                .ifPresent(user::setFirstName);

        Optional.ofNullable(userRegistrationBean.getPassword())
                .ifPresent(user::setPassword);
    }
}*/
