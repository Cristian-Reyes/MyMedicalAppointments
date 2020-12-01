package model;

/**
 * model.User Model
 * @author Cristian Reyes
 * @version 1
 * */

public abstract class User
{
    //Atributos
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    //Constructor
    public User(String name, String email)
    {
        this.name = name;
        this.email = email;
    }


    //Getters & Setters
    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email; }

    public void setEmail(String email) {this.email = email;}

    public String getAddress() {return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber)
    {
        if (phoneNumber.length() > 8)
        {
            System.out.println("El número telefónico debe ser de 8 dígitos máximo");
        }
        else if(phoneNumber.length() == 8)
        {
            this.phoneNumber = phoneNumber;
        }
    }


    //Metodos abstractos

    public abstract void showDataUser();


    //Metodos sobre escritos
    @Override
    public String toString()
    {
        return "model.User: " + name + ", Email: " + email +
                "\nAddreess: " + address + ". Phone: " + phoneNumber;
    }
}
