package view;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import valueObject.UserInfo;

public class BasePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;
	private JFrame frame;
	private JLabel imgLabel;
	private JLabel Login;
	private JButton btnRequest;
	private JButton btnLogout;
	private JButton btnList;
	private DefaultListModel<String> SugangModel;

	public BasePanel(JFrame frame, UserInfo userInfo) {
		this.setLayout(null);
		this.SugangModel = null;
		this.frame = frame;
		this.userInfo = userInfo;
		new BaseSelectionPanel();
		
		this.add(Login);
		this.add(btnLogout);
		this.add(btnRequest);
		this.add(btnList);
		this.add(imgLabel);
		
	


	}
	
	public BasePanel(JFrame frame, UserInfo userinfo,DefaultListModel<String> sugangModels) {
		this.setLayout(null);
		this.SugangModel = sugangModels;
		this.frame = frame;
		this.userInfo = userinfo;
		
		new BaseSelectionPanel();
		
		this.add(Login);
		this.add(btnLogout);
		this.add(btnRequest);
		this.add(btnList);
		this.add(imgLabel);
	

	}

	private class BaseSelectionPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public BaseSelectionPanel() {
			
			imgLabel = new JLabel();
			ImageIcon icon = new ImageIcon("연필.JPG");
			imgLabel.setIcon(icon);
			imgLabel.setBounds(0, 0,400,600);
			
			btnRequest = new JButton("수강신청");
			btnRequest.addActionListener(new ButtonListener());
			btnRequest.setBounds(41, 124, 125, 64);
			btnRequest.setBackground(Color.white);

			btnList = new JButton("조회");
			btnList.addActionListener(new ButtonListener());
			btnList.setBounds(221, 124, 125, 64);
			btnList.setBackground(Color.white);
			
			btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ButtonListener());
			btnLogout.setBackground(Color.white);
			btnLogout.setBounds(252, 0, 125, 29);
			
			Login = new JLabel("아이디 : " + userInfo.getId());
			Login.setBounds(134, 43, 143, 21);

		}

		private class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals(btnRequest.getText())) {// 수강신청창
				if (SugangModel == null) {
					SugangPanel sugangPanel = new SugangPanel(frame,userInfo,null);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(sugangPanel);
					frame.paintComponents(frame.getGraphics());
					}
				else {
					SugangPanel sugangPanel = new SugangPanel(frame,userInfo,SugangModel);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(sugangPanel);
					frame.paintComponents(frame.getGraphics());
					}
				} else if (e.getActionCommand().equals(btnLogout.getText())) {
					frame.dispose();
					MainFrame mainFrame = new MainFrame();
					mainFrame.setVisible(true);
				}else if (e.getActionCommand().equals(btnList.getText())){
					if (SugangModel != null) {
						ListPanel listPanel = new ListPanel(frame, userInfo, SugangModel);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(listPanel);
						frame.paintComponents(frame.getGraphics());
				}

			}
		}

	}
	}

//	private class PersonalInfoPanel extends JPanel {
//
//		private static final long serialVersionUID = 1L;
//		public PersonalInfoPanel(UserInfo userInfo) {
//			JLabel lbUser = new JLabel("@" + userInfo.getId() + "@님 반갑습니다");
//			lbUser.setBounds(97, 45, 242, 46);
//			lbUser.setBackground(Color.white);
//			this.add(lbUser);
//
//		}
//	}
}