package Graphics;

import Building.Building;
import SSMS_Con.SSMS;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RoomController {


    private int numberOfRoom ;
    private String searchingBy;

    private String[] groups = {"Sport","Device","Toy"};
    @FXML
    private Label mainMenuLabel;

    @FXML
    private ScrollPane scrollPane;

    private String selected;
    @FXML
    private ListView<String> listBox;

    @FXML
    private RadioButton rSize,rGroup,rNumber,rPrice;

    @FXML
    private RadioButton rSizeSearch,rGroupSearch,rNameSearch;

    @FXML
    private javafx.scene.control.Button submitBut;

    private Building building;

    @FXML
    private TextField textfFeld;

    @FXML
    private Button addBut;

    public void init(int numberOfRoom){
        this.numberOfRoom = numberOfRoom;
        switch (numberOfRoom){
            case 0:
                mainMenuLabel.setText("ROOM - 1");
                break;
            case 1:
                mainMenuLabel.setText("ROOM - 2");
                break;
            case 2:
                mainMenuLabel.setText("ROOM-3");
                break;
        }
        addNewToy();
    }

    @FXML
    public void backtoMain(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FilesFXML/Room.fxml"));
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
    }

    @FXML
    public void listSorted(ActionEvent actionEvent) throws SQLException, IOException {
        building = new Building(new SSMS().getConn());
        Text text = new Text();
        if(rGroup.isSelected()){
            text.setText(building.getRooms().get(numberOfRoom).sortByGroup());
        }else if(rSize.isSelected()){
            text.setText(building.getRooms().get(numberOfRoom).sortBySize());
        } else if (rNumber.isSelected()) {
            text.setText(building.getRooms().get(numberOfRoom).sortByNumber());
        } else if (rPrice.isSelected()) {
            text.setText(building.getRooms().get(numberOfRoom).sortByPrice());
        }
        scrollPane.setContent(text);
    }

    @FXML
    public void searchRadio(ActionEvent actionEvent){
        searchingBy = "";
        textfFeld.setVisible(true);
        submitBut.setVisible(true);
        if(rGroupSearch.isSelected()){
            searchingBy = "group";
        } else if (rSizeSearch.isSelected()) {
            searchingBy = "size";
        } else if (rNameSearch.isSelected()) {
            searchingBy="name";
        }
    }

    @FXML
    public void submit(ActionEvent actionEvent) throws SQLException, IOException {
        building = new Building(new SSMS().getConn());
        Text text = new Text();
        String field = textfFeld.getText();
        if(searchingBy.equalsIgnoreCase("name")){
            text.setText(building.getRooms().get(numberOfRoom).searchByName(field));
        } else if (searchingBy.equalsIgnoreCase("group")) {
            text.setText(building.getRooms().get(numberOfRoom).searchByGroup(field));
        } else if (searchingBy.equalsIgnoreCase("size")) {
            text.setText(building.getRooms().get(numberOfRoom).searchBySize(field));
        }

        scrollPane.setContent(text);
    }

    @FXML
    public void addNewToy(){
        listBox.getItems().addAll(groups);
        listBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                selected = listBox.getSelectionModel().getSelectedItem();
                addBut.setVisible(true);
            }
        });
    }


    public void addNew(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader;
        switch (selected){
            case "Sport":
                loader = new FXMLLoader(getClass().getResource("../FilesFXML/Sport.fxml"));
                break;
            case "Device":
                loader = new FXMLLoader(getClass().getResource("../FilesFXML/Device.fxml"));
                break;
            case "Toy":
                loader = new FXMLLoader(getClass().getResource("../FilesFXML/Toy.fxml"));
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("../FilesFXML/Sport.fxml"));
        }

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

        ControlAdding roomController = loader.getController();
        roomController.init(numberOfRoom,selected);
    }


}
