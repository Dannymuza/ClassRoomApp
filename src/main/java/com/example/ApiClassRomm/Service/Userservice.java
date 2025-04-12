package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.User;
import com.example.ApiClassRomm.repository.IUserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userservice {

    @Autowired
    IUserRepositorie repositorie;

    //guardar
    public User saveUser(User dataUser) throws Exception {
        try {
            return this.repositorie.save(dataUser);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    //modificar
    public User modifyUser(Integer id, User dataUser) throws Exception {
        try {
            Optional<User> userSearch = this.repositorie.findById(id);

            if (userSearch.isPresent()) {
                //modificando campos
                userSearch.get().setName(dataUser.getName());
                userSearch.get().setEmail(dataUser.getEmail()); // ejemplo adicional
                return this.repositorie.save(userSearch.get());
            } else {
                throw new Exception("usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public User searchUserById(Integer id) throws Exception {
        try {
            Optional<User> userSearch = this.repositorie.findById(id);
            if (userSearch.isPresent()) {
                return userSearch.get();
            } else {
                throw new Exception("usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos
    public Iterable<User> searchAllUsers() throws Exception {
        try {
            return this.repositorie.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar
    public String deleteUser(Integer id) throws Exception {
        try {
            Optional<User> userSearch = this.repositorie.findById(id);
            if (userSearch.isPresent()) {
                this.repositorie.deleteById(id);
                return "Usuario eliminado correctamente";
            } else {
                throw new Exception("usuario no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
