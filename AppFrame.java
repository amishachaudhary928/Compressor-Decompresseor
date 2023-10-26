package GUI;

/**
 *
 * @author Sarvesh Kumar
 */

import compressordecompressor.compressor;
import compressordecompressor.decompressor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AppFrame extends JFrame implements ActionListener {
    
    // Creating two button 
    
    // 1 compressButtom
    JButton compressButton;
    
    // 2. DecompressButton
    JButton decompressButton;
    
    // Creating class
    AppFrame(){
        
        // Doing this to make sure, Window will be closed after clicking on RED Cross
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Setting the layout of the window
        this.setLayout(null);
        
        //  Creating comoressButton with that particular name
        compressButton = new JButton("Select file to Compress");
        
        // Allowing the button to take action
        compressButton.addActionListener(this);
        
        // Setting the size of button
        compressButton.setBounds(70,200,200,30);
        
        //  Creating  decomoressButton with that particular name
        decompressButton = new JButton("Select file to Decompress");
        
        // Allowing the button to take action
        decompressButton.addActionListener(this);
        
        // Setting the size of button
        decompressButton.setBounds(70, 245,200, 30);
        
        // Giving the title to the project
        this.setTitle("Compressor-Decompressor");
        
        this.add(compressButton);
        this.add(decompressButton);
        
        // Initialising the size of the window
        this.setSize(600,500);
        
        // used this to fix the size of window
        this.setResizable(false);
        
        
        // Used this to make sure window will be open at the centre of the Screen
        this.setLocationRelativeTo(null);
        
        // Fixing the background color of windows
        this.getContentPane().setBackground(Color.gray);
        
        // Making sure our windows is visible to returned true
        this.setVisible(true);
        
        //Setting the background color
        this.setBackground(Color.CYAN);
        
        // Adding Image to my backGround
        ImageIcon image = new ImageIcon("codingcartoom.png");
        
        // Adding label for further use
        JLabel label = new JLabel();
        
        // adding text that will appear...
        label.setText("Dude, Lets do your task....");
        
        // Setting Image
        label.setIcon(image);
        
        //
        label.setHorizontalTextPosition(JLabel.CENTER);
        
        //
        label.setVerticalTextPosition(JLabel.BOTTOM);
        
        //
        label.setFont(new Font("MV Boli",Font.ITALIC,16));
        
        //
        label.setIconTextGap(2);
        
        //
        label.setBackground(Color.blue);
        
        //
        this.add(label);  
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        
        // check wether pressed button is compressed
        if(event.getSource()==compressButton){
            
            // Selecting the file from system
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                
                // try and catch for exception handling
                try{
                    compressor.method(file);
                }
                catch (Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        
        // check wether pressed button is decompressed
        if(event.getSource()==decompressButton){
            
            // select a file from system
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                
                // try and catch for exception handling
                try{
                    decompressor.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
    }


    private void setText(String welcome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
