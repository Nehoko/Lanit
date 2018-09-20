package ru.lanit.rest.model;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
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
    //    public void setCars(Set<Car> cars) {
//        this.cars = cars;
//    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(birthdate, person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthdate);
    }
}
