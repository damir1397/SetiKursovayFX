package sample;

import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Smtp {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textAreaOutputCommand;

    @FXML
    private TextField mailFrom;

    @FXML
    private TextField rcptTo;

    @FXML
    private TextField zagolovName;

    @FXML
    private TextField zagolovEmail;

    @FXML
    private TextArea textAreaMessage;

    @FXML
    private Button quitSMTP;

    public static String email;
    public static String nameMessage;
    public static String messageTextArea;
    public static String  sizeMessage;
    public static String rsptTOmessgae;
    public static Integer  sizeM;
    @FXML
    void initialize() {
        quitSMTP.setOnAction(event -> {
// email acount
            email=mailFrom.getText();
            if (email!=null){
                textAreaOutputCommand.appendText("250 "+email+ " sender accepted\n");
            }
//email sender
            rsptTOmessgae=rcptTo.getText();
            if (rsptTOmessgae.equals("damir1397")){
                textAreaOutputCommand.appendText("250 "+rsptTOmessgae+" ok\n");
            }else {textAreaOutputCommand.appendText("550 "+ rsptTOmessgae+ " unknown user account\n");}

            messageTextArea=textAreaMessage.getText();

            nameMessage=zagolovName.getText();

            sizeMessage=textAreaMessage.getText();
            sizeM= sizeMessage.length()*4;




        });

    }
}
