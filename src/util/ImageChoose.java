package util;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;

public class ImageChoose {

	private String URI;
	
	public ImageChoose(){
		setURI(".");
	}
	
	public ImageChoose(String uri){
		setURI(uri);
	}
	
	public File getImage(){

		JFileChooser jfc = new JFileChooser(new File(URI));
		jfc.setFileFilter(new MyFileFilter());
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showOpenDialog(null);
		File file = jfc.getSelectedFile();
		return file;
		
	}
	
	public String getURI() {
		return URI;
	}
	public void setURI(String uRI) {
		URI = uRI;
	}
	
	
}
