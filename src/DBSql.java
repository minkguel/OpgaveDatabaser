import java.sql.*;

public class DBSql {
    private Connection connection;
    private Statement stmt;
    private Statement stmt1;

    DBSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://Users//mikke//DBbrowserDATABASE//StudieAdminDatabase.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void alleStuderende() {
        try {
            String sql = "select * from studerende";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("stdnr"));
                System.out.println(rs.getString("fnavn"));
                System.out.println(rs.getString("enavn"));
                System.out.println(rs.getString("adr"));
                System.out.println(rs.getInt("postnr"));
                System.out.println(rs.getInt("mobil"));
                System.out.println(rs.getString("klasse"));
            }
            stmt.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void alleFag() {
        try {
            String sql = "select * from Fag";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("fagid"));
                System.out.println(rs.getString("fagnavn"));

            }
            stmt.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretStuderende(Studerende s) {
        try {
            // String sql = "INSERT INTO studerende(stdnr,fnavn,enavn,adr,postnr,mobil,klasse)";

            //ql+= "VALUES("+String.valueOf(s.getStdNr())+",'"+s.getfNavn()+"´,´"+s.geteNavn()+"','"+s.getAdresse()+"´,´"+s.getAdresse()+"´,´"+s.getMobil()+"´,´"+s.getKlasse()+"')";
            String sql = "INSERT INTO studerende(stdnr,fnavn,enavn,adr,postnr,klasse,mobil)";
            sql += "VALUES(" + String.valueOf(s.getStdNr()) + ",'" + s.getfNavn() + "','" + s.geteNavn() + "','" + s.getAdresse() + "','" + s.getPostNr() + "','" + s.getKlasse() + "','" + s.getMobil() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretFag(Fag f) {
        try {
            String sql = "INSERT INTO fag(fagid,fagnavn)";
            sql += "VALUES(" + String.valueOf(f.getFagid()) + ",'" + f.getFagnavn() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void tilmeldStuderendeFag(int id, Studerende s, Fag f, String kar) {
        try {
            String sql = "INSERT INTO studfag(id,stdnr,fagid,kar)";
            sql += "VALUES(" + String.valueOf(id) + ",'" + String.valueOf(s.getStdNr()) + "','" + String.valueOf(f.getFagid()) + "','" + kar + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void frameldFag(int id) {
        try {
            String sql = "DELETE FROM studfag WHERE id = " + String.valueOf(id);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void soegStud(int stdNr) {
        try {
            //String sql = "SELECT * FROM studerende WHERE stdnr = " + String.valueOf(stdNr);
            String sql = "SELECT * FROM studerende s JOIN studfag sf ON s.stdnr = sf.stdnr WHERE sf.stdnr = " + String.valueOf(stdNr);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            System.out.println("Student ID: " + rs.getInt("stdnr"));
            System.out.println("First Name: " + rs.getString("fnavn"));
            System.out.println("Last Name: " + rs.getString("enavn"));
            System.out.println("Address: " + rs.getString("adr"));
            System.out.println("Postal Code: " + rs.getInt("postnr"));
            System.out.println("Mobile: " + rs.getInt("mobil"));
            System.out.println("Class: " + rs.getString("klasse"));
            while (rs.next()) {
                System.out.println("Fag: " + rs.getString("fagid") + " Karakter: " + rs.getString("kar"));
            }
            System.out.println();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void soegFag(int fagNr) {
        try {
            //String sql = "SELECT * FROM Fag f JOIN studfag sf ON f.fagid = sf.stdnr WHERE sf.stdnr = " + String.valueOf(fagNr);
            String sql = "SELECT * FROM Fag f JOIN studfag sf ON f.fagid = sf.fagid WHERE sf.fagid = " + fagNr;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            System.out.println("Fag ID: " + rs.getInt("fagid"));
            System.out.println("Fag navn: " + rs.getString("fagnavn"));
            while (rs.next()) {
                System.out.println("studerende: " + rs.getString("stdnr"));
            }
            System.out.println();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    }

