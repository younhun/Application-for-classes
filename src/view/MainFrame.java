package view;


import javax.swing.JFrame;

import control.AuthenticationManager.EAutheticationState;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private EAutheticationState result;

	public MainFrame() {
		super("LMS");// �θ�Ŭ�� �ʱ�ȭ
		// attribute
		// �Ӽ��� ���� => �ش� Ŭ������ ���ؼ��� ����
		this.setLocation(700,300);
		this.setSize(380, 580);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// �ٸ� ������Ʈ�� ���� ���� ��Ų �� �ڽ��� ����, ����
		// �θ� ���� �Ҹ��� �����Ѵ�.
		// component
		InitPanel initPanew = new InitPanel(this);
		this.getContentPane().add(initPanew);
		
	}

}
