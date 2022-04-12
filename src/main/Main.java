package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

   private JPanel contentPane;
   private JTextField idInputField;
   private JTextField pwInputField;
   private JButton loginBtn;
   private JButton memRegBtn;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Main frame = new Main();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Main() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(2000, 100, 600, 500);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel loginLabel = new JLabel("로그인");
      loginLabel.setOpaque(true);
      loginLabel.setBackground(Color.PINK);
      loginLabel.setFont(new Font("Dialog", Font.BOLD, 30));
      loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
      loginLabel.setBounds(166, 75, 266, 82);
      contentPane.add(loginLabel);
      
      idInputField = new JTextField();
      idInputField.setBounds(166, 190, 159, 51);
      idInputField.setColumns(10);
      contentPane.add(idInputField);
      
      pwInputField = new JTextField();
      pwInputField.setColumns(10);
      pwInputField.setBounds(166, 253, 159, 51);
      contentPane.add(pwInputField);
      
      loginBtn = new JButton("로그인");
      loginBtn.setBounds(353, 190, 79, 110);
      contentPane.add(loginBtn);
      
      memRegBtn = new JButton("회원가입");
      memRegBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            RegistFrame rf = new RegistFrame();
            rf.setVisible(true);
            setVisible(false);
            
            String loginID = idInputField.getText();
            String loginPW = idInputField.getText();
            
            System.out.println("loginID값 : " + loginID);
            System.out.println("loginID값 : " + loginPW);
            
            MySQLDB db = new MySQLDB();
            db.login(loginID, loginPW);
            
            
         }
      });
      memRegBtn.setBounds(166, 325, 266, 44);
      contentPane.add(memRegBtn);
      
      
   }
}

