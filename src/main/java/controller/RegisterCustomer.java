package controller;

import model.Customer;
import database.DAOCustomer;
import model.Address;
import valitadors.ValidateFactory;
import valitadors.ValidateZipCode;
import view.ColorFactory;
import view.ItemMenuFactory;

import java.util.Scanner;

public class RegisterCustomer {


    DAOCustomer daoCustomer = new DAOCustomer();
    Customer customer = new Customer();
    Address address = new Address();

    ValidateFactory validateFactory = new ValidateFactory();
    ColorFactory colorFactory = new ColorFactory();
    ItemMenuFactory itemMenuFactory = new ItemMenuFactory();



    public void registerNewCustomer() {

        itemMenuFactory.facadeRegisterCustomer();

        registerCustomerNameInput("");

        registerCustomerCpfInput("");

        registerCustomerEmailInput("");

        registerCustomerTelephoneInput("");

        registerCustomerAddressZipInput("");

        registerCustomerAddressStateInput("");

        registerCustomerAddressCityInput("");

        registerCustomerAddressStreetInput("");

        registerCustomerAddressNumberInput("");

        customer.setAddress(address);

        daoCustomer.save(customer);

    }

    private void errorTest(String error){
        if (error != "")
            System.out.println(colorFactory.ANSI_RED + error + colorFactory.ANSI_RESET);

        System.out.print(colorFactory.ANSI_WHITE_BACKGROUND + colorFactory.ANSI_BLACK);
    }


    public String registerCustomerName(String name){
        if (validateFactory.validateName.isValid(name)) {
            customer.setName(name);
            return customer.getName();
        }
        return "error";
    }

    public void registerCustomerNameInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the name:      ");
        String name;
        name = input.nextLine();
        registerCustomerName(name);

        if (registerCustomerName(name) == "error")
            registerCustomerNameInput("Name isn't valid, try again: ");

    }


    public String registerCustomerCpf(String cpf){
        if (validateFactory.validateCPF.isValid(cpf)) {
            customer.setCpf(cpf);
            return customer.getCpf();
        }
        return "error";
    }

    public void registerCustomerCpfInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the cpf:       ");
        String cpf;
        cpf = input.nextLine();
        registerCustomerCpf(cpf);

        if (registerCustomerCpf(cpf) == "error")
            registerCustomerCpfInput("Cpf isn't valid, try again: ");

    }

    public String registerCustomerEmail(String email) {
       if (validateFactory.validateEmail.isValid(email)) {
           customer.setEmail(email);
           return customer.getEmail();
       }
        return "error";
    }

    public void registerCustomerEmailInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the email:     ");
        String email;
        email = input.nextLine();
        registerCustomerEmail(email);


        if ( registerCustomerEmail(email) == "error")
            registerCustomerEmailInput("Email isn't valid, try again: ");

    }

    public String registerCustomerTelephone(String telephone){
        if(validateFactory.validatePhone.isValid(telephone)) {
            customer.setTelephone(telephone);
            return customer.getTelephone();
        }
        return "error";
    }

    public void registerCustomerTelephoneInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the telephone: ");
        String telephone;
        telephone = input.nextLine();
        registerCustomerTelephone(telephone);

        if (registerCustomerTelephone(telephone) == "error")
            registerCustomerTelephoneInput("Telephone isn't valid, try again: (Telephone example (51) 98573-7770) ");

    }

    public String registerCustomerAddressZip(String zip) {
        if (validateFactory.validateZipCode.isValid(zip)) {
            address.setZip(zip);
            return address.getZip();
        }
        return "error";
    }

    public void registerCustomerAddressZipInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the zip code:  ");
        String zipCode;
        zipCode = input.nextLine();
        registerCustomerAddressZip(zipCode);

        if (registerCustomerAddressZip(zipCode) == "error")
            registerCustomerAddressZipInput("Zip code isn't valid, try again: (Zip code example 92325-299)");
    }

    public String registerCustomerAddressState(String state){
        Scanner input = new Scanner(System.in);
        if (validateFactory.validateName.isValid(state)) {
            address.setState(state);
            return address.getState();
        }
        return "error";
    }

    public void registerCustomerAddressStateInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the State:     ");
        String state;
        state = input.nextLine();
        registerCustomerAddressState(state);

        if (registerCustomerAddressState(state) == "error")
            registerCustomerAddressStateInput("State isn't valid, try again: ");

    }

    public String registerCustomerAddressCity(String city){
        if (validateFactory.validateName.isValid(city)) {
            address.setCity(city);
            return address.getCity();
        }
        return "error";
    }

    public void registerCustomerAddressCityInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the City:      ");
        String city;
        city = input.nextLine();
        registerCustomerAddressCity(city);

        if (registerCustomerAddressCity(city) == "error")
            registerCustomerAddressCityInput("State isn't valid, try again: ");

    }

    public String registerCustomerAddressStreet(String street){
        if (validateFactory.validateName.isValid(street)) {
            address.setStreet(street);
            return address.getStreet();
        }
        return "error";
    }

    public void registerCustomerAddressStreetInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the street:    ");
        String street;
        street = input.nextLine();
        registerCustomerAddressStreet(street);

        if (registerCustomerAddressStreet(street) == "error")
            registerCustomerAddressStreetInput("Street isn't valid, try again: ");

    }


    public int registerCustomerAddressNumber(Integer number){
        if (validateFactory.validateAddressNumber.isValid(number)) {
            address.setNumber(number);
            return address.getNumber();
        }
        return 0;
    }

    public void registerCustomerAddressNumberInput(String error){
        Scanner input = new Scanner(System.in);
        errorTest(error);

        System.out.print("Enter the number:    ");
        int addressNumber = input.nextInt();
        registerCustomerAddressNumber(addressNumber);

        System.out.print(colorFactory.ANSI_RESET);

        if (registerCustomerAddressNumber(addressNumber) == 0)
            registerCustomerAddressNumberInput("Number isn't valid, try again: ");
    }


    public void findCustomer() {
        Scanner input = new Scanner(System.in);
        itemMenuFactory.facadeFindCustomer();

        System.out.print(colorFactory.ANSI_WHITE_BACKGROUND + colorFactory.ANSI_BLACK);

        System.out.print("Enter the cpf for find database: ");
        System.out.print(colorFactory.ANSI_RESET);

        daoCustomer.find(input.next());

    }

    public void removeCustomer() {
        Scanner input = new Scanner(System.in);
        itemMenuFactory.facadeDeleteCustomer();

        System.out.print(colorFactory.ANSI_WHITE_BACKGROUND + colorFactory.ANSI_BLACK);

        System.out.print("Enter the cpf for DELETE database: ");
        System.out.print(colorFactory.ANSI_RESET);


        daoCustomer.remove(input.next());

    }

}
