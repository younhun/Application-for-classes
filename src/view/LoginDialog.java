package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valueObject.UserInfo;

public class LoginDialog extends JDialog {
	// attributes 연관성 그냥 일을 아는 사람
	private static final long serialVersionUID = 1L;
	private boolean bLoginOK = false;
	private UserInfo userInfo = new UserInfo();
	// components
	private LoginPanel loginPanel;

	// getter & setter
	public boolean isLoginOK() {
		return this.bLoginOK;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	// constructor
	public LoginDialog(JFrame parent) {
		super(parent, "Login", true);
		// attributes
		this.setLocation(700,300);
		// components
		this.loginPanel = new LoginPanel(parent);
		this.getContentPane().add(this.loginPanel, BorderLayout.CENTER);
		// associations
	}

	public void login() throws Exception {
		bLoginOK = true;
		userInfo.setId(this.loginPanel.tfUserName.getText());
		userInfo.setPassword(this.loginPanel.tfPassword.getText());
		this.dispose();
	}

	private void cancel() {
		this.dispose();

	}

	public class LoginPanel extends JPanel {

		private static final long serialVersionUID = 1L;
		// components
		private JLabel lbUserName;
		private JTextField tfUserName;
		private JLabel lbPassword;
		private JTextField tfPassword;
		private JButton btnOK;
		private JButton btnCancel;

		public LoginPanel(JFrame parent) {
			lbUserName = new JLabel("UserName: ");
			this.add(lbUserName);
			tfUserName = new JTextField(10);
			this.add(tfUserName);
			lbPassword = new JLabel("Password: ");
			this.add(lbPassword);
			tfPassword = new JTextField(10);
			this.add(tfPassword);
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ButtonListener());
			btnOK.setActionCommand(btnOK.getText());
			this.add(btnOK);
			btnCancel = new JButton("Cancel");
			btnCancel.setActionCommand(btnCancel.getText());
			btnCancel.addActionListener(new ButtonListener());
			this.add(btnCancel);

			btnOK.setBackground(Color.white);
			btnOK.setBorderPainted(false);

			btnCancel.setBackground(Color.white);
			btnCancel.setBorderPainted(false);

			this.setBackground(Color.orange);

		}

		private class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent event) {
				try {
					if (event.getActionCommand().equals(btnOK.getText())) {
						login();

					} else
						cancel();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
}
