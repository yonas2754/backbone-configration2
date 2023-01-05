/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backbone.configuretion;

// Java Program to create a text editor using java
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;


import java.util.ArrayList;


import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;


class BackboneConfiguretion extends JFrame implements ActionListener {
	// Text component
	public static  JTextArea t;
        
        public static  JTextField tt;
        
        String temp_data="";

	// Frame
	public static JFrame f;

	// Constructor
	BackboneConfiguretion()
       
	{
            
         
		// Create a frame
		f = new JFrame("BackboneConfiguretion Script Writing System");
                Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("n2.png"));
 
    f.setIconImage(im);
    
                
                
               

		try {
			// Set metal look and feel
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			// Set theme to ocean
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		}
		catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
		}
                tt = new JTextField( 7);
		// Text component
		t = new JTextArea();
              
                /////////////////////////
                
               //instantiate frame
    //instantiate textArea
    final UndoManager undo = new UndoManager(); //instantiate an UndoManager
    
    Document doc = t.getDocument();  //instantiate a Document class of the txtArea

    doc.addUndoableEditListener((UndoableEditEvent evt) -> {
        undo.addEdit(evt.getEdit());
                });

    t.getActionMap().put("Undo", new AbstractAction("Undo") {
      @Override
      public void actionPerformed(ActionEvent evt) {
        try {
          if (undo.canUndo()) {
            undo.undo();
            
          }
        } catch (CannotUndoException e) {
        }
      }
    });

    t.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");

    
                ///////////////////////////////
                
                
             
   
    // textArea.setBackground(color);
                  
 //Set JTextArea background color to color that you choose
               t.setBackground(Color.white);
              
               t. setForeground(Color.BLACK);
               t.setCaretColor(Color.black);
           
               t. setFont(new Font("Arial", Font.PLAIN, 18));
                
                
            
             
		// Create a menubar
		JMenuBar mb = new JMenuBar();


		// Create amenu for menu
		JMenu m1 = new JMenu("File");

		// Create menu items
		JMenuItem mi1 = new JMenuItem("New");
		JMenuItem mi2 = new JMenuItem("Open");
		JMenuItem mi3 = new JMenuItem("Save");
		JMenuItem mi9 = new JMenuItem("Print");

		// Add action listener
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi9.addActionListener(this);
                  m1.setBackground(Color.white);
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi9);
               

		// Create amenu for menu
		JMenu m2 = new JMenu("Edit");

		// Create menu items
		JMenuItem mi4 = new JMenuItem("cut");
		JMenuItem mi5 = new JMenuItem("copy");
		JMenuItem mi6 = new JMenuItem("paste");

		// Add action listener
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);

                m2.setBackground(Color.white);
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
                

		JMenuItem mc = new JMenuItem("New");
                
                JMenuItem mcs = new JMenuItem("show");
                JMenuItem mca = new JMenuItem("Area");
                JMenuItem mcc = new JMenuItem("clear");
                JMenuItem mc2 = new JMenuItem("Resum");
                JMenuItem mc3 = new JMenuItem("Suspention");
                JMenuItem mc4 = new JMenuItem("BackUp-Resum");
                JMenuItem mc5 = new JMenuItem("BackUp-Suspen");
                 JMenuItem mc6 = new JMenuItem("VPN-Resum");
                 JMenuItem mc7 = new JMenuItem("VPN-Suspen");
                JMenuItem mc8 = new JMenuItem("Termination");
                 JMenuItem mc9 = new JMenuItem("double ip");
                 JMenuItem mc10 = new JMenuItem("Error");
                
                 mb.setBackground(Color.white);
                 mc.setBackground(Color.white);
                 mcs.setBackground(Color.white);
                 mca.setBackground(Color.white);
                 mcc.setBackground(Color.white);
                 mc2.setBackground(Color.white);
                 mc3.setBackground(Color.white);
                 mc4.setBackground(Color.white);
                 mc5.setBackground(Color.white);
                 mc6.setBackground(Color.white);
                 mc7.setBackground(Color.white);
                 mc8.setBackground(Color.white);
                 mc9.setBackground(Color.white);
                 mc10.setBackground(Color.white);
                 
		mc.addActionListener(this);
                mcs.addActionListener(this);
                mca.addActionListener(this);
                mcc.addActionListener(this);
                mc2.addActionListener(this);
                mc3.addActionListener(this);
                mc4.addActionListener(this);
                 mc5.addActionListener(this);
                 mc6.addActionListener(this);
                 mc7.addActionListener(this);
                  mc8.addActionListener(this);
                  mc9.addActionListener(this);
                  mc10.addActionListener(this);
		mb.add(m1);
		mb.add(m2);
		mb.add(mc);
                  mb.add(tt);
                  mb.add(mcs);
                  mb.add(mca);
                  mb.add(mcc);
                mb.add(mc2);
                mb.add(mc3);
                 mb.add(mc4);
                 mb.add(mc5);
               mb.add(mc6);
               mb.add(mc7);
                mb.add(mc8);
                mb.add(mc9);
               mb.add(mc10);
               
                ///////////////////////
                  //JTextField simpleinput=new JTextField();
        
                
                ///////////////////////
                JScrollPane scrolltxt = new JScrollPane(t);
                
               
        

		f.setJMenuBar(mb);
                
		f.add(scrolltxt);
               
		f.setSize(1200, 865);
		f.show();
	}

	// If a button is pressed
        @Override
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

            switch (s) {
                case "cut":
                    t.cut();
                    break;
                case "copy":
                    t.copy();
                    break;
                case "paste":
                    t.paste();
                    break;
                case "Save":
                    {
                        // Create an object of JFileChooser class
                        JFileChooser j = new JFileChooser("f:");
                        // Invoke the showsSaveDialog function to show the save dialog
                        int r = j.showSaveDialog(null);
                        if (r == JFileChooser.APPROVE_OPTION) {
                            
                            // Set the label to the path of the selected directory
                            File fi = new File(j.getSelectedFile().getAbsolutePath());
                            
                            try {
                                // Create a file writer
                                FileWriter wr = new FileWriter(fi, false);
                                
                                // Write
                                try ( // Create buffered writer to write
                                        BufferedWriter w = new BufferedWriter(wr)) {
                                    // Write
                                    w.write(t.getText());
                                    
                                    w.flush();
                                }
                            }
                            catch (IOException evt) {
                                JOptionPane.showMessageDialog(f, evt.getMessage());
                            }
                        }
                        // If the user cancelled the operation
                        else
                            JOptionPane.showMessageDialog(f, "the user cancelled the operation");
                        break;
                    }
                case "Print":
                    try {
                        // print the file
                        t.print();
                        
                    }
                    catch (PrinterException evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                    break;
                case "Open":
                    {
                        // Create an object of JFileChooser class
                        JFileChooser j = new JFileChooser("f:");
                        // Invoke the showsOpenDialog function to show the save dialog
                        int r = j.showOpenDialog(null);
                        // If the user selects a file
                        if (r == JFileChooser.APPROVE_OPTION) {
                            // Set the label to the path of the selected directory
                            File fi = new File(j.getSelectedFile().getAbsolutePath());
                            
                            try {
                                // String
                                String s2 = "", sl = "";
                                String qq="";
                                ArrayList<String> al = new ArrayList<>();
                                
                                // File reader
                                FileReader fr = new FileReader(fi);
                                
                                // Buffered reader
                                BufferedReader br = new BufferedReader(fr);
                                
                                // Initialize sl
                                sl = br.readLine();
                                sl = sl.trim();
                                al.add(sl);
                                
                                // Take the input from the file
                                while ((s2 = br.readLine()) != null) {
                                    sl = sl + "\n" + s2;
                                    sl = s2.trim();
                                    al.add(sl);
                                    
                                }
                                
                                // Set the text
                                // For loop for iterating over the List
                                for (int i = 0; i < al.size(); i++) {
                                    
                                    // Print all elements of List
                                    //System.out.println(al.get(i));
                                    //data clear
                                    
                                    //out put
                                    qq = qq + "\n" + al.get(i);
                                }
                                
                                
                                t.setText(qq);
                                //System.out.println(al);
                                
                                
                                
                                
                                
                                
                                
                                
                            }
                            catch (IOException evt) {
                                JOptionPane.showMessageDialog(f, evt.getMessage());
                            }
                        }
                        // If the user cancelled the operation
                        else
                            JOptionPane.showMessageDialog(f, "the user cancelled the operation");
                        break;
                    }
                case "New":
                    t.setText("");
                    break;
                case "close":
                    f.setVisible(false);
                    break;
                case "clear":
                    {
                       
                
                      
                       clear clears =new clear();
                        t.setText(clears.clears(t.getText()));
                        break;
                    }
                case "Area":
                    {
                        
                        
                       Area area =new Area();
                       
                        String input =t.getText();
                         input = input.trim();
                        
                         String[]  qq =area.Area(input);
                        
            t.setText(input+"\n====================Area===================\n"+  qq[0]+"\n==================None=============="+qq[1]);
                        break;
                    }
                case "show":
                    {
                        
                        
                                // Now add the particular background color
                           show show =new show();
                        String vbui =tt.getText();
                        
                        String input =t.getText();
                        input = input.trim();
                        
                            t.setText(input+"\n=======================================\n"+show.show(input, vbui));
                        break;
                    }
                case "double ip":
                {   
                  
                        double_ip double_ip =new double_ip();
                        t.setText("\n=======================================\n"+double_ip.double_ip());
                        
                    
                    //////////h
                break;
                } 
                
                     case "Termination":
                {
                /////////////
                     
                     Termination termination = new Termination();
                        String input =t.getText();
                        input = input.trim();
                        t.setText(input+"\n=======================================\n"+termination.Termination(input));
                        
                    //////////h
                break;
                } 
                /////////////////
                
                
                
                case "Error":
                    {
                        Error error =new Error();
                        String input =t.getText();
                        input = input.trim();
                       
                      t.setText(input+"\n===================ERROR====================\n"+error.Error(input)+"\n==================\n"); 
                     break;
                    }
                  
                        
                      
                
                  
                   
                
            
                
                
                ////////////
                 case "BackUp-Resum":
                    {
                          try {
                       BackUp_Resume BackUp_Resume=new BackUp_Resume();
                        String input =t.getText();
                        input = input.trim();
                      
                        t.setText(input+"\n=======================================\n"+BackUp_Resume.BackUp_Resume(input));
                        
                          }
                         catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                        break;
                    }
                case "Resum":
                    // Create an object of JFileChooser class
                    
                    
                    // If the user selects a file
                
                    try {
                        // String
                       Resume Resume=new Resume();  
                       
                        String input =t.getText();
                        input = input.trim();
                        
                        
                        // For loop for iterating over the List
                        
                        
                
t.setText(input+"\n=======================================\n"+Resume.Resume(input));


                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                    break;
                case "BackUp-Suspen":
                    // Create an object of JFileChooser class
                    
                    
                    // If the user selects a file
                    
                    
                    
                    
                    try {
                        
                        BackUp_Suspen BackUp_Suspen = new BackUp_Suspen();
                      
                    String input =t.getText();
                    input = input.trim();
                   
                    
                 
                    
                    t.setText(input+"\n=======================================\n"+BackUp_Suspen.BackUp_Suspen(input));
                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                    break;
                case "Suspention":
                  
                    try {
                        // String
                        
                        
                        Suspention Suspention = new Suspention();
                        String input =t.getText();
                        input = input.trim();
                        
                        
                        // For loop for iterating over the List
                        
                       

t.setText(input+"\n=======================================\n"+Suspention.Suspention(input));
                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                    break;
                case "VPN-Resum":
                    {
                       
                        VPN_Resum VPN_Resum = new VPN_Resum();
                        String input =t.getText();
                        input = input.trim();
                     
                       
                           
             t.setText(input+"\n=======================================\n"+VPN_Resum.VPN_Resum(input));
                        break;
                    }
                case "VPN-Suspen":
                    {
                      VPN_Suspen VPN_Suspen =new VPN_Suspen();
                        String input =t.getText();
                        input = input.trim();
                      
                       
                        t.setText(input+"\n=======================================\n"+VPN_Suspen.VPN_Suspen(input));
                        break;
                    }
                default:
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
                    break;
            }
		
		
	}
       
                
                
   
    
	// Main class
	public static void main(String args[])
	{
		BackboneConfiguretion e = new BackboneConfiguretion();
                
                

        //Popup menu Code
        JPopupMenu jPopupMenu=new JPopupMenu("Edit");

        JMenuItem cut=new JMenuItem("Cut");
        JMenuItem copy=new JMenuItem("Copy");
        JMenuItem paste=new JMenuItem("Paste");

        jPopupMenu.add(cut);
        jPopupMenu.add(copy);
        jPopupMenu.add(paste);
        //End Popup Menu Code

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(SwingUtilities.isRightMouseButton(mouseEvent)){
                    jPopupMenu.show(f,mouseEvent.getX(),mouseEvent.getY());
                }
            }
        });

        //End Popup Code
        //Example Popup menu
        //Popup menu Code
        JPopupMenu jPopupMenu2=new JPopupMenu("Edit");

        JMenuItem cut2=new JMenuItem("Cut");
        JMenuItem copy2=new JMenuItem("Copy");
        JMenuItem paste2=new JMenuItem("Paste");

        jPopupMenu2.add(cut2);
        jPopupMenu2.add(copy2);
        jPopupMenu2.add(paste2);
        //End Popup Menu Code

        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(SwingUtilities.isRightMouseButton(mouseEvent)){
                    jPopupMenu2.show(t,mouseEvent.getX(),mouseEvent.getY());
                }
            }
        });

        cut2.addActionListener((ActionEvent actionEvent) -> {
            t.cut();
                });

        copy2.addActionListener((ActionEvent actionEvent) -> {
            t.copy();
                });

        paste2.addActionListener((ActionEvent actionEvent) -> {
            t.paste();
                });
                
                
                
                
                
                
	}
}
