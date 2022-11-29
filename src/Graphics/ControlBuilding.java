package Graphics;

import Building.Building;
import SSMS_Con.SSMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControlBuilding {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private RadioButton rSize,rGroup,rNumber,rPrice;

    @FXML
    private RadioButton rSizeSearch,rGroupSearch,rNameSearch;

    @FXML
    private Button submitBut;
    @FXML
    private TextField textfFeld;
    private Building building;

    private String searchingBy;
    public void init(Building building){
        this.building=building;

    }

    /*public void setParent(Parent parent){
        this.parent = parent;
    }*/

    @FXML
    public void backtoMain(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Room.fxml"));
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
    public void listSortedAll(ActionEvent actionEvent){
        Text text = new Text();
        if(rGroup.isSelected()){
            text.setText(building.sortByGroup());
        }else if(rSize.isSelected()){
            text.setText(building.sortBySize());
        } else if (rNumber.isSelected()) {
            text.setText(building.sortByNumber());
        } else if (rPrice.isSelected()) {
            text.setText(building.sortByPrice());
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
    public void submit(ActionEvent actionEvent){
        Text text = new Text();
        String field = textfFeld.getText();
        if(searchingBy.equalsIgnoreCase("name")){
            text.setText(building.searchByName(field));
        } else if (searchingBy.equalsIgnoreCase("group")) {
            text.setText(building.searchByGroup(field));
        } else if (searchingBy.equalsIgnoreCase("size")) {
            text.setText(building.searchBySize(field));
        }

        scrollPane.setContent(text);
    }

    @FXML
    public void backtoStart(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
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

}
