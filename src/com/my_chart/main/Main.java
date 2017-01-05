package com.my_chart.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("TEST_01");
		jFrame.setSize(700, 400);
		
		JPanel jp = new JPanel();
		jp.setBounds(150,100,400,30);
		jp.setLayout(new FlowLayout());
		
		JLabel jLab01 = new JLabel("用户名：");
		JTextField jTf01 = new JTextField(10);
		jp.add(jLab01);
		jp.add(jTf01);
		
		
		JPanel jp01 = new JPanel(new FlowLayout());
		jp01.setBounds(150, 150, 400,30);
		JLabel jLab02 = new JLabel("密    码：");
		JPasswordField jPf = new JPasswordField(10);
		jp01.add(jLab02);
		jp01.add(jPf);
		
		JPanel jp02 = new JPanel(new FlowLayout());
		jp02.setBounds(310, 200 , 100, 30);
		JButton jBtn = new JButton("登陆");
		jBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
				JFrame f = new JFrame("index");
				f.setSize(800, 600);
				f.setVisible(true);
				
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JPanel jp03 = new JPanel();
				//jp03.setBounds(0,0, 0, 0);

				JTextArea jta = new JTextArea(">>>>>");
				jta.setEditable(false);
				
				
				jp03.add(jta);
				
				f.add(jp03);
				f.setBackground(Color.BLACK);
				
			}
		});
		jp02.add(jBtn);

		jFrame.add(jp);
		jFrame.add(jp01);
		jFrame.add(jp02);
		
		jFrame.setLayout(null);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
