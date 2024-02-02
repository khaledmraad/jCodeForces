package  com.example.jcodeforces;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{

    private static final String UserInfo = "https://codeforces.com/api/user.info?handles=";

    static public String responseUserInfoFilePath="./src/main/java/userInfo.json";


    Stage window;
    Button button;

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage primaryStage){
        window=primaryStage;
        window.setTitle("hello fuckers");

        Label userName=new Label("UserName");

        TextField userNameInput = new TextField();

        Label l=new Label();

//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent e) {
//                l.setText(userNameInput.getText());
//            }
//        };

        Button button=new Button("click this ");

        button.setOnAction(e->{
            try {
                System.out.println(UserInfo+userNameInput.getText());
                String resp=SaveResponseFile.sendRequest(UserInfo+userNameInput.getText());
                SaveResponseFile.writeJSON(resp,responseUserInfoFilePath);
                System.out.println(resp);
                l.setText("U EXIST CONGRATSS");

                window.setScene(ContextScene.theContextScene());
            } catch (Exception ex) {
                System.out.println("you dont exist");
                l.setText("U DONT EXIST");
            }
        });


        VBox layout=new VBox();

        layout.getChildren().addAll(userName,userNameInput,l,button);

        Scene scene=new Scene(layout,300,300);

        window.setScene(scene);

        window.show();

    }


}