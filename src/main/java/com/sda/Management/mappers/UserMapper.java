package com.sda.Management.mappers;

import com.sda.Management.dto.UserRegistrationDto;
import com.sda.Management.models.User.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

        public UserRegistrationDto convertEntityToDto(User user){
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setGender(user.getGender());
        userDto.setBirthdate(user.getBirthdate());
        return userDto;
    }

}