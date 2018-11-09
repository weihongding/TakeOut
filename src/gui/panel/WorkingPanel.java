package gui.panel;
 
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public abstract class WorkingPanel  extends JPanel{
	/**
	 * 更新页面
	 */
    public abstract void updateData();
    /**
     * 对页面下的按钮进行监听
     */
    public abstract void addListener();
    
	public void hmz(){
		JTextField hmz = new JTextField("这个页面还没做");
		add(hmz);
	}
}