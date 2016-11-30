package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import valueObject.UserInfo;

public class ListPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;
	private JFrame frame;
	private JLabel imgLabel;
	private JLabel list;
	private JLabel Login;
	private DefaultListModel<String> SugangModel;
	private JButton btnBefore;
	private JList<String> addList;
	private JScrollPane AscrollPane;
	private JButton btnDelete;

	public ListPanel(JFrame frame, UserInfo userInfo, DefaultListModel<String> sugangModels) {
		this.setLayout(null);

		this.frame = frame;
		this.userInfo = userInfo;
		this.SugangModel = sugangModels;

		new ListSelectionPanel();
		this.add(Login);
		this.add(list);
		this.add(btnBefore);
		this.add(AscrollPane);
		this.add(btnDelete);
		this.add(imgLabel);

	}

	private class ListSelectionPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public ListSelectionPanel() {

			list = new JLabel("������û ���");
			list.setBounds(75, 62, 90, 50);

			btnBefore = new JButton("����");
			btnBefore.addActionListener(new BeforeListener());
			btnBefore.setBounds(252, 0, 125, 29);

			imgLabel = new JLabel();
			ImageIcon icon = new ImageIcon("����.JPG");
			imgLabel.setIcon(icon);
			imgLabel.setBounds(0, 0, 400, 600);

			addList = new JList<String>(SugangModel);
			AscrollPane = new JScrollPane(addList);
			AscrollPane.setBounds(50, 110, 150, 200);

			Login = new JLabel("���̵� : " + userInfo.getId());
			Login.setBounds(134, 43, 143, 21);

			btnDelete = new JButton("����");
			btnDelete.setBounds(210, 350, 100, 29);
			btnDelete.addActionListener(new BeforeListener());

		}

		private class BeforeListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals(btnBefore.getText())) {
					BasePanel basePanel = new BasePanel(frame, userInfo, SugangModel);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(basePanel);
					frame.paintComponents(frame.getGraphics());
				} else if (e.getActionCommand().equals(btnDelete.getText())) {
					SugangModel.removeElement(addList.getSelectedValue());
					JOptionPane.showMessageDialog(null, "���� ����");
				}

			}

		}

	}

}
