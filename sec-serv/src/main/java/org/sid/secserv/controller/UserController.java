package org.sid.secserv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.sid.secserv.service.UserService;
import org.sid.secserv.entity.User;
import java.util.List;
import javax.annotation.PostConstruct;
import org.sid.secserv.dao.UserDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Map;
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasAnyRole('Admin','User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

    @GetMapping("/users")
    public List<User> getAllusers() {
        return userService.getAllUsers();
    }
    @GetMapping("/users/{userName}")
    public User getUserById(@PathVariable(value = "userName") String userName) {
            return userService.getUserById(userName);
    }

    @PutMapping("/users/{userName}")
    public User updateUser( @RequestBody User userDetails) {
        return userService.updateUser(userDetails);
    }
    @PutMapping("/users/{userName}")
    public User updatefatimaUser( @RequestBody User userDetails) {
        return userService.updateUser(userDetails);
    }
    @DeleteMapping("/users/{userName}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "userName") String userName) {
        return userService.deleteuser(userName);
    }
}