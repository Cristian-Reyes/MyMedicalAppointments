package UI;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class UIPatientMenu
{
    public static void showPatientMenu()
    {

        int response = 0;
        do {

            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    response = 0;
                    break;
                case 2:
                    showPatientMyAppointment();
                    response = 0;
                    break;
                case 0:
                    UIMenu.showMenu();
                    response = 0;
                    break;
            }


        }while (response!=0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println(":: Select date: ");
            //Numeración de la listas de fecha (Integer)
            //Indice de la fecha seleccionada (integer segundo map)
            Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;

            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointment.size(); i++)
            {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointment.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++)
                {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointment.get(i));
                    doctors.put(k, doctorAppointment);
                }

            }

            //Se selecciona la fecha
            Scanner sc = new Scanner(System.in);
            int responseSelected = Integer.valueOf(sc.nextLine());

            //Se buscan los datos del doctor de la fecha seleccionada
            Map<Integer,Doctor> doctorAvailableSelected = doctors.get(responseSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            //Se encuentran los datos del doctor
            for (Map.Entry<Integer,Doctor> doc:doctorAvailableSelected.entrySet())
            {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName()
                    + ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate()
                    + ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. YES \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());


            if(response == 1)
            {
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }




        }while (response!= 0);
    }

    private static void showPatientMyAppointment()
    {
        int response = 0;
        do {
            System.out.println(":: My Appointment");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0)
            {
                System.out.println("Don't have appointment");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++)
            {
                int j = i+1;
                System.out.println(j + ". "
                        + "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate()
                        + "Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime()
                        + "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
                
            }

            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if(response == 0)
            {
                showPatientMenu();
            }
        }while (response != 0);
    }
}
