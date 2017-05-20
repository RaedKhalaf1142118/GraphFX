package algorithmProject4;

import java.util.ArrayList;

public class Graph {
	private ArrayList<VertexFX> vertexFXs = new ArrayList<>();
	private ArrayList<EdgeFX> edgeFXs = new ArrayList<>();

	public Graph(ArrayList<VertexFX> vertexFXs, ArrayList<EdgeFX> edgeFXs) {
		super();
		this.vertexFXs = vertexFXs;
		this.edgeFXs = edgeFXs;
	}

	public ArrayList<VertexFX> getVertexFXs() {
		return vertexFXs;
	}

	public void setVertexFXs(ArrayList<VertexFX> vertexFXs) {
		this.vertexFXs = vertexFXs;
	}

	public ArrayList<EdgeFX> getEdgeFXs() {
		return edgeFXs;
	}

	public void setEdgeFXs(ArrayList<EdgeFX> edgeFXs) {
		this.edgeFXs = edgeFXs;
	}

}
