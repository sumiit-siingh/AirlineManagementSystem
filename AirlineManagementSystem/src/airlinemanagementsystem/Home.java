// Source code is decompiled from a .class file using FernFlower decompiler.
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener {
   public Home() {
      this.setLayout((LayoutManager)null);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
      JLabel image = new JLabel(i1);
      image.setBounds(0, -200, 1600, 1000);
      this.add(image);
      JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
      heading.setBounds(500, 40, 1000, 40);
      heading.setForeground(Color.BLUE);
      heading.setFont(new Font("Tahoma", 0, 36));
      image.add(heading);
      JMenuBar menubar = new JMenuBar();
      this.setJMenuBar(menubar);
      JMenu details = new JMenu("Details");
      menubar.add(details);
      JMenuItem flightDetails = new JMenuItem("Flight Details");
      flightDetails.addActionListener(this);
      details.add(flightDetails);
      
      JMenuItem customerDetails = new JMenuItem("Add Customer Details");
      customerDetails.addActionListener(this);
      details.add(customerDetails);
      
      JMenuItem bookFlight = new JMenuItem("Book Flight");
      bookFlight.addActionListener(this);
      details.add(bookFlight);
      
      JMenuItem journeyDetails = new JMenuItem("Journey Details");
      journeyDetails.addActionListener(this);
      details.add(journeyDetails);
      
      JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
      ticketCancellation.addActionListener(this);
      details.add(ticketCancellation);
      
      JMenu ticket = new JMenu("Ticket");
      menubar.add(ticket);
      
      JMenuItem boardingPass = new JMenuItem("Boarding Pass");
      boardingPass.addActionListener(this);
      ticket.add(boardingPass);
      
      this.setExtendedState(6);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      String text = ae.getActionCommand();
      if (text.equals("Add Customer Details")) {
         new AddCustomer();
      } else if (text.equals("Flight Details")) {
         new FlightInfo();
      } else if (text.equals("Book Flight")) {
         new BookFlight();
      } else if (text.equals("Journey Details")) {
         new JourneyDetails();
      } else if (text.equals("Cancel Ticket")) {
         new Cancel();
      }else if(text.equals("Boarding Pass")){
          new BoardingPass();
      }

   }

   public static void main(String[] args) {
      new Home();
   }
}
