package org.sid.secserv.controller;
import org.sid.secserv.dao.User_roleDao;
import org.sid.secserv.entity.User;
import org.sid.secserv.entity.User_role;
import org.sid.secserv.service.User_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class User_roleController {
    @Autowired
    private User_roleService User_roleService;
    @Autowired
    private User_roleDao User_roleDao;
    @GetMapping("/User_role/{user_id}")
    public User_role getUserById(@PathVariable(value = "user_id") String user_id) {
        return User_roleService.getUser_roleByUser_id(user_id);
    }
    @PutMapping("/User_role/{User_id}")
    public User_role updateRoleIdByUserId(@PathVariable(value = "User_id")String user_id) {
        return User_roleService.updateUser_role(user_id);
    }
}
