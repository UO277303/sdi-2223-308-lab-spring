package com.uniovi.sdi2223308spring.validators;

import com.uniovi.sdi2223308spring.entities.Mark;
import com.uniovi.sdi2223308spring.entities.Professor;
import com.uniovi.sdi2223308spring.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProfessorsValidator implements Validator {
    @Autowired
    public ProfessorsService professorsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Professor.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        if (professor.getDni().length() != 9) {
            errors.rejectValue("dni", "Error.professor.dni.length");
        }
        if (Character.isDigit(professor.getDni().charAt(professor.getDni().length() -1))) {
            errors.rejectValue("dni", "Error.professor.dni.letter");
        }
        if (professorsService.getProfessorByDni(professor.getDni()) != null) {
            errors.rejectValue("dni", "Error.professor.dni.duplicated");
        }
    }
}
