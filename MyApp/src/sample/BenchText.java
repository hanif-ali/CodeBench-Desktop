package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class BenchText {

    private Polygon B1;
    private Polygon B2;
    private Polygon E1;
    private Rectangle E2;
    private Polygon N;
    private Polygon C;
    private Polygon H;

    public Polygon getB1() {
        return B1;
    }

    public Polygon getB2() {
        return B2;
    }

    public Polygon getE1() {
        return E1;
    }

    public Rectangle getE2() {
        return E2;
    }

    public Polygon getN() {
        return N;
    }

    public Polygon getC() {
        return C;
    }

    public Polygon getH() {
        return H;
    }

    public BenchText(){}

    public HBox createBenchText(){

        AnchorPane p1 = new AnchorPane();
        AnchorPane p2 = new AnchorPane();
        AnchorPane p3 = new AnchorPane();
        AnchorPane p4 = new AnchorPane();
        AnchorPane p5 = new AnchorPane();
        HBox benchText = new HBox();

        double[] pB1 = {-40.0, -163.0, -25.0, -150.0, -25.0, -137.0, 19.0, -137.0, 29.0, -130.0, 19.0, -123.0, -25.0, -123.0, -25.0, -110.0, -40.0, -97.36300659179688};
         B1 = new Polygon(pB1);
        B1.setFill(Color.web("#4E4964"));
        B1.setLayoutX(50);
        B1.setLayoutY(200);

        double[] pB2 = {40.0, -87.36300659179688, 40.0, -111.0, 51.0, -119.0, 40.0, -127.0, 40.0, -153.0, -35.0, -153.0, -20.0, -139.0, 23.0, -139.0, 23.0, -127.0, 34.0, -119.0, 23.0, -111.0, 23.0, -101.0, -20.0, -101.0, -35.0, -87.36300659179688};
         B2 = new Polygon(pB2);
        B2.setFill(Color.web("#56497C"));
        B2.setLayoutX(44.5);
        B2.setLayoutY(189.5);

        p1.getChildren().addAll(B1,B2);

        double[] pE1 = {28.0, -83.36300659179688, -47.0, -83.36300659179688, -47.0, -149.0, 28.0, -149.0, 28.0, -136.0, -32.0, -136.0, -32.0, -97.0, 28.0, -97.0, 28.0, -83.36300659179688};
         E1 = new Polygon(pE1);
        E1.setFill(Color.web("#4E4964"));
        E1.setLayoutX(47);
        E1.setLayoutY(185);

         E2 = new Rectangle();
        E2.setHeight(14);
        E2.setWidth(53);
        E2.setArcHeight(0);
        E2.setArcWidth(0);
        E2.setFill(Color.web("#56497C"));
        E2.setLayoutX(22);
        E2.setLayoutY(61);

        p2.getChildren().addAll(E1,E2);

        double[] pN = {-29.0, -174.36300659179688, -14.0, -174.36300659179688, -14.0, -215.0, 29.0, -174.36300659179688, 45.0, -174.36300659179688, 45.0, -240.0, 29.0, -240.0, 29.0, -197.0, -14.0, -240.0, -29.0, -240.0};
         N = new Polygon(pN);
        N.setFill(Color.web("#4E4964"));
        N.setLayoutX(28);
        N.setLayoutY(277);

        p3.getChildren().add(N);

        double[] pC = {77.0, -297.0, 77.0, -231.36300659179688, 150.0, -231.36300659179688, 150.0, -245.0, 92.0, -245.0, 92.0, -284.0, 150.0, -284.0, 150.0, -297.0};
         C = new Polygon(pC);
        C.setFill(Color.web("#4E4964"));
        C.setLayoutX(-76);
        C.setLayoutY(334);

        p4.getChildren().add(C);

        double[] pH = {64.0, -160.0, 79.0, -160.0, 79.0, -187.0, 125.0, -187.0, 125.0, -160.0, 139.0, -160.0, 139.0, -228.0, 125.0, -228.0, 125.0, -203.0, 79.0, -203.0, 79.0, -228.0, 64.0, -228.0};
         H = new Polygon(pH);
        H.setFill(Color.web("#4E4964"));
        H.setLayoutX(-65);
        H.setLayoutY(263);

        p5.getChildren().add(H);

        Insets inset = new Insets(-30,5,5,-5);
        benchText.setPadding(inset);
        benchText.setSpacing(118);
        benchText.getChildren().addAll(p1,p2,p3,p4,p5);

        return benchText;

    }

}
