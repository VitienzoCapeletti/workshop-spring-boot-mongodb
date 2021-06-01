package com.vitienzodc.workshopmongo.repository;

import com.vitienzodc.workshopmongo.domain.Post;
import com.vitienzodc.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
