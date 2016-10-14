package com.luisgr.app.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisgr.app.business.RecipeBusiness;
import com.luisgr.app.entity.Recipe;

@RestController
@RequestMapping(value = "/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeBusiness business;
	
	@GetMapping
	public ResponseEntity<Set<Recipe>> findAll(){
		Set<Recipe> all = business.findAll();
		if(all != null && !all.isEmpty()){
			return new ResponseEntity<>(all,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Recipe> findOne(@PathVariable String id){
		Recipe recipe = business.findOne(id);
		if(recipe != null){
			return new ResponseEntity<>(recipe,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Recipe> insert(@RequestBody Recipe recipe){
		return new ResponseEntity<Recipe>(business.insert(recipe),HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Recipe> update(@PathVariable String id,@RequestBody Recipe recipe){
		return new ResponseEntity<Recipe>(business.update(id,recipe),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Recipe> delete(@PathVariable String id){
		business.delete(id);
		return new ResponseEntity<Recipe>(HttpStatus.OK);
	}

}
