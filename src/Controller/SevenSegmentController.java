package Controller;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SevenSegmentController {

    @FXML
    private Rectangle a, b, c, d, e, f, g;

    private void reset() {
        Rectangle[] rectangles = {a, b, c, d, e, f, g};
        for (Rectangle rectangle : rectangles) {
            rectangle.setFill(Color.TRANSPARENT);
        }
    }

    public void showNumber(int number) {
        switch (number) {
            case 0:
                setLedOn(a, b, c, d, e, f);
                break;
            case 1:
                setLedOn(b, c);
                break;
            case 2:
                setLedOn(a, b, e, d, g);
                break;
            case 3:
                setLedOn(a, b, c, d, g);
                break;
            case 4:
                setLedOn(b, c, f, g);
                break;
            case 5:
                setLedOn(a, c, d, f, g);
                break;
            case 6:
                setLedOn(a, c, d, e, f, g);
                break;
            case 7:
                setLedOn(a, b, c);
                break;
            case 8:
                setLedOn(a, b, c, d, e, f, g);
                break;
            case 9:
                setLedOn(a, b, c, d, f, g);
                break;
        }
    }

    private void setLedOn(Rectangle... rectangles) {
        reset();
        for (Rectangle rectangle : rectangles) {
            rectangle.setFill(Color.BLACK);
        }
    }
}
