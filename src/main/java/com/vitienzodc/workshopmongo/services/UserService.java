package com.vitienzodc.workshopmongo.services;

import com.vitienzodc.workshopmongo.domain.User;
import com.vitienzodc.workshopmongo.dto.UserDTO;
import com.vitienzodc.workshopmongo.repository.UserRepository;
import com.vitienzodc.workshopmongo.servicesException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
    }

}
