package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.User;
import com.example.ApiClassRomm.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository repository;

    public User saveUser(User dataUser) throws Exception {
        try {
            return this.repository.save(dataUser);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    public User modifyUser(Integer id, User dataUser) throws Exception {
        try {
            Optional<User> userSearch = this.repository.findById(id);

            if (userSearch.isPresent()) {
                return this.repository.save(userSearch.get());
            } else {
                throw new Exception("usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    public User searchUserById(Integer id) throws Exception {
        try {
            Optional<User> userSearch = this.repository.findById(id);
            if (userSearch.isPresent()) {
                return userSearch.get();
            } else {
                throw new Exception("usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    public Iterable<User> searchAllUsers() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    public String deleteUser(Integer id) throws Exception {
        try {
            Optional<User> userSearch = this.repository.findById(id);
            if (userSearch.isPresent()) {
                this.repository.deleteById(id);
                return "Usuario eliminado correctamente";
            } else {
                throw new Exception("usuario no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
