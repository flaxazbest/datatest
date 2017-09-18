import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.jws.soap.SOAPBinding;
import java.nio.Buffer;
import java.sql.*;
import java.util.LinkedList;

public class Controller {

    private Connection connection = null;
    private ObservableList<User> users = FXCollections.observableArrayList();



    @FXML
    TableView<User> table;

    @FXML
    TableColumn<User, Integer> idColumn;

    @FXML
    TableColumn<User, String> nameColumn;

    @FXML
    TextField userName;

    @FXML
    PasswordField userPwd;

    @FXML
    Button buttonConnect;

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("userId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        table.setItems(users);
    }
    @FXML
    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver load");

        try {
            String userN;
            if (userName.getText().isEmpty() || userName.getText() == null)
                userN = "postgres";
            else
                userN = userName.getText();

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    userN,
                    userPwd.getText()
            );
            System.out.println("Connection create");
        } catch (SQLException e) {
            System.out.println("Invalid username or password");
        }

    }

    @FXML
    public void show() {
        if (connection != null) {

            Statement statement = null;
            try {
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(
                        "SELECT t.* FROM public.\"User\" t"
                );

                //LinkedList<User> list = new LinkedList<User>()

                while (resultSet.next()) {
                    users.add(new User(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3)
                    ));
                }

                //table.getSelectionModel().;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
