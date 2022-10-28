package application;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;



/*
Assignment 2: Objectifying
	Handle the data in the CSV and JSON file.
	Divide the data from the arcive in objects and then show the data in a GUI (a table of sort).
	
For G:
	- You should be able to sort the data in alfabetical order and present in GUI (Swish or JavaFX).
	- Build your program and UI in a way where you take concern to the futures scalability.
	- Use several classes and show a resonable structure with comments.
	- You need some form of file explorer, to choose a file.
*/



public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	try {
//Adding JSON
		JSONreader jsonr = new JSONreader();
//Adding CSV
		CSVreader csvr = new CSVreader();
		
		
//Adding buttons to choose between existing files
		Button b1 = new Button("Load CSV");
		Button b2 = new Button("Load JSON");
		
//EventHandler loading CSV
		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				BorderPane root = new BorderPane();
				
				TableView<CSVbean> table = new TableView<CSVbean>();
				TableColumn<CSVbean, String> orderDateCol = new TableColumn<CSVbean, String>("ORDERDATE");
				orderDateCol.setCellValueFactory(new PropertyValueFactory<CSVbean, String>("orderDate"));
				
				TableColumn<CSVbean, String> regionCol = new TableColumn<CSVbean, String>("REGION");
				regionCol.setCellValueFactory(new PropertyValueFactory<CSVbean, String>("region"));
				
				TableColumn<CSVbean, String> rep1Col = new TableColumn<CSVbean, String>("REP1");
				rep1Col.setCellValueFactory(new PropertyValueFactory<CSVbean, String>("rep1"));
				
				TableColumn<CSVbean, String> rep2Col = new TableColumn<CSVbean, String>("REP2");
				rep2Col.setCellValueFactory(new PropertyValueFactory<CSVbean, String>("rep2"));
				
				TableColumn<CSVbean, String> itemCol = new TableColumn<CSVbean, String>("ITEM");
				itemCol.setCellValueFactory(new PropertyValueFactory<CSVbean, String>("item"));
				
				TableColumn<CSVbean, Integer> unitsCol = new TableColumn<CSVbean, Integer>("UNITS");
				unitsCol.setCellValueFactory(new PropertyValueFactory<CSVbean, Integer>("units"));
				
				TableColumn<CSVbean, String> unitCostCol = new TableColumn<CSVbean, String>("UNITCOST");
				unitCostCol.setCellValueFactory(new PropertyValueFactory<CSVbean, String>("unitCost"));
				
				TableColumn<CSVbean, String> totalCol = new TableColumn<CSVbean, String>("TOTAL");
				totalCol.setCellValueFactory(new PropertyValueFactory<CSVbean, String>("total"));
				
				table.getColumns().add(orderDateCol);
				table.getColumns().add(regionCol);
				table.getColumns().add(rep1Col);
				table.getColumns().add(rep2Col);
				table.getColumns().add(itemCol);
				table.getColumns().add(unitsCol);
				table.getColumns().add(unitCostCol);
				table.getColumns().add(totalCol);
				
				table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				
				
//Reading and appending sample.csv and removes the header
				for(int i=1; i<= csvr.getOrderDate().size()-1; i++) {
					int unitsInt = Integer.parseInt(csvr.getUnits().get(i));
					
				table.getItems().add(new CSVbean(
						csvr.getOrderDate().get(i), 
						csvr.getRegion().get(i), 
						csvr.getRep1().get(i), 
						csvr.getRep2().get(i),
						csvr.getItem().get(i),
						unitsInt,
						csvr.getUnitCost().get(i),
						csvr.getTotal().get(i)));
				}
			
				root.setCenter(table);
				
				Scene scene = new Scene(root, 800, 800);
				primaryStage.setTitle("TableView CSV");
				primaryStage.setScene(scene);
				primaryStage.show();
				
				
			}	

		};
		
//EventHandler loading JSON
		EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				BorderPane root = new BorderPane();
				
				TableView<JSONbean> table = new TableView<JSONbean>();
				TableColumn<JSONbean, String> orderDateCol = new TableColumn<JSONbean, String>("ORDERDATE");
				orderDateCol.setCellValueFactory(new PropertyValueFactory<JSONbean, String>("orderDate"));
				
				TableColumn<JSONbean, String> regionCol = new TableColumn<JSONbean, String>("REGION");
				regionCol.setCellValueFactory(new PropertyValueFactory<JSONbean, String>("region"));
				
				TableColumn<JSONbean, String> rep1Col = new TableColumn<JSONbean, String>("REP1");
				rep1Col.setCellValueFactory(new PropertyValueFactory<JSONbean, String>("rep1"));
				
				TableColumn<JSONbean, String> rep2Col = new TableColumn<JSONbean, String>("REP2");
				rep2Col.setCellValueFactory(new PropertyValueFactory<JSONbean, String>("rep2"));
				
				TableColumn<JSONbean, String> itemCol = new TableColumn<JSONbean, String>("ITEM");
				itemCol.setCellValueFactory(new PropertyValueFactory<JSONbean, String>("item"));
				
				TableColumn<JSONbean, Integer> unitsCol = new TableColumn<JSONbean, Integer>("UNITS");
				unitsCol.setCellValueFactory(new PropertyValueFactory<JSONbean, Integer>("units"));
				
				TableColumn<JSONbean, String> unitCostCol = new TableColumn<JSONbean, String>("UNITCOST");
				unitCostCol.setCellValueFactory(new PropertyValueFactory<JSONbean, String>("unitCost"));
				
				TableColumn<JSONbean, String> totalCol = new TableColumn<JSONbean, String>("TOTAL");
				totalCol.setCellValueFactory(new PropertyValueFactory<JSONbean, String>("total"));
				
				table.getColumns().add(orderDateCol);
				table.getColumns().add(regionCol);
				table.getColumns().add(rep1Col);
				table.getColumns().add(rep2Col);
				table.getColumns().add(itemCol);
				table.getColumns().add(unitsCol);
				table.getColumns().add(unitCostCol);
				table.getColumns().add(totalCol);
				
				table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				
				
//Reading and appending sample.csv and removes the header
				for(int i=1; i<= jsonr.getOrderDate().size()-1; i++) {
					int unitsInt = Integer.parseInt(csvr.getUnits().get(i));
					
				table.getItems().add(new JSONbean(
						jsonr.getOrderDate().get(i),
						jsonr.getRegion().get(i), 
						jsonr.getRep1().get(i), 
						jsonr.getRep2().get(i),
						jsonr.getItem().get(i),
						unitsInt,
						jsonr.getUnitCost().get(i),
						jsonr.getTotal().get(i)));
				}
			
				root.setCenter(table);
				
				Scene scene = new Scene(root, 800, 800);
				primaryStage.setTitle("TableView JSON");
				primaryStage.setScene(scene);
				primaryStage.show();
				
			}
		};
		
		b2.setLayoutX(100);
		
		b1.setOnAction(event1);
		b2.setOnAction(event2);
		
		
//"Appearance" GUI 
		primaryStage.setTitle("Objectification");
		Group root = new Group();
		Scene scene = new Scene (root, 500, 400);
		primaryStage.setScene(scene);
		
//Printing buttons
		root.getChildren().add(b1);
		root.getChildren().add(b2);
		
		primaryStage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
    	
	
	public static void main(String[] args) throws IOException{ 
		launch(args);
        }  
	
}