package com.luisgr.app.business;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisgr.app.entity.Recipe;
import com.luisgr.app.repository.RecipeRepository;

@Service
public class RecipeBusiness {

	@Autowired
	private RecipeRepository repository;
	
	public Set<Recipe> findAll() {
		return new HashSet<Recipe>(repository.findAll());
	}
	
	public Recipe findOne(String id) {
		return repository.findOne(id);
	}
	
	public Recipe insert(Recipe recipe){
		if(!recipe.isNull()){
			return repository.insert(recipe);	
		}
		return null;
	}

	public Recipe update(String id, Recipe recipe) {
		if(repository.exists(id)){
			recipe.setId(id);
			return repository.save(recipe);
		}
		return null;
	}

	public void delete(String id) {
		repository.delete(id);
	}

}
