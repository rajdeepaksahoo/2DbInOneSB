package com.example.demo.repo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity1.Entity1;
import com.example.demo.entity2.Entity2;
@Repository
public interface Repo2 extends JpaRepository<Entity2, Long>{

}
