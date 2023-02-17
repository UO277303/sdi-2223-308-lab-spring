package com.uniovi.sdi2223308spring.repositories;

import com.uniovi.sdi2223308spring.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorsRepository extends CrudRepository<Professor, Long> {
}
