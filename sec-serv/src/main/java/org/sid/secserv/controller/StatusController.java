package org.sid.secserv.controller;

import org.sid.secserv.dao.StatusDao;
import org.sid.secserv.entity.Status;
import org.sid.secserv.entity.User;
import org.sid.secserv.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StatusController {
    @Autowired
    private StatusService StatusService;
    @Autowired
    private StatusDao StatusDao;

    @PostMapping({"/registerNewUserStatus/{userName}"})
    public Status registerNewUserStatus(@PathVariable(value = "userName") String username) {
        return StatusService.registerNewUserStatus(username);
    }

    @GetMapping("/status")
    public List<Status> getAllStatus() {
        return StatusService.getAllStatus();
    }

    @PutMapping("/statusdeconnecter/{userName}")
    public Status updateStatusdeconnecter( @PathVariable(value = "userName")String userName) {
        return StatusService.updateStatusdeconnecter(userName);
    }
    @PutMapping("/statusconnecter/{userName}")
    public Status updateStatusconnecter( @PathVariable(value = "userName")String userName) {
        return StatusService.updateStatusconnecter(userName);
    }
}
