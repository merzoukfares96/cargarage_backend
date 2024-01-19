package tech.getarrays.garageApp.service;

import tech.getarrays.garageApp.Dto.LoginDTO;
import tech.getarrays.garageApp.Dto.UserDTO;
import tech.getarrays.garageApp.model.User;
import tech.getarrays.garageApp.response.LoginResponse;

import java.util.List;

public interface UserService {


    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
    List<User> findAllUsers();
}
