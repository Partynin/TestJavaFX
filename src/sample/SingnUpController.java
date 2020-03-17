package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SingnUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginFild;

    @FXML
    private PasswordField passwordFild;

    @FXML
    private Button signInButton;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    private CheckBox singUPCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private TextField sighUpState;

    @FXML
    void initialize() {
        signInButton.setOnAction(e -> {
            signUPNewUser();
        });
    }

    private void signUPNewUser() {
        DatabaseHandler dbHaneler = new DatabaseHandler();

        String lastName = signUpLastName.getText();
        String firstName = signUpName.getText();
        String login = loginFild.getText();
        String password = passwordFild.getText();
        String state = sighUpState.getText();
        String gender = "";

        if (singUPCheckBoxMale.isSelected())
            gender = "Male";
        else gender = "Female";

        User user = new User(lastName, firstName, login, password, state, gender);

        dbHaneler.signUpUser(user);
    }
}
