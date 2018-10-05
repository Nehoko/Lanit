package ru.lanit.rest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="statistics")
public class Statistics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 1L;

    @Column(name="person_count")
    @NotNull
    private Long personcount;

    @Column(name="car_count")
    @NotNull
    private Long carcount;

    @Column(name="unique_vendor_count")
    @NotNull
    private Long uniquevendorcount;

    public void incrementPersoncount(){
        if (personcount!=0)
        personcount++;
        else {
            personcount = 1L;
        }
    }

    public  void incrementCarcount(){
        if (carcount!=0)
        carcount++;
        else{
            carcount = 1L;
        }
    }

    public  void incrementUniquevendorcount(){
        if (carcount!=0)
        uniquevendorcount++;
        else{
            uniquevendorcount = 1L;
        }
    }

    public  void decrementPersoncount() throws Exception {
        if (personcount!=0)
            personcount--;
        else {
            throw new Exception("Person count cannot be less than 0");
        }
    }

    public  void decrementCarcount() throws Exception {
        if (carcount!=0)
            carcount--;
        else{
            throw new Exception("Car count cannot be less than 0");
        }
    }

    public  void decrementUniquevendorcount() throws Exception {
        if (carcount!=0)
            uniquevendorcount--;
        else{
            throw new Exception("Vendor count cannot be less than 0");
        }
    }


    public void setPersoncount(Long personcount) {
        this.personcount = personcount;
    }

    public void setCarcount(Long carcount) {
        this.carcount = carcount;
    }

    public void setUniquevendorcount(Long uniquevendorcount) {
        this.uniquevendorcount = uniquevendorcount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPersoncount() {
        return personcount;
    }

    public Long getCarcount() {
        return carcount;
    }

    public Long getUniquevendorcount() {
        return uniquevendorcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return id == that.id &&
                Objects.equals(personcount, that.personcount) &&
                Objects.equals(carcount, that.carcount) &&
                Objects.equals(uniquevendorcount, that.uniquevendorcount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personcount, carcount, uniquevendorcount);
    }

    @Override
    public String toString() {
        return "{" +
                "personcount=" + personcount +
                ", carcount=" + carcount +
                ", uniquevendorcount=" + uniquevendorcount +
                '}';
    }
}
