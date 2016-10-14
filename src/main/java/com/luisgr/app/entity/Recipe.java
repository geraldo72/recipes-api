package com.luisgr.app.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="recepies")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private List<Ingredient> ingredients;
	private String howMade;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getHowMade() {
		return howMade;
	}

	public void setHowMade(String howMade) {
		this.howMade = howMade;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Boolean isNull(){
		return id==null && (ingredients == null || ingredients.isEmpty()) && StringUtils.isEmpty(howMade);
	}

}
