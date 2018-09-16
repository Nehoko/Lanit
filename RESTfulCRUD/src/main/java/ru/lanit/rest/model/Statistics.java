package ru.lanit.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="statistics")
public class Statistics implements Serializable {

    @Id
    private static final long id = 1L;

    @Column(name="person_count")
    @NotNull
    private static Long personcount;

    @Column(name="car_count")
    @NotNull
    private static Long carcount;

    @Column(name="unique_vendor_count")
    @NotNull
    private static Long uniquevendorcount;

    public static void incrementPersoncount(){
        if (personcount!=0)
        personcount++;
        else {
            personcount = 1L;
        }
    }

    public static void incrementCarcount(){
        if (carcount!=0)
        carcount++;
        else{
            carcount = 1L;
        }
    }

    public static void incrementUniquevendorcount(){
        if (carcount!=0)
        uniquevendorcount++;
        else{
            uniquevendorcount = 1L;
        }
    }

    public static void decrementPersoncount() throws Exception {
        if (personcount!=0)
            personcount--;
        else {
            throw new Exception("Person count cannot be less than 0");
        }
    }

    public static void decrementCarcount() throws Exception {
        if (carcount!=0)
            carcount--;
        else{
            throw new Exception("Car count cannot be less than 0");
        }
    }

    public static void decrementUniquevendorcount() throws Exception {
        if (carcount!=0)
            uniquevendorcount--;
        else{
            throw new Exception("Vendor count cannot be less than 0");
        }
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
    public String toString() {
        return "Statistics{}";
    }
}
