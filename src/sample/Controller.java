package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static java.lang.Integer.parseInt;


public class Controller extends ServerM{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logPass;

    @FXML
    private Button smtp;

    @FXML
    private Button post;

    @FXML
    private Button quit;

    @FXML
    private TextField user;

    @FXML
    private TextField pass;

    @FXML
    private TextField delet;

    @FXML
    private TextArea textArea;

    @FXML
    private Button list;

    @FXML
    private TextField retr;

    @FXML
    private Button retrMessageButton;




    @FXML
    void initialize() {


        logPass.setOnAction(event -> {
            userInput(user.getText(),textArea);
            passInput(pass.getText(),textArea);

        });

        quit.setOnAction(event -> {
                indexRemov = parseInt(delet.getText());//удаленеи из листа
                if(indexRemov==-1) {
                    textArea.appendText("* -ERR no such message\n");
                }else {
                    textArea.appendText("* +OK message deleted\n" );
                }

            });

            list.setOnAction(event1 -> {
            sizeMass[indexRemov]=0;
            messagesMass[indexRemov]=null;
            if (messagesMass!=null){
                textArea.appendText("* +OK scan listing follows\n");
                for (int i=0;i<messagesMass.length;i++) {
                    textArea.appendText(i +"  "+sizeMass[i]+"\n");
                }
            }else {
                textArea.appendText("* -ERR no such message\n");
            }

        });




        retrMessageButton.setOnAction(event -> {
            int numMessage=parseInt(retr.getText());
            textArea.appendText(massivMessage[numMessage]+"\n");
        });




        smtp.setOnAction(event -> { windomAdd("View/smtp.fxml");});
        post.setOnAction(event -> { windomAdd("View/serverMessage.fxml");});

}
    public void windomAdd(String windom){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(windom));
        try {
            loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Parent root=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));

        stage.showAndWait();
    }

    private static void userInput(String user,TextArea textArea){
        if (user.equals("damir1397")){

            textArea.appendText(user+"\n"+"+OK Name is a valid mailbox\n");
        }else {
            textArea.appendText("-ERR never heard of mailbox name\n");
        }

    }
    private static void passInput(String pass,TextArea textArea){
        if (pass.equals("1397")){
            textArea.appendText(pass+"\n" +"+OK Mailbox locked and ready\n");

        }else {
            textArea.appendText("-ERR invalid password\n");
        }
    }

}
