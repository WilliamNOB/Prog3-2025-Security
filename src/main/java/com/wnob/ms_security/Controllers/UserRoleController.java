package com.wnob.ms_security.Controllers;

import com.wnob.ms_security.Models.*;
import com.wnob.ms_security.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleRepository theUserRoleRepository;
    @Autowired
    private UserRepository theUserRepository;
    @Autowired
    private RoleRepository theRoleRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("user/{userId}/role/{roleId}")
    public UserRole create(@PathVariable String userId,
                           @PathVariable String roleId){
        Role theRole=this.theRoleRepository.findById(roleId)
                .orElse(null);
        User theUser=this.theUserRepository.findById((userId))
                .orElse(null);
        if(theRole!=null && theUser!=null){
            UserRole newUserRole=new UserRole();
            newUserRole.setRole(theRole);
            newUserRole.setUser(theUser);
            return this.theUserRoleRepository.save(newUserRole);
        }else{
            return null;
        }
    }
    @GetMapping("user/{userId}")
    public List<UserRole> getRolesByUser(@PathVariable String userId){
        return this.theUserRoleRepository.getRolesByUser(userId);
    }

    @GetMapping("role/{roleId}")
    public List<UserRole> getUsersByRole(@PathVariable String roleId){
        return this.theUserRoleRepository.getUsersByRole(roleId);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        User theUser = this.theUserRepository.findById(id).orElse(null);
        if (theUser != null) {
            this.theUserRepository.delete(theUser);
        }
    }
}
