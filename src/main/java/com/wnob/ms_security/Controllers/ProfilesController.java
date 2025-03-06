package com.wnob.ms_security.Controllers;

import com.wnob.ms_security.Models.Profile;
import com.wnob.ms_security.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/profiles")
public class ProfilesController {
    @Autowired
    private ProfileRepository theProfileRepository;
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
    /*
    @PostMapping
    public Profile create(@RequestBody Profile newProfile){
        newProfile.setPassword(this.theEncryptionService.convertSHA256(newProfile.getPassword()));
        return this.theProfileRepository.save(newProfile);
    }
     */
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
}
