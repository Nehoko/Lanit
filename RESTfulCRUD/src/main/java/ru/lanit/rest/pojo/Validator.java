package ru.lanit.rest.pojo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {

    public static boolean isDateValid(final String date) {
        Date currentDate = new Date();
        String formatString = "dd.MM.yyyy";
        boolean isFormatValid;
        Date dateObj;
        try {
            SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateInstance();
            sdf.applyPattern(formatString);
            sdf.setLenient(false);
            dateObj = sdf.parse(date);
            if (date.equals(sdf.format(dateObj)) && dateObj.compareTo(currentDate)<0) {
                isFormatValid = true;
            }
            else {
                isFormatValid = false;
            }
        } catch (ParseException e) {
            isFormatValid = false;
        }
        return isFormatValid;
    }

    public static boolean isLong(String id){

        try{
            Long.parseLong(id);
            return true;
        }
        catch (NumberFormatException | NullPointerException e){
            return false;
        }
    }

    public static boolean isHorsePowerValid(String horsepower){

        try{
            int power = Integer.parseInt(horsepower);
            if (power>0)
                return true;
            else{
                return false;
            }
        }
        catch (NumberFormatException | NullPointerException e){
            return false;
        }
    }
}
