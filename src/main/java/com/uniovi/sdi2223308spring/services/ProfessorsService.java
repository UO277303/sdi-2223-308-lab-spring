package com.uniovi.sdi2223308spring.services;

import com.uniovi.sdi2223308spring.entities.Mark;
import com.uniovi.sdi2223308spring.entities.Professor;
import com.uniovi.sdi2223308spring.repositories.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorsService {
    @Autowired
    private ProfessorsRepository professorsRepository;

    public List<Professor> getProfessors() {
        List<Professor> profList = new ArrayList<Professor>();
        professorsRepository.findAll().forEach(profList::add);
        return profList;
    }
    public Professor getProfessor(Long id) {
        return professorsRepository.findById(id).get();
    }
    public void addProfessor(Professor p) {
        professorsRepository.save(p);
    }
    public void deleteProfessor(Long id) {
        professorsRepository.deleteById(id);
    }
    public Professor getProfessorByDni(String dni){
        return professorsRepository.findByDni(dni);
    }
}
