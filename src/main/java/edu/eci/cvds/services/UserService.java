package edu.eci.cvds.services;

import edu.eci.cvds.model.User;
import edu.eci.cvds.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User addUsuario(User user){
        return userRepository.save(user);
    }
    public User getUsuario (String userId){
        return userRepository.findById(userId);
    }

    public User updateUsuario(User user){
        if(userRepository.existsById(user.getId())){
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUsuario(Long userId){
        userRepository.deleteById(userId);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}