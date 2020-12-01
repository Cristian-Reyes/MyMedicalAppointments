package model;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;

/**
 * patient Model
 * @author Cristian Reyes
 * @version 1
 * */



public class Patient extends User
{
        //Atributos
        private String birthday;
        private double weight;
        private double height;
        private String blood;
        private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
        private  ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

        //Constructor

        public Patient(String name, String email)
        {
            super(name,email); //Herencia de model.User
        }


        //Metodos abstractos heredados
        @Override
        public void showDataUser()
        {
            System.out.println("Paciente");
            System.out.println("Pertenece al hospital dede: 1999/03/26");

        }


        //Getters & Setters


        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getWeight(){
            return this.weight + " Kg.";
        }

        public String getHeight() {
            return height + " Mts.";
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getBlood() {
            return blood;
        }

        public void setBlood(String blood) {
            this.blood = blood;
        }

        public ArrayList<AppointmentDoctor> getAppointmentDoctors() { return appointmentDoctors; }

        public void addAppointmentDoctors(Doctor doctor, Date date, String time)
        {
            AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this,doctor);
            appointmentDoctor.schedule(date,time);
            appointmentDoctors.add(appointmentDoctor);
        }

        public ArrayList<AppointmentNurse> getAppointmentNurses() { return appointmentNurses; }

        public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) { this.appointmentNurses = appointmentNurses; }


    //Metodos

        //Metodo sobre escrito
        @Override
        public String toString()
        {
            return super.toString() + "\nAge: " + birthday + "\nWeight: " +
                    weight + "\nHeight: " + height + "\nBlood:" + blood;
        }
}
