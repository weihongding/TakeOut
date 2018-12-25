package start;

import gui.FrameMain.LoginFrame;

public class Demo {

	public static void main(String[] args) {
		LoginFrame.instance = new LoginFrame();
		LoginFrame.instance.setVisible(true);
	}

}
