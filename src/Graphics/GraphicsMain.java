package Graphics;

import Building.Building;
import SSMS_Con.SSMS;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GraphicsMain extends Application {

    private Building building;
    private SSMS conn;

    public void setBuilding_Conn(Building building,SSMS conn){
        this.building = building;
        this.conn = conn;
    }

    public void startWindow(){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
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
