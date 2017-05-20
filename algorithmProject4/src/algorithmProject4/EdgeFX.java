package algorithmProject4;

import javafx.scene.shape.Line;

public class EdgeFX extends Line {
	private VertexFX source;
	private VertexFX destination;

	public EdgeFX(VertexFX source, VertexFX destination) {
		super();
		this.source = source;
		this.destination = destination;

		/* FX */
		setStartX(source.getX());
		setStartY(source.getY());
		setEndX(destination.getX());
		setEndY(destination.getY());
	}

	public VertexFX getSource() {
		return source;
	}

	public void setSource(VertexFX source) {
		this.source = source;
	}

	public VertexFX getDestination() {
		return destination;
	}

	public void setDestination(VertexFX destination) {
		this.destination = destination;
	}

}
