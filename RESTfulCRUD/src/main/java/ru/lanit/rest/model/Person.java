package ru.lanit.rest.model;


import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

@Entity
@Table(name="person")
public class Person implements Serializable {

    @Id
    @NotNull
    private Long id;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="birthdate")
    @NotNull
    private String birthdate;

    @JsonBackReference
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Car> cars;



    public Person(){}

    public Person(Long id, String name, String birthdate){
        setId(id);
        setName(name);
        try {
            setBirthdate(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Person(Long id){
        setId(id);
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

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

    public void setBirthdate(String birthdate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.parse(birthdate);
        this.birthdate = birthdate;
    }

    public Set<Car> getCars() {
        return cars;
    }

}
