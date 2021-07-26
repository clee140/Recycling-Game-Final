// CREATED BY CHRISTOPHER LEE.
// The RecyclingGame is an interactive game where the user will sort ten common waste items into the three types of trash
// bins (black, blue, and green). The user begins the game with 0 points and will either receive 100 points for
// correctly sorting the item or lose 100 points for incorrectly sorting the item. The user will then sort the item
// (displayed in the top-center position of the interface with the corresponding picture to the left of it) by
// either clicking the black bin, blue bin, or green bin buttons, which is located on the bottom of the interface.
// If the item is correctly sorted, the user will gain 100 points and the next item will be displayed, which will be
// sorted by the user. If the item is incorrectly sorted, the user will lose 100 points and will have to sort the item
// in the correct bin before being able to move on to the next item. This process will continue until the last item
// that needs to be sorted is reached. Once the last item is correctly sorted, the game will end and an end of game
// message will be displayed in the console.

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

public class RecyclingGame extends Application {
    private int score = 0;
    private int count = 0;
    private int imageCounter = 1;
    private final ImageView BLACK_BIN_IMAGE = new ImageView("BlackTrashBin.png");
    private final ImageView BLUE_BIN_IMAGE = new ImageView("BlueTrashBin.png");
    private final ImageView GREEN_BIN_IMAGE = new ImageView("GreenTrashBin.png");
    private final ImageView AEROSOL_CAN_IMAGE = new ImageView("EmptyAerosolCan.png");
    private final ImageView PLASTIC_TUBS_IMAGE = new ImageView("PlasticTubs.png");
    private final ImageView TEA_BAGS_IMAGE = new ImageView("TeaBag.png");
    private final ImageView BONES_IMAGE = new ImageView("Bones.png");
    private final ImageView DRINK_BOXES_IMAGE = new ImageView("DrinkBox.png");
    private final ImageView GLASSWARE_IMAGE = new ImageView("Glassware.png");
    private final ImageView STEEL_CANS_IMAGE = new ImageView("SteelCan.png");
    private final ImageView PIZZA_BOX_IMAGE = new ImageView("PizzaBox.png");
    private final ImageView CAT_LITTER_IMAGE = new ImageView("CatLitter.png");
    private final ImageView WAXED_PAPER_CONTAINER_IMAGE = new ImageView("WaxedPaperContainer.png");
    private final Button BLACK_BIN_BUTTON = new Button("Black Bin");
    private final Button BLUE_BIN_BUTTON = new Button("Blue Bin");
    private final Button GREEN_BIN_BUTTON = new Button("Green Bin");
    private final TextField TEXTFIELD_ZIP_CODE = new TextField();
    private final Label ZIP_CODE_LABEL = new Label("Enter zip code: ");
    private final Label POINT_TOTAL = new Label("Points: " + score);
    private final Label ITEM = new Label();
    private final String[] ITEMS = {"Empty Aerosol Cans", "Plastic Tubs", "Tea Bags", "Bones", "Drink Boxes",
        "Glassware", "Steel Cans", "Pizza Box", "Cat litter", "Waxed Paper Containers"};
    private final String[] KEY = {"Black", "Blue", "Green", "Green", "Black", "Black", "Blue", "Green", "Black",
        "Green"};
    private final ArrayList<ImageView> IMAGES = new ArrayList<>();
    private final BorderPane PANE = new BorderPane();
    private final HBox INFO_HBOX = new HBox();
    private final HBox IMAGE_HBOX = new HBox();
    private final HBox ZIP_CODE_HBOX = new HBox();
    private final HBox IMAGES_HBOX = new HBox();
    private final HBox BUTTONS_HBOX = new HBox();

    // The images of the items that will be displayed are added to ITEMS.
    private void initializeImages() {
        IMAGES.add(AEROSOL_CAN_IMAGE);
        IMAGES.add(PLASTIC_TUBS_IMAGE);
        IMAGES.add(TEA_BAGS_IMAGE);
        IMAGES.add(BONES_IMAGE);
        IMAGES.add(DRINK_BOXES_IMAGE);
        IMAGES.add(GLASSWARE_IMAGE);
        IMAGES.add(STEEL_CANS_IMAGE);
        IMAGES.add(PIZZA_BOX_IMAGE);
        IMAGES.add(CAT_LITTER_IMAGE);
        IMAGES.add(WAXED_PAPER_CONTAINER_IMAGE);
    }

