package models;

public class RawModel {

	private int vaoID;
	private int vertexCount;

	public RawModel(int id, int vCount) {
		this.vaoID = id;
		this.vertexCount = vCount;
	}

	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
}
