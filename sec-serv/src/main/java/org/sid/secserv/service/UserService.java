package org.sid.secserv.service;
import org.sid.secserv.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.sid.secserv.dao.RoleDao;
import org.sid.secserv.entity.User;
import org.sid.secserv.entity.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }
    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }

    public User getUserById(String userName){
        return userDao.findById(userName).orElse(new User(null,"","","",null));
    }

    public User updateUser(User employeeDetails)  throws ResourceNotFoundException{
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        User user = userDao.findById(employeeDetails.getUserName()).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeDetails.getUserName()));;
        user.setUserName(employeeDetails.getUserName());
        user.setUserFirstName(employeeDetails.getUserFirstName());
        user.setUserLastName(employeeDetails.getUserLastName());
        if(employeeDetails.getUserPassword() != "nn") {
            user.setUserPassword(getEncodedPassword(employeeDetails.getUserPassword()));
        }
        user.setRole((Set<Role>) userRoles);
        User updatedUser;
        updatedUser = userDao.save(user);
        return updatedUser;
    }
    public Map<String, Boolean> deleteuser(String userName) throws ResourceNotFoundException {
        User user = userDao.findById(userName).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userName));
        userDao.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        //User adminUser = new User();
        //adminUser.setUserName("admin123");
        //adminUser.setUserPassword(getEncodedPassword("admin"));
        //adminUser.setUserFirstName("admin");
        //adminUser.setUserLastName("admin");
        //Set<Role> adminRoles = new HashSet<>();
        //adminRoles.add(adminRole);
        //adminUser.setRole(adminRoles);
        //userDao.save(adminUser);

        //User user = new User();
        //user.setUserName("user123");
        //user.setUserPassword(getEncodedPassword("user"));
        //user.setUserFirstName("user");
        //user.setUserLastName("user");
        //Set<Role> userRoles = new HashSet<>();
        //userRoles.add(userRole);
        //user.setRole(userRoles);
        //userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}