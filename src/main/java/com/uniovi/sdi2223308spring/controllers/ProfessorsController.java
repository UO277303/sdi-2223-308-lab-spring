package com.uniovi.sdi2223308spring.controllers;

import com.uniovi.sdi2223308spring.entities.Professor;
import com.uniovi.sdi2223308spring.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;

    @RequestMapping("/professor/list")
    public String getList() {
        String result = "";
        for (Professor p : professorsService.getProfessors()) {
            result += p.toString() + "\n";
        }
        return result;
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String addProfessor(@ModelAttribute Professor p) {
        professorsService.addProfessor(p);
        return "Añadido " + p.toString();
    }
    @RequestMapping("/professor/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return professorsService.getProffesor(id).toString();
    }
    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        String msg = "Eliminado " + professorsService.getProffesor(id).toString();
        professorsService.deleteProfessor(id);
        return msg;
    }

}