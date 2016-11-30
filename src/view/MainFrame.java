package view;


import javax.swing.JFrame;

import control.AuthenticationManager.EAutheticationState;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private EAutheticationState result;

	public MainFrame() {
		super("LMS");// 부모클라스 초기화
		// attribute
		// 속성을 정함 => 해당 클래스를 위해서만 존재
		this.setLocation(700,300);
		this.setSize(380, 580);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// 다른 오브잭트를 만들어서 연결 시킨 것 자식을 만듬, 구성
		// 부모가 생성 소멸을 관리한다.
		// component
		InitPanel initPanew = new InitPanel(this);
		this.getContentPane().add(initPanew);
		
	}

}
