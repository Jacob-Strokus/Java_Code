package gaussianBlur;

import shaders.Shader;

public class VerticalBlurShader extends Shader{

	private static final String VERTEX_FILE = "src/gaussianBlur/verticalBlurVertexShader.txt";
    private static final String FRAGMENT_FILE = "src/gaussianBlur/blurFragment.txt";
     
    private int location_targetHeight;
     
    protected VerticalBlurShader() {
        super(VERTEX_FILE, FRAGMENT_FILE, null);
    }
     
    protected void loadTargetHeight(float height){
        super.loadFloat(location_targetHeight, height);
    }
 
    @Override
    protected void getAllUniformLocations() {   
        location_targetHeight = super.getUniformLocation("targetHeight");
    }
 
    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
