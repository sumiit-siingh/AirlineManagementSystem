// Source code is decompiled from a .class file using FernFlower decompiler.
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
   JTable table;
   JTextField pnr;
   JButton show;

   public JourneyDetails() {
      this.getContentPane().setBackground(Color.WHITE);
      this.setLayout((LayoutManager)null);
      JLabel lblpnr = new JLabel("PNR Details");
      lblpnr.setFont(new Font("Tahoma", 0, 16));
      lblpnr.setBounds(100, 50, 100, 25);
      this.add(lblpnr);
      this.pnr = new JTextField();
      this.pnr.setBounds(280, 50, 200, 25);
      this.add(this.pnr);
      this.show = new JButton("Show Details");
      this.show.setBackground(Color.BLACK);
      this.show.setForeground(Color.WHITE);
      this.show.setBounds(550, 50, 120, 25);
      this.show.addActionListener(this);
      this.add(this.show);
      this.table = new JTable();
      JScrollPane jsp = new JScrollPane(this.table);
      jsp.setBounds(0, 100, 800, 150);
      jsp.setBackground(Color.WHITE);
      this.add(jsp);
      this.setSize(800, 400);
      this.setLocation(400, 150);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      try {
         Conn conn = new Conn();
         ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '" + this.pnr.getText() + "'");
         if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog((Component)null, "No Information Found");
            return;
         }

         this.table.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public static void main(String[] args) {
      new JourneyDetails();
   }
}
