package com.uniovi.sdi2223308spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Professor {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String name;
    private String surname;
    private String category;

    public Professor() { }
    public Professor(Long id, String dni, String name, String surname, String category) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Professor{id=" + id + ",dni=" + dni + ",name=" + name + ",surname=" + surname
                + ",category=" + category + "}";
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDni() { return dni; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getCategory() { return category; }
}
