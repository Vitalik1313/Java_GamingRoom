package Graphics;

import Building.Building;
import SSMS_Con.SSMS;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    @FXML
    private Label accoutLabel;
    private Stage stageBuild;
    private Scene sceneBuild;
    private Parent root;
    private Building building;
    private SSMS conn;

    @FXML
    private Label mainMenuLabel;

    public void initController(Building building){
        this.building = building;
    }

    @FXML
    public void switchToBuilding(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Building.fxml"));
        root = loader.load();
        stageBuild = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        sceneBuild = new Scene(root);

        Image icon = new Image("Images/img_1.png");
        stageBuild.getIcons().add(icon);
        stageBuild.setTitle("Gaming_Room");
        stageBuild.setScene(sceneBuild);

        String css = this.getClass().getResource("app.css").toExternalForm();
        sceneBuild.getStylesheets().add(css);
        stageBuild.show();

        ControlBuilding controller = loader.getController();
        controller.init(new Building(new SSMS().getConn()));
    }

    @FXML
    public void switchToRoom(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Room.fxml"));
        root = loader.load();
        stageBuild = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        sceneBuild = new Scene(root);

        Image icon = new Image("Images/img_1.png");
        stageBuild.getIcons().add(icon);
        stageBuild.setTitle("Gaming_Room");
        stageBuild.setScene(sceneBuild);

        String css = this.getClass().getResource("app.css").toExternalForm();
        sceneBuild.getStylesheets().add(css);
        stageBuild.show();
    }

    @FXML
    public void showAccounting(ActionEvent actionEvent){
        accoutLabel.setVisible(true);
        accoutLabel.setText(building.getAccounting().toString());
        PauseTransition visiblePause = new PauseTransition(
                Duration.seconds(5)
        );
        visiblePause.setOnFinished(
                event -> accoutLabel.setVisible(false)
        );
        visiblePause.play();

    }

    @FXML
    public void exit(ActionEvent actionEvent){
        System.exit(1);
    }

    @FXML
    public void getInFirstRoom(ActionEvent actionEvent) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CertainRoom.fxml"));
        root = loader.load();
        stageBuild = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        sceneBuild = new Scene(root);

        Image icon = new Image("Images/img_1.png");
        stageBuild.getIcons().add(icon);
        stageBuild.setTitle("Gaming_Room");
        stageBuild.setScene(sceneBuild);

        String css = this.getClass().getResource("app.css").toExternalForm();
        sceneBuild.getStylesheets().add(css);
        stageBuild.show();
        RoomController roomController = loader.getController();
        roomController.init(0);
    }

    @FXML
    public void getInSecondRoom(ActionEvent actionEvent) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CertainRoom.fxml"));
        root = loader.load();
        stageBuild = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        sceneBuild = new Scene(root);

        Image icon = new Image("Images/img_1.png");
        stageBuild.getIcons().add(icon);
        stageBuild.setTitle("Gaming_Room");
        stageBuild.setScene(sceneBuild);

        String css = this.getClass().getResource("app.css").toExternalForm();
        sceneBuild.getStylesheets().add(css);
        stageBuild.show();
        RoomController roomController = loader.getController();
        roomController.init(1);
    }

    @FXML
    public void getInThirdRoom(ActionEvent actionEvent) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CertainRoom.fxml"));
        root = loader.load();
        stageBuild = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        sceneBuild = new Scene(root);

        Image icon = new Image("Images/img_1.png");
        stageBuild.getIcons().add(icon);
        stageBuild.setTitle("Gaming_Room");
        stageBuild.setScene(sceneBuild);

        String css = this.getClass().getResource("app.css").toExternalForm();
        sceneBuild.getStylesheets().add(css);
        stageBuild.show();
        RoomController roomController = loader.getController();
        roomController.init(2);
    }

    @FXML
    public void backtoMain(ActionEvent actionEvent) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = loader.load();

        Image icon = new Image("Images/img_1.png");
        Scene scene = new Scene(root);
        stage.getIcons().add(icon);
        stage.setTitle("Gaming_Room");
        stage.setScene(scene);
        stage.show();

        String css = this.getClass().getResource("app.css").toExternalForm();
        scene.getStylesheets().add(css);

        Controller controller = loader.getController();
        controller.initController(new Building(new SSMS().getConn()));
    }


}
