package view;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entityDB.Department;
import entityDB.Lecture;
import valueObject.DepartmentInfo;
import valueObject.LectureInfo;
import valueObject.UserInfo;



public class SugangPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Department departmentDB;
	private Lecture lectureDB;
	private UserInfo userInfo;



	private JButton btnDepartment;
	private JButton btnLecture;
	private JButton btnBefore;
	private JButton btnInput;
	private JButton btnCancel;
	private JButton btnOK;
	private JLabel Login;

	private JList<String> textDepartmentLabel;
	private JList<String> textLectureLabel;
	public JList<String> textBasketLabel;
	private JLabel textNameLabel;
	private JLabel imgLabel;

	private JScrollPane DscrollPane;
	private JScrollPane LscrollPane;
	private JScrollPane BscrollPane;
	private DefaultListModel<String> departmentInfoModel = new DefaultListModel<String>();
	private DefaultListModel<String> BasketModel = new DefaultListModel<String>();
	private DefaultListModel<String> SugangModel = new DefaultListModel<String>();;
	

	private Vector<DepartmentInfo> departmentInfoVector;

	private DefaultListModel<String> lectureInfoModel = new DefaultListModel<String>();
	private Vector<LectureInfo> lectureInfoVector;
	

	public SugangPanel(JFrame frame,UserInfo userInfo,DefaultListModel<String> sugangModels) {
		this.setLayout(null);
		this.frame = frame;
		this.userInfo = userInfo;
		this.SugangModel = sugangModels;
		
		new SugangSelectionPanel();
		this.add(Login);
		this.add(btnDepartment);
		this.add(btnLecture);
		this.add(LscrollPane);
		this.add(DscrollPane);
		this.add(btnBefore);
		this.add(BscrollPane);
		this.add(btnInput);
		this.add(textNameLabel);
		this.add(btnCancel);
		this.add(btnOK);
		this.add(imgLabel);

	}
	

	private class SugangSelectionPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public SugangSelectionPanel() {
			JListHandler handler = new JListHandler();
			
			imgLabel = new JLabel();
			ImageIcon icon = new ImageIcon("연필.JPG");
			imgLabel.setIcon(icon);
			imgLabel.setBounds(0, 0,400,600);
			
			
			btnDepartment = new JButton("학과목록");
			btnDepartment.setBounds(37, 96, 125, 29);
			btnDepartment.setBackground(Color.white);
			btnDepartment.addActionListener(new BasketListener());

			btnLecture = new JButton("개설강좌");
			btnLecture.setBounds(225, 97, 125, 29);
			btnLecture.setBackground(Color.white);

			btnBefore = new JButton("이전");
			btnBefore.addActionListener(new BeforeListener());
			btnBefore.setBounds(252, 0, 125, 29);
			btnBefore.setBackground(Color.white);

			btnCancel = new JButton("Delete");
			btnCancel.setBounds(210, 350, 100, 29);
			btnCancel.addActionListener(new BasketListener());

			Login = new JLabel("아이디: " + userInfo.getId());
			Login.setBounds(134, 43, 143, 21);
			
			btnOK = new JButton("신청");
			btnOK.setBounds(140, 500, 100, 29);
			btnOK.addActionListener(new BasketListener());

			btnInput = new JButton("Add");
			btnInput.setBounds(70, 350, 100, 29);
			btnInput.addActionListener(new BasketListener());

			textDepartmentLabel = new JList<String>(departmentInfoModel);
			DscrollPane = new JScrollPane(textDepartmentLabel);
			DscrollPane.setBounds(34, 148, 119, 195);
			textDepartmentLabel.addListSelectionListener(handler);

			textLectureLabel = new JList<String>(lectureInfoModel);
			LscrollPane = new JScrollPane(textLectureLabel);
			LscrollPane.setBounds(231, 146, 119, 197);

			textBasketLabel = new JList<String>(BasketModel);
			BscrollPane = new JScrollPane(textBasketLabel);
			BscrollPane.setBounds(60, 401, 276, 84);

			textNameLabel = new JLabel("장바구니");
			textNameLabel.setBounds(60, 380, 78, 21);


		}

		private class BeforeListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals(btnBefore.getText())) {
					BasePanel basePanel = new BasePanel(frame, userInfo,SugangModel);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(basePanel);
					frame.paintComponents(frame.getGraphics());

				}

			}

		}

		public void setDepartmentListData() {
			departmentDB = new Department();
			try {
				departmentInfoVector = departmentDB.getList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (int i = 0; i < departmentInfoVector.size(); i++) {
				departmentInfoModel.addElement(departmentInfoVector.get(i).getId() + " "+ departmentInfoVector.get(i).getName());

			}

		}

		public void setLectureListData(String departmentID) {
			lectureDB = new Lecture();
			try {
				lectureInfoVector = lectureDB.getList(departmentID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (int j = 0; j < lectureInfoVector.size(); j++) {
				if (lectureInfoVector.get(j).getDepartmentID().equals(departmentID))
					lectureInfoModel
							.addElement(lectureInfoVector.get(j).getId() + " " + lectureInfoVector.get(j).getName());
			}

		}

		private class JListHandler implements ListSelectionListener {

			@SuppressWarnings("unchecked")
			public void valueChanged(ListSelectionEvent e) {

				textDepartmentLabel = (JList<String>) e.getSource();
				textDepartmentLabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String departmentID = (String) textDepartmentLabel.getSelectedValue();
				String[] split = departmentID.split(" ");
				lectureInfoModel.removeAllElements();
				setLectureListData(split[0]);

			}

		}

		private class BasketListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals(btnInput.getText())) {
					BasketModel.addElement((String) textLectureLabel.getSelectedValue());
					textBasketLabel.setModel(BasketModel);

					JOptionPane.showMessageDialog(null, "담기 성공");

				}  if (e.getActionCommand().equals(btnCancel.getText())) {
					BasketModel.removeElement((String) textBasketLabel.getSelectedValue());
					textBasketLabel.setModel(BasketModel);

					JOptionPane.showMessageDialog(null, "삭제 성공");
				}  
					if (e.getActionCommand().equals(btnOK.getText())) {
					if(SugangModel == null){
					SugangModel = new DefaultListModel<String>();
					}
			
					SugangModel.addElement((String) textBasketLabel.getSelectedValue());
					JOptionPane.showMessageDialog(null, "신청 성공");
					
				} else if (e.getActionCommand().equals(btnDepartment.getText())) {
					setDepartmentListData();
				}

			}

		}
	
	
	}



}
