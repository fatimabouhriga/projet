package org.sid.secserv.service;

import org.sid.secserv.dao.User_roleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_roleService {
    @Autowired
    private User_roleDao user_roleDao;

}
