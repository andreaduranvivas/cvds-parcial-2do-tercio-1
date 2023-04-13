package edu.eci.cvds.controllers;

import edu.eci.cvds.model.User;
import edu.eci.cvds.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

import edu.eci.cvds.repositories.*;
@Component
@ManagedBean(name = "user")
@SessionScoped
public class UserBean implements Serializable {
    private final UserRepository userRepository;
    @Autowired
    UserService userService;
    private String user = " ";
    private String password;

    public UserBean(UserRepository usuarioRepository){
        this.userRepository = usuarioRepository;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        User user = userRepository.findById(this.user);
        if (user == null || !user.getPassword().equals(password)) {
            FacesContext.getCurrentInstance().addMessage("@all", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Los datos ingresados no coinciden, vuelva a ingresarlos.", null));
            return null;
        } else {
            return "guess.xhtml";
        }
    }
    @Bean
    public CommandLineRunner currentUser() throws Exception{
        return args -> {
            userService.addUsuario(new User("root", "1234"));
            userService.addUsuario(new User("andrea", "222"));
            // userService.getAllUsers().forEach(System.out::println);
        };
    }
}
