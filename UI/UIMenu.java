package UI;

import model.Doctor;
import model.Patient;

import javax.print.Doc;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu
{

    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
   public static void showMenu()
    {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    response = 0;
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");

                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    // Metodo autenticador de usuarios
    private static void authUser(int userType)
    {
       // userType = 1 -> Doctor
        //userType = 2 -> Patient

        //Lista de doctores
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martines", "alejandro@mail.com"));
        doctors.add(new Doctor("karen Sosa", "karen@mail.com"));
        doctors.add(new Doctor("Rocío Gómez", "rocio@mail.com"));

        //Lista de pacientes
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Cristian Reyes", "cristian@mail.com"));
        patients.add(new Patient("Norberto Reyes", "norberto@mail.com"));
        patients.add(new Patient("Juan Reyes", "juan@mail.com"));


        boolean emailCorrect = false;
        do{
            System.out.println("Insert your email: [a@a.com");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if(userType == 1)
            {
                for (Doctor d: doctors)
                {
                    if (d.getEmail().equals(email))
                    {
                        emailCorrect = true;
                        //Obtener el usuario logueado
                        doctorLogged = d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            else if (userType == 2)
            {
                for (Patient p: patients)
                {
                    if (p.getEmail().equals(email))
                    {
                        emailCorrect = true;
                        //Obtener el usuario logueado
                        patientLogged = p;
                        UIPatientMenu.showPatientMenu();
                    }
                }

            }

        }while (!emailCorrect);

    }

    public static void showPatientMenu()
    {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response)
            {
                case 1:
                    int y = 0;
                    for (int i = 0; i < 3; i++)
                    {
                        y = y+1;
                        System.out.println(y + ". "+ MONTHS[i]);

                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
}
