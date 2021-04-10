package org.nerdcore.PatientIntake;

import java.util.Scanner;

public class ClinicMain {

    private static ClinicCalendar calendar;

    public static void main(String[] args) throws Throwable {
        calendar = new ClinicCalendar();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Patient Intake Computer System\n\n");
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            lastOption = displayMenu(scanner);
        }
    }

    private static String displayMenu(Scanner scanner) throws Throwable {
        System.out.println("Please select an option:");
        System.out.println("1. Enter a Patient Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("X. Exit System.");
        System.out.print("Option:");
        String option = scanner.next();
        switch (option) {
            case "1":
                performPatientEntry(scanner);
                return option;
            case "2":
                performAllPatients();
                return option;
            default:
                System.out.println("Invalid Option, please re-enter");
                return option;
        }
    }

    private static void performPatientEntry(Scanner scanner) {
        scanner.nextLine();
        System.out.println("\n\nPlease enter Appointment Info");
        System.out.print("  Patient Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("  Patient First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("  Appointment Date (M/d/yyyy h:mm a):");
        String when = scanner.nextLine();
        System.out.print("  Doctor Last Name: ");
        String doc = scanner.nextLine();
        try {
            calendar.addAppointment(firstName, lastName, doc, when);
        } catch (Throwable t){
            System.out.println("Error! " + t.getMessage());
            return;
        }
        System.out.println("Patient entered successfully.\n\n");


    }

    private static void performAllPatients() {
        System.out.println("All appointments in system:");
        for(PatientAppointment p : calendar.getAppointments()){
            System.out.printf("%s: %s, %s    Doctor: %s%n", p.getAppointmentDateTime().toString(),p.getPatientLastName(),p.getPatientFirstName(),p.getDoctor().getName());
        }
    }
}
