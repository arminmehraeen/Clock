package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ClockController implements Initializable {

    @FXML
    HBox root;
    SevenSegmentController[] controllers = new SevenSegmentController[6];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #FAAD80;");
        for (int i=0; i<6 ; i++){
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../View/SevenSegment.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            root.getChildren().add(loader.getRoot());
            controllers[i] = loader.getController();
        }
        Thread thread = new Thread(()->{
            while (true){
                Date date = new Date();
                controllers[0].showNumber(date.getHours()/10);
                controllers[1].showNumber(date.getHours()%10);
                controllers[2].showNumber(date.getMinutes()/10);
                controllers[3].showNumber(date.getMinutes()%10);
                controllers[4].showNumber(date.getSeconds()/10);
                controllers[5].showNumber(date.getSeconds()%10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
