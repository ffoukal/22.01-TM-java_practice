package core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar date;

    public Fecha(){
        this.date = new GregorianCalendar(); // current time in the default time zone with the default locale
        this.date.setLenient(false);
    }

    public Fecha(int dia, int mes, int anio){
        this.date = new GregorianCalendar();
        this.date.setLenient(false);
        this.date.set(anio, mes-1, dia);
    }


    public boolean isValid(){
        try {
            System.out.println("La fecha ingresada es correcta ");
            return true;
        } catch (Exception ex){
            System.out.println("La fecha ingresada no es válida");
            return false;
        }
    }

    public boolean isValid(boolean printResult){
        if(!printResult){
            try {
                return true;
            } catch (Exception ex){
                return false;
            }
        } else {
            return this.isValid();
        }
    }

    public void addDay(){
        if(!this.isValid(false)) throw new RuntimeException("La fecha ingresada no es válida");
        this.date.add(Calendar.DAY_OF_YEAR, 1);
    }

    @Override
    public String toString(){
        if(!this.isValid(false)) throw new RuntimeException("La fecha ingresada no es válida");
        return new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
    }







}
