package GUI;

import DAO.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddUserGUI {
    public static void main(Stage primaryStage, final Database database) {
        VBox mainBox = new VBox();

        final TextField idField = new TextField("ID");
        final TextField nameField = new TextField("name");

        Button addUserButton = new Button("Add");

        mainBox.getChildren().addAll(idField, nameField, addUserButton);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(10));
        mainBox.setSpacing(5);

        Scene secondScene = new Scene(mainBox, 400, 400);

        final Stage newWindow = new Stage();
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        newWindow.show();
        addUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label label = new Label();

                if (database.addUser(idField.getText(), nameField.getText())) {
                    label.setText("Success!");
                } else {
                    label.setText("Wrong");
                }

                Scene thirdScene = new Scene(label, 100, 100);


                Stage newWindow2 = new Stage();
                newWindow2.setScene(thirdScene);

                // Specifies the modality for new window.
                newWindow2.initModality(Modality.WINDOW_MODAL);

                // Specifies the owner Window (parent) for new window
                newWindow2.initOwner(newWindow);
                newWindow2.show();

            }
        });
    }
}
