package com.uniovi.sdi2223308spring.services;

import com.uniovi.sdi2223308spring.entities.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {
    private List<Professor> professors = new ArrayList<>();

    public ProfessorsService() {
        professors.add(new Professor(1L, "DNI1", "Paco", "Fernandez", "Ciencias"));
        professors.add(new Professor(2L, "DNI2", "Pedro", "Lopez", "Letras"));
        professors.add(new Professor(3L, "DNI3", "Maria", "Lopez", "Economia"));
        professors.add(new Professor(4L, "DNI4", "Pablo", "Hernandez", "Ciencias"));
    }

    public List<Professor> getProfessors() {
        return professors;
    }
    public Professor getProffesor(Long id) {
        for (Professor p : professors) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public void addProfessor(Professor p) {
        professors.add(p);
    }
    public void deleteProfessor(Long id) {
        for (Professor p : professors) {
            if (p.getId() == id) {
                professors.remove(p);
            }
        }
    }
}
