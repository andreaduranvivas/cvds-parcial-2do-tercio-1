package edu.eci.cvds.repositories;

import edu.eci.cvds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(String userId);

    User findById(String userId);

}