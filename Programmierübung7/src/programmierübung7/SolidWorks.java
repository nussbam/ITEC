package programmierübung7;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 * SolidWorks
 * 
 * @author H. Diethelm, Hochschule Luzern
 * @version 6.4.2008
 */
public class SolidWorks extends JFrame implements ActionListener
{
    private Cube[] solids;
    private String fileName = "F:\\Itec\\Programmierübung7\\src\\programmierübung7\\soliddata.txt";
    // GUI Elemente erzeugen
    private JButton bRead = new JButton("Read File '" + fileName + "'");
    private JButton bSort1 = new JButton("Sort 'volume'");
    private JButton bSort2 = new JButton("Sort 'surface'");
    private JButton bSort3 = new JButton("Sort 'dimension'");
    private JTextArea outputArea = new JTextArea();

    public SolidWorks()
    {
        super("SolidWorks");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        
        Container cp = getContentPane();
        JPanel p1 = new JPanel();
        
        p1.add(bRead);
        cp.add(p1, BorderLayout.NORTH);
        
        outputArea.setEditable(false);
        cp.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        JPanel p2 = new JPanel();        
        p2.add(bSort1); p2.add(bSort2); p2.add(bSort3);
        cp.add(p2, BorderLayout.SOUTH);        

        // Listener registrieren
        bRead.addActionListener(this);
        bSort1.addActionListener(this);
        bSort2.addActionListener(this);
        bSort3.addActionListener(this);

        setVisible(true);       
    }
    
    private void doOutput()
    {
        outputArea.setText("");
        for (int i = 0; i < solids.length; i++){
            outputArea.append(solids[i].toString());
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == bRead){
            try {
                solids = SolidFileIO.readSolids(fileName);
            } catch (IOException ex) {
                Logger.getLogger(SolidWorks.class.getName()).log(Level.SEVERE, null, ex);
            }
            doOutput();
        }
        if ((e.getSource() == bSort1) && (solids != null)){
            // ...
            doOutput();
        }
        if ((e.getSource() == bSort2) && (solids != null)){
            // ...
            doOutput();
        }
        if ((e.getSource() == bSort3) && (solids != null)){
            // ...
            doOutput();
        }
    }
    
    public static void main(String[] args)
    {
        SolidWorks sw = new SolidWorks();
    }

}