package sample;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Message {

    private final SimpleStringProperty acountMessage;
    private final SimpleStringProperty emailAcount;
    private final SimpleStringProperty nameAcount;
    private final SimpleIntegerProperty size;


    public Message(String message, String emailAcount, String nameAcount, Integer size) {
        this.acountMessage = new SimpleStringProperty(message);
        this.emailAcount = new SimpleStringProperty(emailAcount);
        this.nameAcount = new SimpleStringProperty(nameAcount);
        this.size = new SimpleIntegerProperty(size);

    }

    public String getAcountMessage() {
        return acountMessage.get();
    }
    public SimpleStringProperty acountMessageProperty() {
        return acountMessage;
    }
    public void setAcountMessage(String acountMessage) {
        this.acountMessage.set(acountMessage);
    }


    public String getEmailAcount() {
        return emailAcount.get();
    }
    public SimpleStringProperty emailAcountProperty() {
        return emailAcount;
    }
    public void setEmailAcount(String emailAcount) {
        this.emailAcount.set(emailAcount);
    }

    public String getNameAcount() {
        return nameAcount.get();
    }
    public SimpleStringProperty nameAcountProperty() {
        return nameAcount;
    }
    public void setNameAcount(String nameAcount) {
        this.nameAcount.set(nameAcount);
    }

    public  Integer getSize() {
        return size.get();
    }
    public SimpleIntegerProperty sizeProperty() {
        return size;
    }
    public void setSize(Integer size) {
        this.size.set(size);
    }


}
