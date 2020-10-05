package gui;

import org.lwjgl.util.vector.Matrix4f;

import shaders.Shader;

public class GuiShader extends Shader {

	private static final String VERTEX_FILE = "src/gui/guiVertexShader.txt";
    private static final String FRAGMENT_FILE = "src/gui/guiFragmentShader.txt";
     
    private int location_transformationMatrix;
 
    public GuiShader() {
        super(VERTEX_FILE, FRAGMENT_FILE, null);
    }
     
    public void loadTransformation(Matrix4f matrix){
        super.loadMatrix(location_transformationMatrix, matrix);
    }
 
    @Override
    protected void getAllUniformLocations() {
        location_transformationMatrix = super.getUniformLocation("transformationMatrix");
    }
 
    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
	
}