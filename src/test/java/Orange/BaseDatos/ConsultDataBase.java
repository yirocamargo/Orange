package Orange.BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultDataBase {

    private ConnectionBd connectionBd;

    public ConsultDataBase() {
        this.connectionBd = new ConnectionBd();
    }

    public static void consultUsers() throws SQLException {
        Connection pruebasCon = ConnectionBd.getConnection();
        if (pruebasCon != null) {
            System.out.println("conecto");
            Statement stm = pruebasCon.createStatement();
            ResultSet rst = stm.executeQuery("Select name,lastName from newEmployee");
            while (rst.next()) {
                System.out.println("employee: " + rst.getString(1)+ rst.getString(2));
            }
        } else {
            System.out.println("NO conecto");
        }
    }
}
