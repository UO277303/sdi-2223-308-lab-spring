package com.uniovi.sdi2223308spring.services;

import com.uniovi.sdi2223308spring.entities.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorsService {
    private List<Professor> professors = new LinkedList<Professor>();

    public ProfessorsService() {
        professors.add(new Professor(1L, "DNI1", "Paco", "Fernandez", "Ciencias"));
        professors.add(new Professor(2L, "DNI2", "Pedro", "Lopez", "Letras"));
        professors.add(new Professor(3L, "DNI3", "Maria", "Lopez", "Economia"));
        professors.add(new Professor(4L, "DNI4", "Pablo", "Hernandez", "Ciencias"));
    }

    public List<Professor> getProfessors() {
        return professors;
    }
    public Professor getProfessor(Long id) {
        return professors.stream().filter(professor -> professor.getId().equals(id)).findFirst().get();
    }
    public void addProfessor(Professor p) {
        if(p.getId() == null){
            p.setId(professors.get(professors.size()-1).getId() + 1);
        }
        professors.add(p);
    }
    public void deleteProfessor(Long id) {
        professors.removeIf(professor -> professor.getId().equals(id));
    }
}
