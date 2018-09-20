package ru.lanit.rest.dto;

import java.util.Set;

public class PersonDTO {
    private Long id;
    private String name;
    private String birthdate;
    private Set<CarDTO> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Set<CarDTO> getCars() {
        return cars;
    }

    public void setCars(Set<CarDTO> cars) {
        this.cars = cars;
    }
}
