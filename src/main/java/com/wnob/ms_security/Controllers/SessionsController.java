package com.wnob.ms_security.Controllers;

import com.wnob.ms_security.Models.Session;
import com.wnob.ms_security.Repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository theSessionRepository;
    /*
        @Autowired
        private EncryptionService theEncryptionService;
    */
    @GetMapping("")
    public List<Session> find(){
        return this.theSessionRepository.findAll();
    }
    @GetMapping("{id}")
    public Session findById(@PathVariable String id){
        Session theSession=this.theSessionRepository.findById(id).orElse(null);
        return theSession;
    }
    /*
    @PostMapping
    public Session create(@RequestBody Session newSession){
        newSession.se(newSession.getPassword());
        return this.theSessionRepository.save(newSession);
    }
*/
    @PutMapping("{id}")
    public Session update(@PathVariable String id, @RequestBody Session newSession){
        Session actualSession=this.theSessionRepository.findById(id).orElse(null);
        if(actualSession!=null){
            actualSession.setToken(newSession.getToken());
            actualSession.setExpiration(newSession.getExpiration());
            actualSession.setCode2FA(newSession.getCode2FA());
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
}
