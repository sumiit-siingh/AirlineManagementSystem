// Source code is decompiled from a .class file using FernFlower decompiler.
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BoardingPass extends JFrame implements ActionListener {
   JTextField tfpnr;
   JLabel tfname;
   JLabel tfnationality;
   JLabel lblsrc;
   JLabel lbldest;
   JLabel labelfname;
   JLabel labelfcode;
   JLabel labeldate;
   JButton fetchButton;

   public BoardingPass() {
      this.getContentPane().setBackground(Color.WHITE);
      this.setLayout((LayoutManager)null);
      JLabel heading = new JLabel("AIR INDIA");
      heading.setForeground(Color.RED);
      heading.setBounds(380, 10, 450, 35);
      heading.setFont(new Font("Tahoma", 0, 32));
      this.add(heading);
      JLabel subheading = new JLabel("Boarding Pass");
      subheading.setBounds(380, 50, 300, 30);
      subheading.setFont(new Font("Tahoma", 0, 24));
      subheading.setForeground(Color.BLUE);
      this.add(subheading);
      JLabel lblaadhar = new JLabel("PNR DETAILS");
      lblaadhar.setBounds(60, 100, 150, 25);
      lblaadhar.setFont(new Font("Tahoma", 0, 16));
      this.add(lblaadhar);
      this.tfpnr = new JTextField();
      this.tfpnr.setBounds(220, 100, 150, 25);
      this.add(this.tfpnr);
      this.fetchButton = new JButton("Enter");
      this.fetchButton.setBackground(Color.BLACK);
      this.fetchButton.setForeground(Color.WHITE);
      this.fetchButton.setBounds(390, 100, 120, 25);
      this.fetchButton.addActionListener(this);
      this.add(this.fetchButton);
      JLabel lblname = new JLabel("NAME");
      lblname.setBounds(60, 140, 150, 25);
      lblname.setFont(new Font("Tahoma", 0, 16));
      this.add(lblname);
      this.tfname = new JLabel();
      this.tfname.setBounds(220, 140, 150, 25);
      this.add(this.tfname);
      JLabel lblnationality = new JLabel("NATIONALITY");
      lblnationality.setBounds(60, 180, 150, 25);
      lblnationality.setFont(new Font("Tahoma", 0, 16));
      this.add(lblnationality);
      this.tfnationality = new JLabel();
      this.tfnationality.setBounds(220, 180, 150, 25);
      this.add(this.tfnationality);
      JLabel lbladdress = new JLabel("SRC");
      lbladdress.setBounds(60, 220, 150, 25);
      lbladdress.setFont(new Font("Tahoma", 0, 16));
      this.add(lbladdress);
      this.lblsrc = new JLabel();
      this.lblsrc.setBounds(220, 220, 150, 25);
      this.add(this.lblsrc);
      JLabel lblgender = new JLabel("DEST");
      lblgender.setBounds(380, 220, 150, 25);
      lblgender.setFont(new Font("Tahoma", 0, 16));
      this.add(lblgender);
      this.lbldest = new JLabel();
      this.lbldest.setBounds(540, 220, 150, 25);
      this.add(this.lbldest);
      JLabel lblfname = new JLabel("Flight Name");
      lblfname.setBounds(60, 260, 150, 25);
      lblfname.setFont(new Font("Tahoma", 0, 16));
      this.add(lblfname);
      this.labelfname = new JLabel();
      this.labelfname.setBounds(220, 260, 150, 25);
      this.add(this.labelfname);
      JLabel lblfcode = new JLabel("Flight Code");
      lblfcode.setBounds(380, 260, 150, 25);
      lblfcode.setFont(new Font("Tahoma", 0, 16));
      this.add(lblfcode);
      this.labelfcode = new JLabel();
      this.labelfcode.setBounds(540, 260, 150, 25);
      this.add(this.labelfcode);
      JLabel lbldate = new JLabel("Date");
      lbldate.setBounds(60, 300, 150, 25);
      lbldate.setFont(new Font("Tahoma", 0, 16));
      this.add(lbldate);
      this.labeldate = new JLabel();
      this.labeldate.setBounds(220, 300, 150, 25);
      this.add(this.labeldate);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
      Image i2 = i1.getImage().getScaledInstance(300, 230, 1);
      ImageIcon image = new ImageIcon(i2);
      JLabel lblimage = new JLabel(image);
      lblimage.setBounds(600, 0, 300, 300);
      this.add(lblimage);
      this.setSize(1000, 450);
      this.setLocation(300, 150);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      String pnr = this.tfpnr.getText();

      try {
         Conn conn = new Conn();
         String query = "select * from reservation where PNR = '" + pnr + "'";
         ResultSet rs = conn.s.executeQuery(query);
         if (rs.next()) {
            this.tfname.setText(rs.getString("name"));
            this.tfnationality.setText(rs.getString("nationality"));
            this.lblsrc.setText(rs.getString("src"));
            this.lbldest.setText(rs.getString("des"));
            this.labelfname.setText(rs.getString("flightname"));
            this.labelfcode.setText(rs.getString("flightcode"));
            this.labeldate.setText(rs.getString("ddate"));
         } else {
            JOptionPane.showMessageDialog((Component)null, "Please enter correct PNR");
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }
   

   public static void main(String[] args) {
      new BoardingPass();
   }
}
