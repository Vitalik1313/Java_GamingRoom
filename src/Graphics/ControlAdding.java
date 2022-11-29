package Graphics;

import Building.Building;
import Inventory.Device;
import Inventory.Sport;
import Inventory.Toy;
import SSMS_Con.SSMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControlAdding {

    private int numberOfRoom;
    private String selected;

    @FXML
    private Button backBut;

    @FXML
    TextField fSize,fName,fID,fPrice,fTerm,fRent,fBrand,fQuality,fSportName;

    public void init(int numberOfRoom, String selected){
        this.numberOfRoom = numberOfRoom;
        this.selected = selected;
    }

    @FXML
    public void backToRoom(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CertainRoom.fxml"));
        Parent root = loader.load();
        Stage stageBuild = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene sceneBuild = new Scene(root);

        Image icon = new Image("Images/img_1.png");
        stageBuild.getIcons().add(icon);
        stageBuild.setTitle("Gaming_Room");
        stageBuild.setScene(sceneBuild);

        String css = this.getClass().getResource("app.css").toExternalForm();
        sceneBuild.getStylesheets().add(css);
        stageBuild.show();
        RoomController roomController = loader.getController();
        roomController.init(numberOfRoom);
    }

    @FXML
    public void submit(ActionEvent actionEvent) throws SQLException, IOException {
        Building building = new Building(new SSMS().getConn());
        switch (selected){
            case "Sport":
                Sport sport = new Sport(fSize.getText(),fName.getText(), Integer.parseInt(fPrice.getText()),
                        fSportName.getText(),fQuality.getText(),Integer.parseInt(fID.getText()),1);
                building.getRooms().get(numberOfRoom).addNewToy(sport,selected);
                break;
            case "Device":
                Device device = new Device(fSize.getText(),fName.getText(), Integer.parseInt(fPrice.getText()),
                        Integer.parseInt(fRent.getText()),Integer.parseInt(fTerm.getText()),Integer.parseInt(fID.getText()),1);
                building.getRooms().get(numberOfRoom).addNewToy(device,selected);
                break;
            case "Toy":
                Toy toy = new Toy(fSize.getText(),fName.getText(), Integer.parseInt(fPrice.getText()),Integer.parseInt(fID.getText()),fBrand.getText(),1);
                building.getRooms().get(numberOfRoom).addNewToy(toy,selected);
                break;
        }
        backToRoom(actionEvent);
    }
}
