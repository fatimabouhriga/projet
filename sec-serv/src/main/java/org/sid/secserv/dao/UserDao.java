package org.sid.secserv.dao;

import org.sid.secserv.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDao extends CrudRepository<User, String> {
}