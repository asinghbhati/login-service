package spring.jpa.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.jpa.login.model.Users;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Users, Integer> {

    Optional<Users>  findByUserName(String userName);
    Optional<Users>  findById(int id);
}
