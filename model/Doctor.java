package model;

import model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * model.Doctor Model
 * @author Cristian Reyes
 * @version 1
 * */

public class Doctor extends User
{

    //Atributos
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    //Controlador
    public Doctor(String name, String email)
    {
        super(name,email);


    }

    //Metodos abstractos heredados
    @Override
    public void showDataUser()
    {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerologia");

    }

    //Getters & Setters

    public String getSpeciality() { return speciality; }

    public void setSpeciality(String speciality) { this.speciality = speciality; }

    //Metodos
    public void addAvailableAppointment(String date, String time)
    {

        availableAppointments.add(new AvailableAppointment(date, time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments()
    {
        return availableAppointments;
    }



    //Metodos Sobre escritos
    @Override
    public String toString()
    {
        return super.toString() +
                "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    //Clases anidadas
    public static class AvailableAppointment
    {
        //Atributos
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //Constructor
        public AvailableAppointment(String date, String time)
        {

            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        //Getters & Setters


        public int getId() {return id;}

        public void setId(int id) {this.id = id;}

        public Date getDate(String DATE) {return date;}
        public String getDate()
        {
            return format.format(date);
        }

        public void setDate(Date date) {this.date = date;}

        public String getTime() {return time;}

        public void setTime(String time) {this.time = time;}


        //Metodos sobreescritos

        @Override
        public String toString() {
            return "Available Appointments \nDate: " + date + "\nTime: " + time;
        }
    }




}
