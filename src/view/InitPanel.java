package view;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.AuthenticationManager;
import control.AuthenticationManager.EAutheticationState;
import valueObject.UserInfo;

public class InitPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// attribute
	private EAutheticationState authenticationState = null;
	private JFrame frame;
	private JLabel imgLabel;
	// associations
	private AuthenticationManager authenticationManager;

	public InitPanel(JFrame frame) {
		this.setLayout(null);

		this.frame = frame;
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new LoginListener());
		buttonLogin.setBackground(Color.white);
		buttonLogin.setFont(new Font("궁서", Font.ITALIC, 15));
		buttonLogin.setBounds(210, 200, 130, 140);
		this.add(buttonLogin);
		imgLabel = new JLabel();
		ImageIcon icon = new ImageIcon("이미지.png");
		imgLabel.setIcon(icon);
		imgLabel.setBounds(3, 0, 500, 560);
		this.add(imgLabel);
		// association
		authenticationManager = new AuthenticationManager();

	}

	private void authenticate(UserInfo userInfo) {
		try {
			authenticationState = authenticationManager.authenticate(userInfo);

			if (authenticationState == EAutheticationState.authenticated) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
				BasePanel basePanel = new BasePanel(frame, userInfo);
				this.frame.getContentPane().removeAll();
				this.frame.getContentPane().add(basePanel);
				this.frame.paintComponents(this.frame.getGraphics());
			} else
				JOptionPane.showMessageDialog(null, "로그인 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LoginDialog loginDialog = new LoginDialog(frame);
			loginDialog.setSize(250, 150);
			loginDialog.setVisible(true);
			if (loginDialog.isLoginOK()) {
				authenticate(loginDialog.getUserInfo());
			}
		}
	}

}
