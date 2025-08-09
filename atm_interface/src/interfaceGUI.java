import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class interfaceGUI extends Application{

    public void start(Stage stage)
    {
        Label title =new Label("BANK ATM");
        title.setStyle("-fx-border-color:black;-fx-padding:10; -fx-min-width:200;");
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font("Ariel", 25));

        TextField inputField=new TextField();
        inputField.setPromptText("Enter Amount");
        inputField.setMaxWidth(120);
        inputField.setVisible(false);

        Button deposit=new Button("Deposit");
        Button withdraw=new Button("Withdraw");
        Button balance=new Button("Balance");

        Label display=new Label();
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font("Ariel", 15));

        //eventHandler
        deposit.setOnAction(event ->                //btn1
        {
            inputField.setVisible(true);
            try{
                int amount=Integer.parseInt(inputField.getText());
                String result= balanceStore.deposit(amount);
                display.setText(result);
            }
            catch (NumberFormatException ex){
                display.setText("Please enter a valid number.");
            }
            inputField.clear();
        }
        );

        withdraw.setOnAction(event ->                //btn2
                {
                    inputField.setVisible(true);
                    try{
                        int amount=Integer.parseInt(inputField.getText());
                        String result= balanceStore.withdraw(amount);
                        display.setText(result);
                    }
                    catch (NumberFormatException ex){
                        display.setText("Please enter a valid number.");
                    }
                    inputField.clear();
                }
        );

        balance.setOnAction(event ->                //btn3
                {
                    try{
                        String result= balanceStore.checkBalance();
                        display.setText(result);
                    }
                    catch (NumberFormatException ex){
                        display.setText("Please enter a valid number.");
                    }
                    inputField.clear();
                }
        );


        HBox buttons=new HBox(25,deposit,withdraw,balance);
        buttons.setAlignment(Pos.CENTER);

        VBox mainBox=new VBox(25, title,buttons,inputField,display);
        mainBox.setAlignment(Pos.TOP_CENTER);
        mainBox.setPadding(new Insets(20));

        BorderPane root=new BorderPane();
        root.setCenter(mainBox);

        Scene scene=new Scene(root,500,300);
        stage.setTitle("ATM Interface");
        stage.setScene(scene);
        stage.show();
    }

}
