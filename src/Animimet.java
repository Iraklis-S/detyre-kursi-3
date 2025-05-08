import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animimet extends Application {

    private RotateTransition rrotullo;
    private FadeTransition zbeh;

    @Override
    public void start(Stage primaryStage) {
        // paneli kryesor qe mban gjithe elementet e tjere
        Pane root = new Pane();

        // krijojme nje Image te ri
        Image image = new Image("file:lule.jpg");
        // krijojme nje ImageView per imazhin e cila mundeson shfaqjen e imazhit ne
        // skene dhe disa metoda per paraqitjen
        ImageView imageView = new ImageView(image);
        // vendosim gjatesine dhe gejresin e imazhit
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        // pozicionojme elementin ne Skene(100px nga TOP e prindit) dhe (zhvendosim
        // 200px majtas cepin e majte-lart te elementit)->Koordinata e origjines
        imageView.setX(200);
        imageView.setY(100);

        // krijojme nje transition rrotullo qe perdoret per Rrotullimin e imazhit
        rrotullo = new RotateTransition(Duration.seconds(1), imageView);
        // Vendos qe animacioni te kete nje rrotullim prej 360 grade per cdo cikel te
        // transition
        rrotullo.setByAngle(360);
        // cycleCount vendoset INDEFINITE qe animimi te perseritet
        rrotullo.setCycleCount(RotateTransition.INDEFINITE);
        // animimi nuk kthehet ne gjendjen fillestare
        rrotullo.setAutoReverse(false);

        // krijojme nje Transition te ri Fade per zbehjen e imazhit
        zbeh = new FadeTransition(Duration.seconds(1), imageView);
        // vendos vleren e zbehjes ku fillon animimi
        zbeh.setFromValue(1.0);
        // vendos vleren e zbehjes ku mbaron animimi
        zbeh.setToValue(0.3);
        // animimi perseritet pafundesisht
        zbeh.setCycleCount(FadeTransition.INDEFINITE);
        zbeh.setAutoReverse(true);

        // Krijojme Ngjarjen ku mouse futet ne imazh dhe Transition/Animimi behet play
        imageView.setOnMouseEntered(e -> {
            rrotullo.play();
            zbeh.play();
        });

        // Kur Mouse del nga Imazhi ,ndalojme Animimin
        imageView.setOnMouseExited(e -> {
            rrotullo.stop();
            zbeh.stop();
        });

        // Krijojme disa butona per levizjen e Nodes ne Ekran/Window
        Button upBtn = new Button("↑");
        Button downBtn = new Button("↓");
        Button leftBtn = new Button("←");
        Button rightBtn = new Button("→");

        // Pozicionojme Butonat ne Layout
        upBtn.setLayoutX(250);
        downBtn.setLayoutX(250);
        leftBtn.setLayoutX(200);
        rightBtn.setLayoutX(300);

        upBtn.setLayoutY(340);
        downBtn.setLayoutY(370);
        leftBtn.setLayoutY(370);
        rightBtn.setLayoutY(370);

        // lidhim Butonat me Eventin e klikimit dhe therrasim metoden move() me
        // parametrat e pixels qe duhet te levizim
        upBtn.setOnAction(e -> move(imageView, 0, -50));
        downBtn.setOnAction(e -> move(imageView, 0, 50));
        leftBtn.setOnAction(e -> move(imageView, -50, 0));
        rightBtn.setOnAction(e -> move(imageView, 50, 0));

        // shtojme gjithe Nodes tek Layouti(Pane)
        root.getChildren().addAll(imageView, upBtn, downBtn, leftBtn, rightBtn);
        // krijojme skenen me Layoutin qe do te perdore dhe madhesine qe na duhet
        Scene scene = new Scene(root, 500, 400);
        // vendos titullin e Window/App
        primaryStage.setTitle("JavaFX - Animim Imazhi");
        // vendos skenen tek Platforma
        primaryStage.setScene(scene);
        // tregon/ ben render Platformen
        primaryStage.show();
    }

    // merr si argument Imazhin dhe vlerat ne pixel qe do te levizim majtas/djathtas
    // larte/poshte
    private void move(ImageView imageView, double x, double y) {
        // krijojme nje Transition move i cili zgjat 300 mili-sekonda
        TranslateTransition move = new TranslateTransition(Duration.millis(300), imageView);
        // vendosim X se sa px do te levizim ne boshtin x relative nga ku jemi
        move.setByX(x);
        // vendosim Y se sa px do te levizim ne boshtin y relative nga ku jemi
        move.setByY(y);
        // perseritet vetem 1 here per klikim butoni
        move.setCycleCount(1);
        // fillon animimin
        move.play();
    }

    //metoda main therret metoden launch() e cila ne menyre automatike therret krijimin e platformes nepermjet metodes start() te cilen e kemi ber @Override
    public static void main(String[] args) {
        launch(args);
    }
}
