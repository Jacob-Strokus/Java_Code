package particles;

public class ParticleTexture {

	private int textureID;
	private int numberOfRows;
	private boolean additive;

	public ParticleTexture(boolean additive, int textureID, int numberOfRows) {
		this.textureID = textureID;
		this.numberOfRows = numberOfRows;
		this.additive = additive;
	}

	protected int getTextureID() {
		return textureID;
	}

	protected int getNumberOfRows() {
		return numberOfRows;
	}

	public boolean isAdditiveBlending() {
		return additive;
	}

}
