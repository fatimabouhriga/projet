package org.sid.secserv.service;

import org.sid.secserv.dao.StatusDao;
import org.sid.secserv.entity.Role;
import org.sid.secserv.entity.Status;
import org.sid.secserv.entity.User;
import org.sid.secserv.entity.User_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StatusService {

    @Autowired
    private StatusDao StatusDao;

    public List<Status> getAllStatus() {
        return (List<Status>) StatusDao.findAll();
    }

    public Status registerNewUserStatus(String username) {
        Status status = new Status(username, "deconnecter");
        return StatusDao.save(status);
    }
    public Status updateStatusdeconnecter(String user_id) throws ResourceNotFoundException {
        Status status = StatusDao.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + user_id));
        status.setStatus("deconnecter");
        Status updatedStatus = StatusDao.save(status);
        return updatedStatus;
    }

    public Status updateStatusconnecter(String user_id) throws ResourceNotFoundException {
        Status status = StatusDao.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + user_id));
        status.setStatus("connecter");
        Status updatedStatus = StatusDao.save(status);
        return updatedStatus;
    }
}
