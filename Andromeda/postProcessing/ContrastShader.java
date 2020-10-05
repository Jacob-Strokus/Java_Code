package postProcessing;

import shaders.Shader;

public class ContrastShader extends Shader {

	private static final String VERTEX_FILE = "src/postProcessing/contrastVertexShader.txt";
	private static final String FRAGMENT_FILE = "src/postProcessing/contrastFragmentShader.txt";

	public ContrastShader() {
		super(VERTEX_FILE, FRAGMENT_FILE, null);
	}

	@Override
	protected void getAllUniformLocations() {
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}

}
