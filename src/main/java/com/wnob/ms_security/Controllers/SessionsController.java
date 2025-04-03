package com.wnob.ms_security.Controllers;

import com.wnob.ms_security.Models.Session;
import com.wnob.ms_security.Models.User;
import com.wnob.ms_security.Repositories.SessionRepository;
import com.wnob.ms_security.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sessions")
public class SessionsController {
    /*
    @Autowired
    private SessionRepository theSessionRepository;

    @Autowired
    private UserRepository theUserRepository;
    /*
        @Autowired
        private EncryptionService theEncryptionService;
    */
    /*
    @GetMapping("")
    public List<Session> find(){
        return this.theSessionRepository.findAll();
    }
    @GetMapping("{id}")
    public Session findById(@PathVariable String id){
        Session theSession=this.theSessionRepository.findById(id).orElse(null);
        return theSession;
    }

    @PostMapping
    public Session create(@RequestBody Session newSession){
        newSession.setToken(newSession.getToken());
        newSession.setStarted_At(newSession.getStarted_At());
        newSession.setEnd_At(newSession.getEnd_At());
        newSession.setToken2FA(newSession.getToken2FA());
        return this.theSessionRepository.save(newSession);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("{id}")
    public Session update(@PathVariable String id, @RequestBody Session newSession){
        Session actualSession=this.theSessionRepository.findById(id).orElse(null);
        if(actualSession!=null){
            actualSession.setToken(newSession.getToken());
            actualSession.setStarted_At(newSession.getStarted_At());
            actualSession.setEnd_At(newSession.getEnd_At());
            actualSession.setToken2FA(newSession.getToken2FA());
            this.theSessionRepository.save(actualSession);
            return actualSession;
        }else{
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Session theSession=this.theSessionRepository.findById(id).orElse(null);
        if (theSession!=null){
            this.theSessionRepository.delete(theSession);
        }
    }

    @PutMapping("{session_id}/user/{user_id}")
    public Session matchSessionUser(@PathVariable String session_id,
                                   @PathVariable String user_id) {
        Session theActualSession = this.theSessionRepository.findById(session_id).orElse(null);
        User theActualUser = this.theUserRepository.findById(user_id).orElse(null);
        if(theActualSession!=null && theActualUser!=null){
            theActualSession.setUser(theActualUser);
            return this.theSessionRepository.save(theActualSession);
        }else{
            return null;
        }
    }

    @PutMapping("{session_id}/user")
    public Session unMatchSessionUser(@PathVariable String session_id) {
        Session theActualSession = this.theSessionRepository.findById(session_id).orElse(null);
        if(theActualSession!=null){
            theActualSession.setUser(null);
            return this.theSessionRepository.save(theActualSession);
        }else{
            return null;
        }
    }*/
}
