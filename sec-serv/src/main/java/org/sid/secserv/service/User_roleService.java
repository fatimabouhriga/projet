package org.sid.secserv.service;

import org.sid.secserv.dao.User_roleDao;
import org.sid.secserv.entity.User_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class User_roleService {

    @Autowired
    private User_roleDao user_roleDao;

    public String getUser_roleByUser_id(String user_id) {
        Optional<User_role> userRoleOptional = user_roleDao.findById(user_id);
        if (userRoleOptional.isPresent()) {
            User_role userRole = userRoleOptional.get();
            return userRole.getRole_id();
        }
        return null; // ou une valeur par défaut appropriée si aucun rôle correspondant n'est trouvé
    }


}