    // The method setImageDimensions() will set the dimensions of the images in this game. The three bins will be set
    // to 500 x 500 and the rest will be set to 350 x 350.
    private void setImageDimensions() {
        BLACK_BIN_IMAGE.setFitHeight(500);
        BLACK_BIN_IMAGE.setFitWidth(500);
        BLUE_BIN_IMAGE.setFitHeight(500);
        BLUE_BIN_IMAGE.setFitWidth(500);
        GREEN_BIN_IMAGE.setFitHeight(500);
        GREEN_BIN_IMAGE.setFitWidth(500);
        AEROSOL_CAN_IMAGE.setFitWidth(350);
        AEROSOL_CAN_IMAGE.setFitHeight(350);
        PLASTIC_TUBS_IMAGE.setFitWidth(350);
        PLASTIC_TUBS_IMAGE.setFitHeight(350);
        TEA_BAGS_IMAGE.setFitWidth(350);
        TEA_BAGS_IMAGE.setFitHeight(350);
        BONES_IMAGE.setFitWidth(350);
        BONES_IMAGE.setFitHeight(350);
        DRINK_BOXES_IMAGE.setFitWidth(350);
        DRINK_BOXES_IMAGE.setFitHeight(350);
        GLASSWARE_IMAGE.setFitWidth(350);
        GLASSWARE_IMAGE.setFitHeight(350);
        STEEL_CANS_IMAGE.setFitWidth(350);
        STEEL_CANS_IMAGE.setFitHeight(350);
        PIZZA_BOX_IMAGE.setFitWidth(350);
        PIZZA_BOX_IMAGE.setFitHeight(350);
        CAT_LITTER_IMAGE.setFitWidth(350);
        CAT_LITTER_IMAGE.setFitHeight(350);
        WAXED_PAPER_CONTAINER_IMAGE.setFitWidth(350);
        WAXED_PAPER_CONTAINER_IMAGE.setFitHeight(350);
    }

    // The setButtons() method will set the size, font, and style for the three buttons.
    private void setButtons() {
        BLACK_BIN_BUTTON.setPrefSize(350, 150);
        BLACK_BIN_BUTTON.setFont(new Font("Arial", 50));
        BLACK_BIN_BUTTON.setStyle("-fx-border-color: black; -fx-border-width: 5px;");
        BLUE_BIN_BUTTON.setPrefSize(350, 150);
        BLUE_BIN_BUTTON.setFont(new Font("Arial", 50));
        BLUE_BIN_BUTTON.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-text-fill: blue;");
        GREEN_BIN_BUTTON.setPrefSize(350, 150);
        GREEN_BIN_BUTTON.setFont(new Font("Arial", 50));
        GREEN_BIN_BUTTON.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-text-fill: green;");
    }

    // The setGameInfo() method will set the font and style for the game info (point total label, item label, zip code
    // label, and zip code text field).
    private void setGameInfo() {
        POINT_TOTAL.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        POINT_TOTAL.setUnderline(true);
        ITEM.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        ITEM.setStyle("-fx-text-fill: red");
        ITEM.setUnderline(true);
        ITEM.setText("Item: " + ITEMS[count]);
        ZIP_CODE_LABEL.setFont(new Font("Arial", 20));
        TEXTFIELD_ZIP_CODE.setMaxSize(60, 25);
    }

    // The setInfoHBox() method is created to hold the labels. The HBox places all nodes (components attached to the
    // scene, in this case labels) horizontally in one row.
    private void setInfoHBox() {
        // Sets the inside offsets for the four sides of rectangular area.
        INFO_HBOX.setPadding(new Insets(50, 30, 10, 30));

        // Sets the spacing between each child in the HBox.
        INFO_HBOX.setSpacing(500);

        // The labels are placed in the HBox using the method getChildren(), which returns the list of nodes in the
        // pane.
        INFO_HBOX.getChildren().add(ITEM);
        INFO_HBOX.getChildren().add(POINT_TOTAL);
    }

    // The setZipCodeHBox() method is created to hold the images. The HBox places all nodes (components attached to the
    // scene, in this case images) horizontally in one row.
    private void setZipCodeHBox() {
        ZIP_CODE_HBOX.setPadding(new Insets(10, 30, 10, 0));

        // Sets the spacing between each child in the HBox.
        ZIP_CODE_HBOX.setSpacing(20);

        // The label and text field are placed in the HBox using the method getChildren(), which returns the list of
        // nodes in the pane.
        ZIP_CODE_HBOX.getChildren().add(ZIP_CODE_LABEL);
        ZIP_CODE_HBOX.getChildren().add(TEXTFIELD_ZIP_CODE);
    }

    // The setItemImageHBox() method is created to hold the images. The HBox places all nodes (components attached to the
    // scene, in this case images) horizontally in one row.
    private void setItemImageHBox() {
        IMAGE_HBOX.setPadding(new Insets(50, 0, 10, 30));
        IMAGE_HBOX.getChildren().add(IMAGES.get(0));
    }

