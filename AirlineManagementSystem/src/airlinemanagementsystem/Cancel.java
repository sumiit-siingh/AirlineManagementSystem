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
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cancel extends JFrame implements ActionListener {
   JTextField tfpnr;
   JLabel tfname;
   JLabel cancellationno;
   JLabel lblfcode;
   JLabel lbldateoftravel;
   JButton fetchButton;
   JButton flight;

   public Cancel() {
      this.getContentPane().setBackground(Color.WHITE);
      this.setLayout((LayoutManager)null);
      Random random = new Random();
      JLabel heading = new JLabel("CANCEL TICKET");
      heading.setForeground(Color.BLUE);
      heading.setBounds(250, 20, 250, 35);
      heading.setFont(new Font("Tahoma", 0, 32));
      this.add(heading);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
      Image i2 = i1.getImage().getScaledInstance(250, 250, 1);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(470, 120, 250, 250);
      this.add(image);
      JLabel lblaadhar = new JLabel("PNR Number");
      lblaadhar.setBounds(60, 80, 150, 25);
      lblaadhar.setFont(new Font("Tahoma", 0, 16));
      this.add(lblaadhar);
      this.tfpnr = new JTextField();
      this.tfpnr.setBounds(220, 80, 150, 25);
      this.add(this.tfpnr);
      this.fetchButton = new JButton("Show Details");
      this.fetchButton.setBackground(Color.BLACK);
      this.fetchButton.setForeground(Color.WHITE);
      this.fetchButton.setBounds(400, 79, 120, 25);
      this.fetchButton.addActionListener(this);
      this.add(this.fetchButton);
      JLabel lblname = new JLabel("Name");
      lblname.setBounds(60, 130, 150, 25);
      lblname.setFont(new Font("Tahoma", 0, 16));
      this.add(lblname);
      this.tfname = new JLabel();
      this.tfname.setBounds(220, 130, 150, 25);
      this.add(this.tfname);
      JLabel lblnationality = new JLabel("Cancellation No");
      lblnationality.setBounds(60, 180, 150, 25);
      lblnationality.setFont(new Font("Tahoma", 0, 16));
      this.add(lblnationality);
      this.cancellationno = new JLabel("" + random.nextInt(1000000));
      this.cancellationno.setBounds(220, 180, 150, 25);
      this.add(this.cancellationno);
      JLabel lbladdress = new JLabel("Flight Code");
      lbladdress.setBounds(60, 230, 150, 25);
      lbladdress.setFont(new Font("Tahoma", 0, 16));
      this.add(lbladdress);
      this.lblfcode = new JLabel();
      this.lblfcode.setBounds(220, 230, 150, 25);
      this.add(this.lblfcode);
      JLabel lblgender = new JLabel("Date");
      lblgender.setBounds(60, 280, 150, 25);
      lblgender.setFont(new Font("Tahoma", 0, 16));
      this.add(lblgender);
      this.lbldateoftravel = new JLabel();
      this.lbldateoftravel.setBounds(220, 280, 150, 25);
      this.add(this.lbldateoftravel);
      this.flight = new JButton("Cancel");
      this.flight.setBackground(Color.BLACK);
      this.flight.setForeground(Color.WHITE);
      this.flight.setBounds(220, 330, 120, 25);
      this.flight.addActionListener(this);
      this.add(this.flight);
      this.setSize(800, 450);
      this.setLocation(350, 150);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      String name;
      String cancelno;
      if (ae.getSource() == this.fetchButton) {
         name = this.tfpnr.getText();

         try {
            Conn conn = new Conn();
            cancelno = "select * from reservation where PNR = '" + name + "'";
            ResultSet rs = conn.s.executeQuery(cancelno);
            if (rs.next()) {
               this.tfname.setText(rs.getString("name"));
               this.lblfcode.setText(rs.getString("flightcode"));
               this.lbldateoftravel.setText(rs.getString("ddate"));
            } else {
               JOptionPane.showMessageDialog((Component)null, "Please enter correct PNR");
            }
         } catch (Exception var10) {
            var10.printStackTrace();
         }
      } else if (ae.getSource() == this.flight) {
         name = this.tfname.getText();
         String pnr = this.tfpnr.getText();
         cancelno = this.cancellationno.getText();
         String fcode = this.lblfcode.getText();
         String date = this.lbldateoftravel.getText();

         try {
            Conn conn = new Conn();
            String query = "insert into cancel values('" + pnr + "', '" + name + "', '" + cancelno + "', '" + fcode + "', '" + date + "')";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate("delete from reservation where PNR = '" + pnr + "'");
            JOptionPane.showMessageDialog((Component)null, "Ticket Cancelled");
            this.setVisible(false);
         } catch (Exception var9) {
            var9.printStackTrace();
         }
      }

   }

   public static void main(String[] args) {
      new Cancel();
   }
}
