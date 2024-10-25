package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int Postcode;
        int MaandInkomen = 0;
        String Partner;
        int Studieschuld = 0;
        int Renteprecentage = 0;

        Scanner scanner = new Scanner(System.in);

        // First while loop for MaandInkomen input
        while (true) {
            System.out.print("Vul je maand inkomen in: ");
            try {
                MaandInkomen = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Ongeldige invoer. Voer alstublieft een geldig geheel getal in.");
                scanner.next();  // Clear the invalid input
            }
        }

        // Second while loop for Studieschuld input
        while (true) {
            System.out.print("Vul je Studieschuld in: ");
            try {
                Studieschuld = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Ongeldige invoer. Voer alstublieft een geldig geheel getal in.");
                scanner.next();  // Clear the invalid input
            }
        }

        // Third while loop for Postcode input
        while (true) {
            System.out.print("Vul je postcode in: ");
            Postcode = scanner.nextInt();
            if (Postcode == 9679 || Postcode == 9681 || Postcode == 9682) {
                System.out.println("Postcode slecht.");
            } else {
                break;
            }
        }

        // Fourth while loop for Renteprecentage input
        while (true) {
            System.out.print("Vul je renteprecentage in: ");
            Renteprecentage = scanner.nextInt();
            if (Renteprecentage == 1 || Renteprecentage == 5 || Renteprecentage == 10 || Renteprecentage == 20 || Renteprecentage == 30) {
                System.out.println("niet geaccepteerd");
                break;
            } else {
                System.out.println("kan nie.");
            }
        }

        // Fifth while loop for Partner input
        scanner.nextLine(); // Clear buffer before reading String input
        while (true) {
            System.out.print("Partner? ");
            Partner = scanner.nextLine().toLowerCase();
            if (Partner.equals("ja") || Partner.equals("nee")) {
                break;
            } else {
                System.out.println("Ongeldige invoer. Voer alstublieft 'ja' of 'nee' in.");
            }
        }

        // Displaying user inputs
        System.out.println("je maandinkomen: " + MaandInkomen);
        System.out.println("je studieschuld: " + Studieschuld);
        System.out.println("je postcode: " + Postcode);
        System.out.println("heb je een partner: " + Partner);

        // Reken partners yearlyincome x2
        double yearlincome = MaandInkomen * 12;
        if (Partner.equals("ja")) {
            yearlincome *= 2;
        }

        // Bereken en laat de resultaten zien
        double maxLoan = Caculator.caculatemaxloan(yearlincome, Studieschuld);
        double monthlyInterest = Caculator.caculatemonthlinterest(maxLoan, Renteprecentage);
        double monthlyRepayment = Caculator.caculatemonthlyrepayment(maxLoan);

        System.out.println("Maximaal lenen: " + maxLoan);
        System.out.println("Maandelijkse intrest: " + monthlyInterest);
        System.out.println("Maandelijkse betaling: " + monthlyRepayment);
    }
}
