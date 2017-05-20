package algorithmProject4;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VertexFX extends StackPane {
	private String data;
	private double x;
	private double y;

	public VertexFX(String data, double x, double y) {
		super();
		this.data = data;
		this.x = x+12.5;
		this.y = y+12.5;

		/* Create FX */	
		{
			Circle circle = new Circle(x, y, 25);
			circle.setFill(Color.LIGHTCYAN);
			Label label = new Label(data);
			setAlignment(Pos.CENTER);
			getChildren().addAll(circle, label);
			setTranslateX(x);
			setTranslateY(y);			
		}
		/* End FX */
	
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
