package ru.lanit.rest.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="birthdate")
    @NotNull
    private String birthdate;

    @JoinColumn(name = "car_id")
    @OneToMany(targetEntity = Car.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Car> cars;

    public Person(){}

    public Person(Long id, String name, String birthdate){
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
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

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }


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
