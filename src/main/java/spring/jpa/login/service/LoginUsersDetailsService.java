package spring.jpa.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.jpa.login.model.LoginUserDetails;
import spring.jpa.login.model.Users;
import spring.jpa.login.repository.LoginRepository;

import java.util.Optional;

@Service
public class LoginUsersDetailsService implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public LoginUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
         //return new LoginUserDetails(userName);
         //Optional<Users> users = loginRepository.findById(1);

        System.out.println("Login service called");
         Optional<Users> user = loginRepository.findByUserName(userName.toLowerCase());
         //pass the user to userdetails servive
        user.orElseThrow(()->new UsernameNotFoundException("User not found"+userName));

       return  user.map(LoginUserDetails::new).get();

    }


    public LoginUserDetails userLogin(String userName) throws UsernameNotFoundException {

        System.out.println("Login service called");
        Optional<Users> user = loginRepository.findByUserName(userName.toLowerCase());
        user.orElseThrow(()->new UsernameNotFoundException("User not found"+userName));

        return   user.map(LoginUserDetails::new).get();

    }
}
