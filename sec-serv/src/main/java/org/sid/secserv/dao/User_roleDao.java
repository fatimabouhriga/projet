package org.sid.secserv.dao;

import org.sid.secserv.entity.User_role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface User_roleDao extends CrudRepository<User_role, String> {
}

