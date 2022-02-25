package rms;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
//import javax.swing.UIManager;
//import javax.swing.SwingConstants;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
import javax.swing.DropMode;

public class ResultManagementSystem {

	private JFrame frmResultManagementSystem;
	private JTextField s1;
	private JTextField s2;
	private JTextField s3;
	private JTextField ltr;
	private JTextField cgpa;
	private JTextField sn;
	private JTextField sid;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	
	double sub1;
	double sub2;
	double sub3;
	double answer;
	double cg;
	String lg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultManagementSystem window = new ResultManagementSystem();
					window.frmResultManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultManagementSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResultManagementSystem = new JFrame();
		frmResultManagementSystem.setResizable(false);
		frmResultManagementSystem.setAlwaysOnTop(true);
		frmResultManagementSystem.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\rESULT.png"));
		frmResultManagementSystem.setTitle("Result Management System");
		frmResultManagementSystem.setBounds(100, 100, 760, 516);
		frmResultManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(687, 407, 46, 50);
		lblNewLabel.setIcon(new ImageIcon("E:\\wd.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Made by Md Kamruzzaman Shishir");
		lblNewLabel_1.setBounds(519, 462, 214, 14);
		
		JButton calc = new JButton("Calculate");
		calc.setBounds(103, 304, 144, 36);
		calc.setForeground(Color.BLUE);
		calc.setIcon(new ImageIcon("E:\\cal.jpg"));
		calc.setFont(new Font("Tahoma", Font.BOLD, 15));
		calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String sb1= s1.getText();
				double sub1 = Double.parseDouble(sb1); 
				
				String sb2= s2.getText();
				double sub2 = Double.parseDouble(sb2); 
				
				String sb3= s3.getText();
				double sub3 = Double.parseDouble(sb3); 
	
				if(sub1<40||sub2<40||sub3<40) {
					ltr.setText("F");
					double answer=0.00;
					String res =String.format("%.2f", answer);
					cgpa.setText(res);
				}
				else if(sub1>100||sub2>100||sub3>100) {
						ltr.setText(" Owerflow ");
						cgpa.setText(" OverFlow ");
				}
				else {
					
					double cg=((sub1+sub2+sub3)/3);
					double answer=(4*(cg/100));
					String res =String.format("%.2f", answer);
					
					
					if(cg>=40.00&&cg<=44.00){
						ltr.setText("D");
					}
					else if(cg>=45.00&&cg<=49.00){
						ltr.setText("C minus");
					}
					else if(cg>=50.00&&cg<=54.00){
						ltr.setText("C");
					}
					else if(cg>=55.00&&cg<=59.00){
						ltr.setText("B Minus");
					}
					else if(cg>=60.00&&cg<=64.00){
						ltr.setText("B");
					}
					else if(cg>=65.00&&cg<=69.00){
						ltr.setText("B Plus");
					}
					else if(cg>=70.00&&cg<=74.00){
						ltr.setText("A Minus");
					}
					else if(cg>=75.00&&cg<=79.00){
						ltr.setText("A");
					}
					else if(cg>=80.00&&cg<=100.00){
						ltr.setText("A Plus");
					}
					
					cgpa.setText(res);
				}
				
			}
		});
		calc.setBackground(new Color(240, 240, 240));
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				try{
					File file = new File("Saved Result.txt");
		            FileWriter fw = new FileWriter(file.getAbsoluteFile());
		            BufferedWriter bw = new BufferedWriter(fw);
		            String content = "Name: "+sn.getText() +" ID: " + sid.getText() + " Subject 1: " + s1.getText() + " Subject 2:  " + s2.getText() + " Subject 3: " + s3.getText() + " Letter: " + ltr.getText() + " CGPA:  " + cgpa.getText();
		            bw.write(content);
		            bw.close();
		            
		            } catch (Exception ex){ex.printStackTrace();}
			   
			}
		});
		save.setBounds(338, 304, 109, 36);
		save.setForeground(Color.GREEN);
		save.setIcon(new ImageIcon("E:\\save.png"));
		save.setFont(new Font("Tahoma", Font.BOLD, 15));
		save.setBackground(new Color(240, 240, 240));
		
		JButton clrbtn = new JButton("Clear");
		clrbtn.setBounds(572, 304, 109, 36);
		clrbtn.setIcon(new ImageIcon("E:\\cas.jpg"));
		clrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sn.setText(null);
				sid.setText(null);
				s1.setText(null);
				s2.setText(null);
				s3.setText(null);
				ltr.setText(null);
				cgpa.setText(null);
			}
		});
		clrbtn.setSelectedIcon(new ImageIcon("E:\\clear-icon-28.png"));
		clrbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clrbtn.setForeground(Color.RED);
		clrbtn.setBackground(new Color(240, 240, 240));
		
		s1 = new JTextField();
		s1.setDropMode(DropMode.INSERT);
		s1.setBounds(169, 109, 144, 36);
		s1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s1.setToolTipText("");
		s1.setColumns(10);
		
		s2 = new JTextField();
		s2.setBounds(169, 169, 144, 36);
		s2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s2.setColumns(10);
		
		s3 = new JTextField();
		s3.setBounds(169, 236, 144, 36);
		s3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s3.setForeground(new Color(0, 0, 0));
		s3.setColumns(10);
		
		ltr = new JTextField();
		ltr.setBounds(467, 148, 153, 50);
		ltr.setEditable(false);
		ltr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ltr.setColumns(10);
		
		cgpa = new JTextField();
		cgpa.setBounds(467, 229, 153, 50);
		cgpa.setEditable(false);
		cgpa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cgpa.setColumns(10);
		
		sn = new JTextField();
		sn.setBounds(103, 39, 332, 36);
		sn.setColumns(10);
		
		sid = new JTextField();
		sid.setBounds(519, 39, 181, 36);
		sid.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setBounds(103, 14, 332, 23);
		
		lblNewLabel_3 = new JLabel("Student ID");
		lblNewLabel_3.setBounds(519, 14, 174, 23);
		
		lblNewLabel_4 = new JLabel("Input Marks");
		lblNewLabel_4.setBounds(183, 84, 117, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblNewLabel_5 = new JLabel("Subject 1:");
		lblNewLabel_5.setBounds(79, 114, 80, 24);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblNewLabel_6 = new JLabel("Subject 2:");
		lblNewLabel_6.setBounds(79, 174, 80, 24);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblNewLabel_7 = new JLabel("Subject 3:");
		lblNewLabel_7.setBounds(79, 241, 80, 24);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblNewLabel_8 = new JLabel("Output Result Grade");
		lblNewLabel_8.setBounds(476, 86, 144, 29);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblNewLabel_9 = new JLabel("Letter");
		lblNewLabel_9.setBounds(467, 119, 46, 14);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNewLabel_10 = new JLabel("CGPA");
		lblNewLabel_10.setBounds(467, 204, 46, 14);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmResultManagementSystem.getContentPane().setLayout(null);
		frmResultManagementSystem.getContentPane().add(lblNewLabel);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_1);
		frmResultManagementSystem.getContentPane().add(calc);
		frmResultManagementSystem.getContentPane().add(save);
		frmResultManagementSystem.getContentPane().add(clrbtn);
		frmResultManagementSystem.getContentPane().add(s1);
		frmResultManagementSystem.getContentPane().add(s2);
		frmResultManagementSystem.getContentPane().add(s3);
		frmResultManagementSystem.getContentPane().add(ltr);
		frmResultManagementSystem.getContentPane().add(cgpa);
		frmResultManagementSystem.getContentPane().add(sn);
		frmResultManagementSystem.getContentPane().add(sid);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_2);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_3);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_4);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_5);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_6);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_7);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_8);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_9);
		frmResultManagementSystem.getContentPane().add(lblNewLabel_10);
	}
}
