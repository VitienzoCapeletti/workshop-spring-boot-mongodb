package com.vitienzodc.workshopmongo.services;

import com.vitienzodc.workshopmongo.domain.Post;
import com.vitienzodc.workshopmongo.domain.User;
import com.vitienzodc.workshopmongo.dto.UserDTO;
import com.vitienzodc.workshopmongo.repository.PostRepository;
import com.vitienzodc.workshopmongo.repository.UserRepository;
import com.vitienzodc.workshopmongo.servicesException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> finByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
