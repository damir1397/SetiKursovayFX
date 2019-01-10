package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public  class ServerM {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Message> table;

    @FXML
    private TableColumn<Message, String> inputMessage;

    @FXML
    private TableColumn<Message,String> emailMessage;

    @FXML
    private TableColumn<Message,String> nameEmail;

    @FXML
    private TableColumn<Message,Integer> sizeMessage;

    private ObservableList<Message>list=FXCollections.observableArrayList();
    public ObservableList<Message> getList() {
        return list;
    }
    public void setList(ObservableList<Message> list) {
        this.list = list;
    }

    public static Message[] messagesMass;
    public static Integer [] sizeMass;
    public static String[] massivMessage;
    public static int indexRemov;

    @FXML
    void initialize() {
        inputMessage.setCellValueFactory(cellData-> cellData.getValue().acountMessageProperty());
        emailMessage.setCellValueFactory(cellData-> cellData.getValue().emailAcountProperty());
        nameEmail.setCellValueFactory(cellData-> cellData.getValue().nameAcountProperty());
        sizeMessage.setCellValueFactory(new PropertyValueFactory<>("size"));

        sizeMass= new Integer[]{0 ,22, 21, 29, Smtp.sizeM};
        massivMessage=new String[]{" ","как дела??","Приглашение ","C Уважением ....",Smtp.sizeMessage};

        messagesMass= new Message[]{new Message(" "," "," ",  0)
                ,new Message(massivMessage[1],"serega@mail.ru","Сергей Александрович",  sizeMass[1])
                ,new Message(massivMessage[2],"Volody@gmail.com","Василий Олегович",sizeMass[2])
                ,new Message(massivMessage[3],"genadi_b@mail.com","Генадий Б",sizeMass[3])
                ,new Message(Smtp.sizeMessage,Smtp.email,Smtp.nameMessage,Smtp.sizeM)};



        list.add(messagesMass[0]);
        list.add(messagesMass[1]);
        list.add(messagesMass[2]);
        list.add(messagesMass[3]);
        list.add(messagesMass[4]);

        list.removeAll(messagesMass[indexRemov]);
        table.setItems(list);


    }


}