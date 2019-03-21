package cn.qingyun.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame{

	private String[] items={"СŮ��","Ů����"};
	private JRadioButton addNumInfo;
	private PictureCanvsa canvsa;
	private JRadioButton clearNum;
	private JComboBox comboBox;
	private PicturePreview preview;
	private JTextField statu;
	private JButton start;
	public static JTextField step;
	public MainFrame(){
		initMainFrame();
		
		addCompnent();
		
		addPicture();
		
		addListener();
	}

	
	private void addListener() {
		addNumInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			     canvsa.reloadAddNumInfo();
			}
		});
		
		clearNum.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    canvsa.reloadAddClearInfo();
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			   int num = comboBox.getSelectedIndex();
			   canvsa.pictureId = num + 1;
			   canvsa.reloadAddClearInfo();
			   preview.repaint();
			   statu.setText("ͼƬ���ƣ�"+comboBox.getSelectedItem());
			   canvsa.stepNum = 0;
			   clearNum.setSelected(true);
			}
		});
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvsa.stepNum = 0;
				step.setText("������"+canvsa.stepNum);
				clearNum.setSelected(true);
			    canvsa.start();
			}
		});
	}


	private void addPicture() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		preview = new PicturePreview();
		canvsa = new PictureCanvsa();
		preview.setBorder(new TitledBorder("Ԥ����"));
		canvsa.setBorder(new TitledBorder("ƴͼ��"));
		panel.add(canvsa,BorderLayout.WEST);
		panel.add(preview,BorderLayout.EAST);
		
		this.add(panel,BorderLayout.CENTER);
	}


	private void addCompnent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));

		
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder("��ť��"));
		leftPanel.setBackground(Color.pink);
		addNumInfo = new JRadioButton("�����ʾ",false);
		clearNum = new JRadioButton("�����ʾ",true);
		addNumInfo.setBackground(Color.pink);
		clearNum.setBackground(Color.pink);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(addNumInfo);
		buttonGroup.add(clearNum);
		JLabel label = new JLabel("                      ѡ��ͼƬ��");
		comboBox = new JComboBox(items);
		start = new JButton("start");
	
		leftPanel.add(addNumInfo);
		leftPanel.add(clearNum);
		leftPanel.add(label);
		leftPanel.add(comboBox);
		leftPanel.add(start);
		
		panel.add(leftPanel,BorderLayout.WEST);
		
		
		
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(1, 2));
		rightPanel.setBorder(new TitledBorder("��Ϸ״̬��"));
		rightPanel.setBackground(Color.pink);
		statu = new JTextField();
		statu.setText("ͼƬ���ƣ�СŮ��");
		step = new JTextField();
		step.setText("����:0");
		statu.setEditable(false);
		step.setEditable(false);
	    rightPanel.add(statu,BorderLayout.WEST);
	    rightPanel.add(step,BorderLayout.EAST);
	    
		panel.add(rightPanel,BorderLayout.EAST);
		
		
		this.add(panel,BorderLayout.NORTH);
	}


	private void initMainFrame() {
		this.setTitle("ƴͼ��Ϸ");
		this.setBounds(100, 10, 1000, 720);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
