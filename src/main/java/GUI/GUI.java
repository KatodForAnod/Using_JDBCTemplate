package GUI;

import DAO.Database;
import DAO.UserDAO;
import Model.UserModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        final Database userDAO = new UserDAO();


        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(5);

        final TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setMinHeight(500);
        vbox.getChildren().add(textArea);


        MenuBar menuBar = new MenuBar();


        Menu ShowMenu = new Menu("Show");
        Menu AddMenu = new Menu("AddUser");

        MenuItem newItem = new MenuItem("Show");
        MenuItem addItem = new MenuItem("Add");

        ShowMenu.getItems().addAll(newItem);
        AddMenu.getItems().addAll(addItem);

        menuBar.getMenus().addAll(ShowMenu, AddMenu);


        BorderPane MainRoot = new BorderPane();
        MainRoot.setTop(menuBar);
        MainRoot.setCenter(vbox);

        Scene scene = new Scene(MainRoot, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();


        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                List<UserModel> userModelList = userDAO.getAllUsers();

                for (UserModel i : userModelList) {
                    textArea.setText(textArea.getText() +
                            "ID = " + i.getID() + ", name = " + i.getName() + "\n");
                }
            }
        });
        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddUserGUI.main(primaryStage, userDAO);
            }
        });
    }
}
