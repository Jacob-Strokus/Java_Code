package gaussianBlur;

import shaders.Shader;

public class HorizontalBlurShader extends Shader{

	private static final String VERTEX_FILE = "src/gaussianBlur/horizontalBlurVertexShader.txt";
    private static final String FRAGMENT_FILE = "src/gaussianBlur/blurFragment.txt";
     
    private int location_targetWidth;
     
    protected HorizontalBlurShader() {
        super(VERTEX_FILE, FRAGMENT_FILE, null);
    }
 
    protected void loadTargetWidth(float width){
        super.loadFloat(location_targetWidth, width);
    }
     
    @Override
    protected void getAllUniformLocations() {
        location_targetWidth = super.getUniformLocation("targetWidth");
    }
 
    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
