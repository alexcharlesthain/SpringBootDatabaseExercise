package com.qa.thain.alex.springboot.database.app.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.thain.alex.springboot.database.app.application.model.*;

@Repository
public interface personRepository extends JpaRepository<MySpringBootDatabaseModel,Long> {

}
