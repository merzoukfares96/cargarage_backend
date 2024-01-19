package tech.getarrays.garageApp.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.garageApp.Dto.LoginDTO;
import tech.getarrays.garageApp.Dto.UserDTO;
import tech.getarrays.garageApp.model.User;
import tech.getarrays.garageApp.response.LoginResponse;
import tech.getarrays.garageApp.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        return userService.addUser(userDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @RequestMapping(path = "/check")
    public ResponseEntity<String>  checkUsername(@RequestParam String username, @RequestParam String email) {
        List<User> users = userService.findAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
                return ResponseEntity.ok("{\"status\": \"user_exists\"}");
            }
        }
        return ResponseEntity.ok("{\"status\": \"user_not_exists\"}");
    }
}
