package tech.getarrays.garageApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.garageApp.Dto.LoginDTO;
import tech.getarrays.garageApp.Dto.UserDTO;
import tech.getarrays.garageApp.model.User;
import tech.getarrays.garageApp.repo.UserRepo;
import tech.getarrays.garageApp.response.LoginResponse;
import tech.getarrays.garageApp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {

        User user = new User(userDTO.getUserid(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );

        userRepo.save(user);

        return user.getUsername();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()){
                    return new LoginResponse("Login Success", false);
                }
                else {
                    return new LoginResponse("Login Failed", false);
                }
            }
            else {
                return new LoginResponse("Password Does Not Match", false);
            }
        }
        else {
            return new LoginResponse("Email Does Not Exist", false);
        }
    }
}
