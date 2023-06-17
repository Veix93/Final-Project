package com.sda.Management.services;

import com.sda.Management.dto.UserRegistrationDto;
import com.sda.Management.models.User.User;

import java.util.List;

public interface UserService {

    void saveUser(UserRegistrationDto userRegistrationDto);
    User findByEmail(String email);
    List<UserRegistrationDto> findAllUsers();
    User findByUsername(String username);

}
