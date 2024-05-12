package finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App extends Application {

    private ConfigurableApplicationContext context;
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        context = SpringApplication.run(CardUploaderApplication.class);
        restTemplate = context.getBean(RestTemplate.class);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        TextField colorField = new TextField();
        colorField.setPromptText("Color");

        TextField rarityField = new TextField();
        rarityField.setPromptText("Rarity");

        TextField manaValueField = new TextField();
        manaValueField.setPromptText("Mana Value");

        TextField setReleaseField = new TextField();
        setReleaseField.setPromptText("Set Release");

        TextField releaseDateField = new TextField();
        releaseDateField.setPromptText("Release Date");

        Label statusLabel = new Label();

        Button uploadButton = new Button("Upload Card");
        uploadButton.setOnAction(e -> {
            String color = colorField.getText();
            String rarity = rarityField.getText();
            String manaValue = manaValueField.getText();
            String setRelease = setReleaseField.getText();
            String releaseDate = releaseDateField.getText();

            Card card = new Card(color, rarity, manaValue, setRelease, releaseDate);

            ResponseEntity<String> response = restTemplate.postForEntity("/upload/card", card, String.class);
            statusLabel.setText(response.getBody());
        });

        root.getChildren().addAll(colorField, rarityField, manaValueField, setReleaseField, releaseDateField,
                uploadButton, statusLabel);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Card Uploader");
        primaryStage.show();
    }

    @Override
    public void stop() {
        context.close();
    }
}
