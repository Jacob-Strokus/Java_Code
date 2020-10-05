package models;

import textures.ModelTexture;

public class TexturedModels {

	private RawModel rawModel;
	private ModelTexture texture;

	public TexturedModels(RawModel raw, ModelTexture t) {

		this.rawModel = raw;
		this.texture = t;

	}

	public RawModel getRawModel() {
		return rawModel;
	}

	public ModelTexture getTexture() {
		return texture;
	}

}