    // The setImagesHBox() method is created to hold the images. The HBox places all nodes (components attached to the
    // scene, in this case images) horizontally in one row.
    private void setImagesHBox() {
        // Sets the inside offsets for the four sides of rectangular area.
        IMAGES_HBOX.setPadding(new Insets(300, 0, 20, 0));

        // Sets the spacing between each child in the HBox.
        IMAGES_HBOX.setSpacing(30);

        // The images are placed in the HBox using the method getChildren(), which returns the list of nodes in the
        // pane.
        IMAGES_HBOX.getChildren().addAll(BLACK_BIN_IMAGE, BLUE_BIN_IMAGE, GREEN_BIN_IMAGE);
    }

    // The setButtonsHBox() method is created to hold the buttons. The HBox places all nodes (components attached to the
    // scene, in this case buttons) horizontally in one row.
    private void setButtonsHBox() {
        // Sets the spacing between each child in the HBox.
        BUTTONS_HBOX.setSpacing(150);

        // Sets the inside offsets for the four sides of rectangular area.
        BUTTONS_HBOX.setPadding(new Insets(0, 120, 110, 500));

        // The three buttons are placed in the HBox using the method getChildren(), which returns the list of nodes in
        // the pane.
        BUTTONS_HBOX.getChildren().addAll(BLACK_BIN_BUTTON, BLUE_BIN_BUTTON, GREEN_BIN_BUTTON);
    }

    // An action handler for each button (black bin, blue bin, green bin) is created. A lambda expression is used for
    // simplification purposes.
    private void handleEvents() {
        EventHandler<ActionEvent> event1 = e -> {
            evaluateAnswers("Black");
        };
        BLACK_BIN_BUTTON.setOnAction(event1);

        EventHandler<ActionEvent> event2 = e -> {
            evaluateAnswers("Blue");
        };
        BLUE_BIN_BUTTON.setOnAction(event2);

        EventHandler<ActionEvent> event3 = e -> {
            evaluateAnswers("Green");
        };
        GREEN_BIN_BUTTON.setOnAction(event3);
    }

    // The gradeAnswers() method will determine if the user's answer is correct. The method will compare the user's
    // answer to the key and if it matches, the user is rewarded 100 points. Conversely, the user will lose 100 points
    // if their answer is incorrect. The user will have as many tries as needed until the correct answer is selected.
    private boolean gradeAnswers() {
        if (ITEMS[count].equals(KEY[count])) {
            score += 100;
            System.out.println("Correct!");
            count++;
            return true;
        } else {
            score -= 100;
        }
        return false;
    }

    // The evaluateAnswers() method will perform two actions depending on the user's answer. If the user gets the
    // correct answers, the score will change and the image of the next item will be displayed. If the user get the
    // wrong answer, the score will change and a message will print in the console.
    private void evaluateAnswers(String answer) {
        ITEMS[count] = answer;
        if (gradeAnswers() && count < ITEMS.length) {
            POINT_TOTAL.setText("Points: " + score);
            ITEM.setText("Item: " + ITEMS[count]);
            IMAGE_HBOX.getChildren().clear();
            IMAGE_HBOX.getChildren().add(IMAGES.get(imageCounter));
            imageCounter++;
        } else {
            POINT_TOTAL.setText("Points: " + score);
            System.out.println("Incorrect! Try Again!");
        }

        if (count >= ITEMS.length) {
            if (score == 1000) {
                System.out.println("Congratulations! You have won the game!");
            } else {
                System.out.println("Game Over! You have " + score + " points");
            }
        }
    }

    protected BorderPane getPane() {
        initializeImages();
        setImageDimensions();
        setButtons();
        setGameInfo();
        setItemImageHBox();
        setInfoHBox();
        setZipCodeHBox();
        setImagesHBox();
        setButtonsHBox();
        handleEvents();

        // The game information is added to the top of the pane, the zip code information is added to the right of the
        // pane, the images of the trash bins are added to the left of the pane, and the buttons are added to the
        // bottom of the pane.
        PANE.setTop(INFO_HBOX);
        PANE.setLeft(IMAGE_HBOX);
        PANE.setRight(ZIP_CODE_HBOX);
        PANE.setCenter(IMAGES_HBOX);
        PANE.setBottom(BUTTONS_HBOX);
        return PANE;
    }

    // Override the start method in the Application class.
    @Override
    public void start(Stage primaryStage) {
        // The scene is created and it is placed in the stage.
        Scene scene = new Scene(getPane(), 2200, 1400);

        // The stage is titled is set to "Recycling Game".
        primaryStage.setTitle("Recycling Game");

        // The scene is placed in the stage.
        primaryStage.setScene(scene);

        // The stage is displayed.
        primaryStage.show();
    }

    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Hi");
        Application.launch(args);
    }
}