package org.sid.secserv.service;

import org.sid.secserv.dao.User_roleDao;
import org.sid.secserv.entity.User_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class User_roleService {

    @Autowired
    private User_roleDao user_roleDao;

    public User_role getUser_roleByUser_id(String user_id) {
        Optional<User_role> userRoleOptional = user_roleDao.findById(user_id);
        if (userRoleOptional.isPresent()) {
            User_role userRole = userRoleOptional.get();
            return userRole;
        }
        return null;
    }
    public User_role updateUser_role(String user_id) throws ResourceNotFoundException {
        User_role user_role1 = user_roleDao.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + user_id));
        String role_idd =  user_role1.getRole_id();
        if (role_idd.equals("Admin")) {
            user_role1.setRole_id("User");
        }
        if (role_idd.equals("User")) {
            user_role1.setRole_id("Admin");
        }
        User_role updatedUser_role = user_roleDao.save(user_role1);
        return updatedUser_role;
    }


}
