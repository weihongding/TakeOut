package gui.panel;
 
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public abstract class WorkingPanel  extends JPanel{
	/**
	 * ����ҳ��
	 */
    public abstract void updateData();
    /**
     * ��ҳ���µİ�ť���м���
     */
    public abstract void addListener();
    
	public void hmz(){
		JTextField hmz = new JTextField("���ҳ�滹û��");
		add(hmz);
	}
}