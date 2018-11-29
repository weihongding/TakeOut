package util;
import java.io.File;

public class MyFileFilter extends javax.swing.filechooser.FileFilter{

	@Override
	public boolean accept(File file) {
		if(file.getName().endsWith("png")||file.getName().endsWith("jpg")){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String getDescription() {
		return "*.png/*.jpg";
	}

}
