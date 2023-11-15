import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;
import java.io.File.*;


public class Main {

    public static void main(String [] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        DBSql db = new DBSql();
        Studerende s = new Studerende(12,"Jens", "Petersen", "Pedersvej 10", "4700", "51923023","A");
        Fag f = new Fag(6, "Huggosprog");
        //db.alleStuderende();
        //db.alleFag();
        System.out.println("1. Opret studerende: ");
        System.out.println("2. Opret fag");
        System.out.println("3. Tilmeld studerende til fag");
        System.out.println("4. Frameld studerende til fag");
        System.out.println("5. Udskriv alle studerende");
        System.out.println("6. Udskriv alle fag");
        System.out.println("7. Søg oplysninger om studerende");
        System.out.println("8. Søg oplysninger om et fag");
        System.out.println("Indtast valg:");
        int valg = scan.nextInt();
        switch (valg) {
            case 1:
                System.out.println("Oplys studienummer, fornavn, efternavn, adresse, postnummer, mobil og klasse");
                db.opretStuderende(s);
            break;

            case 2:
                System.out.println("Oplys fagnummer og fag navn");
                db.opretFag(f);
            break;

            case 3:
                System.out.println("Oplys id, studerende, fag og karakter");
                db.tilmeldStuderendeFag(13, s, f, "10");
            break;

            case 4:
                System.out.println("Oplys id: ");
                db.frameldFag(13);
            break;

            case 5:
                db.alleStuderende();
            break;

            case 6:
                db.alleFag();
            break;

            case 7:
                System.out.println("Oplys studienummer");
                db.soegStud(scan.nextInt());

            break;

            case 8:
                System.out.println("Oplys fagnummer");
                db.soegFag(scan.nextInt());
            break;
            }

    }
}
