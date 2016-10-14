package com.luisgr.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.luisgr.app.entity.Recipe;

public interface RecipeRepository extends MongoRepository<Recipe, String>{

}
