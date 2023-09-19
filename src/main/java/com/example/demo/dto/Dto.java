package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity1.Entity1;
import com.example.demo.entity2.Entity2;

public class Dto {
	List<Entity1> entity1s;
	List<Entity2> entity2s;
	@Override
	public String toString() {
		return "Dto [entity1s=" + entity1s + ", entity2s=" + entity2s + "]";
	}
	public List<Entity1> getEntity1s() {
		return entity1s;
	}
	public void setEntity1s(List<Entity1> entity1s) {
		this.entity1s = entity1s;
	}
	public List<Entity2> getEntity2s() {
		return entity2s;
	}
	public void setEntity2s(List<Entity2> entity2s) {
		this.entity2s = entity2s;
	}
	
}
