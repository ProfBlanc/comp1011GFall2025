
package database;
import java.sql.*;
import java.sql.Connection;

public class TestDB {

    public static void main(String[] args) {




        try {

            Connection connection =
                     DriverManager.getConnection(
                            "jdbc:mysql://172.31.22.43:3306/Benbblanc_previewuser",
                            "Benbblanc_previewuser", "your-password"
                    );
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Camera (Model, Make, Color) " +
                    "VALUES (?,?,?) ");

            preparedStatement.setString(1, "Cool");
            preparedStatement.setString(2, "Beans");
            preparedStatement.setString(3, "Hungry");

            preparedStatement.execute();

            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("select * from Camera");


            while (resultSet.next()){

                int id = resultSet.getInt("ID");
                String model = resultSet.getString("MODEL");
                String make = resultSet.getString(2);
                String color = resultSet.getString(4);

                //
                System.out.println(id);
                System.out.println(model);
                System.out.println(make);
                System.out.println(color);
                System.out.println("*".repeat(20));
            }

        }
        catch (Exception e){
            System.err.println(e);
        }




    }
}
