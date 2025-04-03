package com.wnob.ms_security.Controllers;

import com.wnob.ms_security.Models.Profile;
import com.wnob.ms_security.Models.User;
import com.wnob.ms_security.Repositories.ProfileRepository;
import com.wnob.ms_security.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/profiles")
public class ProfilesController {
    @Autowired
    private ProfileRepository theProfileRepository;
    
    @Autowired
    private UserRepository theUserRepository;
    /*
        @Autowired
        private EncryptionService theEncryptionService;
    */
    @GetMapping("")
    public List<Profile> find(){
        return this.theProfileRepository.findAll();
    }
    @GetMapping("{id}")
    public Profile findById(@PathVariable String id){
        Profile theProfile=this.theProfileRepository.findById(id).orElse(null);
        return theProfile;
    }

    @PostMapping
    public Profile create(@RequestBody Profile newProfile){
        newProfile.setPhone(newProfile.getPhone());
        newProfile.setPhoto(newProfile.getPhoto());
        return this.theProfileRepository.save(newProfile);
    }

    @PutMapping("{id}")
    public Profile update(@PathVariable String id, @RequestBody Profile newProfile){
        Profile actualProfile=this.theProfileRepository.findById(id).orElse(null);
        if(actualProfile!=null){
            actualProfile.setPhone(newProfile.getPhone());
            actualProfile.setPhoto(newProfile.getPhoto());
            this.theProfileRepository.save(actualProfile);
            return actualProfile;
        }else{
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Profile theProfile=this.theProfileRepository.findById(id).orElse(null);
        if (theProfile!=null){
            this.theProfileRepository.delete(theProfile);
        }
    }

    @PutMapping("{profile_id}/user/{user_id}")
    public Profile matchProfileUser(@PathVariable String profile_id,
                                    @PathVariable String user_id) {
        Profile theActualProfile = this.theProfileRepository.findById(profile_id).orElse(null);
        User theActualUser = this.theUserRepository.findById(user_id).orElse(null);
        if(theActualProfile!=null && theActualUser!=null){
            theActualProfile.setUser(theActualUser);
            return this.theProfileRepository.save(theActualProfile);
        }else{
            return null;
        }
    }

    @PutMapping("{profile_id}/user")
    public Profile unMatchProfileUser(@PathVariable String profile_id) {
        Profile theActualProfile = this.theProfileRepository.findById(profile_id).orElse(null);
        if(theActualProfile!=null){
            theActualProfile.setUser(null);
            return this.theProfileRepository.save(theActualProfile);
        }else{
            return null;
        }
    }
}
