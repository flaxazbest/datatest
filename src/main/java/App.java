import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class App extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "mina.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("DataBase");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /*public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver load");

            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "root"
            );
            System.out.println("Connection create");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
            "SELECT t.* FROM public.\"User\" t WHERE town = 2 AND name LIKE \'S6\'"
            );

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " +
                resultSet.getString(2) + " " +
                resultSet.getInt(3));
            }

            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/



}
