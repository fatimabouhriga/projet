package org.sid.secserv.dao;

import org.springframework.stereotype.Repository;
import org.sid.secserv.entity.Status;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface StatusDao extends CrudRepository<Status, String> {
}
