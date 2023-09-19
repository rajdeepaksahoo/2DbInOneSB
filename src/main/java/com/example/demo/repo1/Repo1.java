package com.example.demo.repo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity1.Entity1;
@Repository
public interface Repo1 extends JpaRepository<Entity1, Long>{

}
