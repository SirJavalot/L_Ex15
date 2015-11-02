import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class EX15_01 extends Application {
	
public  String getCard(Integer index){
		
		StringBuffer filename = new StringBuffer("file:D:\\book\\image\\card\\.png");
		
		filename.insert(filename.length()-4, index);
		
		return filename.toString();
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bPane = new BorderPane();
		FlowPane fPane = new FlowPane();
		HBox h = new HBox(10);
		h.setAlignment(Pos.CENTER);
		Button refrButton = new Button("Refresh");
		h.getChildren().add(refrButton);
		fPane.setVgap(5);
		fPane.setHgap(5);
		fPane.setStyle("-fx-background-color: green ");
		bPane.setTop(fPane);
		bPane.setBottom(h);
		
		ArrayList<Integer> cards = new ArrayList<>(52);
		
		for(int i=0;i<52;i++)
			cards.add(i+1);
		Collections.shuffle(cards);
		
		for(int i=0;i<4;i++){
			String image = getCard(cards.get(i));
			fPane.getChildren().add(new ImageView(new Image(image)));
		}
		
		refrButton.setOnAction(e -> {
			fPane.getChildren().clear();
			Collections.shuffle(cards);
			for(int i=0;i<4;i++){
				String image = getCard(cards.get(i));
				fPane.getChildren().add(new ImageView(new Image(image)));
			}
		});
		
		
		Scene scene = new Scene(bPane, 400, 120);
		primaryStage.setTitle("display cards");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
