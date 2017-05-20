package algorithmProject4;

import java.util.ArrayList;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Content extends BorderPane {
	private Stage window;
	private Pane drawField;
	private ArrayList<VertexFX> vertexs = new ArrayList<>();
	private ArrayList<EdgeFX> edges = new ArrayList<>();
	private VertexFX source, destination;
	private Graph graph;

	public Content(Stage window) {
		this.window = window;
		createBackground();
		createDrawField();
		createButtons();
	}

	private void createBackground() {
		BackgroundFill color = new BackgroundFill(Color.LIGHTGRAY, null, null);
		Background background = new Background(color);
		setBackground(background);
	}

	private void createButtons() {
		VBox box = new VBox(30);

		/* Start -> Create Buttons */
		StackPane addVertex = createButton("Create Vertex");
		StackPane addEdge = createButton("Add Edge");
		StackPane translateGraph = createButton("Translate Graph");
		StackPane exit = createButton("Exit");
		// add to vertical Box
		box.getChildren().addAll(addVertex, addEdge, translateGraph, exit);
		/* End => create Buttons */

		/* Start -> set functionality */
		addVertex.setOnMouseClicked(e -> {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Add new Vertex");
			dialog.setHeaderText("Insert Vertex Data");
			dialog.setContentText("Please Enter Data");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				new Alert(AlertType.INFORMATION, "Click on the draw Field").showAndWait();
				this.drawField.setOnMouseClicked(e2 -> {
					VertexFX vertexFX = new VertexFX(result.get(), e2.getX(), e2.getY());
					vertexFX.setOnMouseClicked(e5 -> {
						this.destination = this.source;
						this.source = vertexFX;
					});
					this.vertexs.add(vertexFX);
					this.drawField.getChildren().add(vertexFX);
					this.drawField.setOnMouseClicked(null);
				});
			}
		});

		addEdge.setOnMouseClicked(e -> {
			new Alert(AlertType.INFORMATION, "choose the source Vertex").showAndWait();
			this.drawField.setOnMouseClicked(e2 -> {
				new Alert(AlertType.INFORMATION, "choose the destination Vertex").showAndWait();
				this.drawField.setOnMouseClicked(e3 -> {
					EdgeFX edgeFX = new EdgeFX(this.source, this.destination);
					this.edges.add(edgeFX);
					this.drawField.getChildren().add(edgeFX);
				});
			});
		});

		translateGraph.setOnMouseClicked(e -> {
			this.graph = new Graph(this.vertexs, this.edges);
			new Alert(AlertType.INFORMATION,"DONE!!").showAndWait();
		});

		exit.setOnMouseClicked(e -> {
			this.window.close();
		});
		/* End -> set functionality */

		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(0, 0, 0, 50));
		setLeft(box);
	}

	private StackPane createButton(String title) {
		StackPane root = new StackPane();

		Rectangle rect = new Rectangle(100, 50, Color.web("#666699"));
		Label label = new Label(title);

		rect.setStroke(Color.BLACK);

		root.setOnMouseEntered(e -> {
			window.getScene().setCursor(Cursor.HAND);
			rect.setFill(Color.web("#556633"));
		});

		root.setOnMouseExited(e -> {
			window.getScene().setCursor(Cursor.DEFAULT);
			rect.setFill(Color.web("#666699"));
		});

		root.getChildren().addAll(rect, label);

		root.setAlignment(Pos.CENTER);
		return root;
	}

	private void createDrawField() {
		drawField = new Pane();
		drawField.setMinSize(1000, 600);
		setCenter(drawField);
	}

}
