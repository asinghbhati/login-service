package spring.jpa.login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.jpa.login.model.LoginUserDetails;
import spring.jpa.login.model.Luser;
import spring.jpa.login.model.Users;
import spring.jpa.login.service.LoginUsersDetailsService;


@RestController
@RequestMapping("/subhlabh")
public class LoginController {

    @Autowired
    LoginUsersDetailsService service;

    @GetMapping("/login")
    public String userLogin(){
        System.out.println(":::::::::>>> Service called");
         return "You are Authorized";
    }


    //public ResponseEntity<LoginUserDetails> userLogin(@RequestBody Luser luser){
//    {
//        "password": "apsb",
//            "authorities": [
//        {
//            "authority": "USER"
//        }
//    ],
//        "enabled": true,
//            "username": "guest",
//            "accountNonExpired": true,
//            "accountNonLocked": true,
//            "credentialsNonExpired": true
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public String userLogin(@RequestBody Luser luser){

        LoginUserDetails loginUserDetails = service.userLogin(luser.getUserName());
        ResponseEntity<LoginUserDetails> userResponseEntity=null;
        String val="false";

        //for future we can use loginUserDetails
        if(loginUserDetails.getPassword().equalsIgnoreCase(luser.getPassword())){
            userResponseEntity = new ResponseEntity(loginUserDetails,HttpStatus.OK);
            val="true";
        }
        return val;
    }
}
