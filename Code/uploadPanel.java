import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class uploadPanel extends JPanel{
    
    public static pathTable pathTable = new pathTable();
    public static fileUIController fileUIController = new fileUIController();

    public uploadPanel(){

        //side panel containing all the icons for the menu
        JPanel sidePanel = new JPanel();
        sidePanel = sideMenu.getSideMenu();

        //top panel, color of the background
        JPanel middleTop1 = new JPanel();
        middleTop1.setPreferredSize(new Dimension(800, 100));
        middleTop1.setBackground(colorPalette.background);
        topMiddle(middleTop1);

        //next panel containing the medium color 
        JPanel middleTop2 = new JPanel();
        middleTop2.setPreferredSize(new Dimension(850, 100));
        middleTop2.setBackground(colorPalette.med);
        middleMiddle(middleTop2);

        //middle panel containing most of the content 
        JPanel middlePanel = new JPanel();
        middlePanel.setPreferredSize(new Dimension(850, 1000));
        middlePanel.setBackground(colorPalette.background);
        bottomMiddle(middlePanel);

        //setting the panels layout to border layout
        setLayout(new BorderLayout());

        //creatting a wrapper to layer the middle panels 
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));

        //adding the middle panels 
        wrapperPanel.add(middleTop1);
        wrapperPanel.add(middleTop2);
        wrapperPanel.add(middlePanel);

        //adding panels to format the main panel
        add(wrapperPanel, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.WEST);
    }

    private void topMiddle(JPanel middleTop1){

        middleTop1.setLayout(new BorderLayout());

        //topSpace panel 
        JPanel topSpace = new JPanel();
        topSpace.setPreferredSize(new Dimension(1000, 25));
        topSpace.setBackground(colorPalette.background);

        //logout panel
        JPanel logout = new JPanel();
        logout.setPreferredSize(new Dimension(180, 50));
        logout.setBackground(colorPalette.background);
        //adding elements to logout panel
        JLabel logoutLabel = new JLabel(new ImageIcon("UI Formatting/Icons/icons8-logout-rounded-32.png"));
        JLabel logoutText = new JLabel("Logout");
        logoutText.setFont(new Font("Arial", Font.PLAIN, 30));//resizing text within label
        logoutText.setForeground(colorPalette.light);
        //adding mouse listeners to the jlabels 
        logoutLabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                System.exit(0);//ends program
            }
        });
        logoutText.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                System.exit(0);//ends program
            }
        });
        //adding elements to appName panel
        logout.add(logoutLabel);
        logout.add(logoutText);
      
        //adding panels into the main panel
        middleTop1.add(topSpace, BorderLayout.NORTH);
        middleTop1.add(logout, BorderLayout.EAST);
    }

    private void middleMiddle(JPanel middleTop2){
        middleTop2.setLayout(new BorderLayout());
        
        //topSpace panel
        JPanel topSpace = new JPanel();
        topSpace.setBackground(colorPalette.med);
        topSpace.setPreferredSize(new Dimension(850, 30));
        
        //upload panel
        JPanel upload = new JPanel();
        upload.setBackground(colorPalette.med);
        upload.setPreferredSize(new Dimension(600, 50));
        //adding elements to panel
        JLabel uploadText = new JLabel("Upload eBay Order Reciept PDFs");
        uploadText.setFont(new Font("Arial", Font.PLAIN, 40));//resizing text within label
        uploadText.setForeground(colorPalette.light);
        //adding elements to upload panel
        upload.add(uploadText);

        //adding panels into the main panel 
        middleTop2.add(topSpace, BorderLayout.NORTH);
        middleTop2.add(upload, BorderLayout.WEST);

    }

    private void bottomMiddle(JPanel middlePanel){

        middlePanel.setLayout(new BorderLayout());
        fileUIController.changeCard("No Files");

        //topPanel panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        topPanel.setBackground(colorPalette.background);
        topPanel.setPreferredSize(new Dimension(1000, 400));
        //adding elements to panel
        JPanel topCenter = new JPanel();
        topCenter = roundPanelBorder.roundBorder();
        topCenter.setBackground(colorPalette.background);
        JLabel centerIcon = new JLabel(new ImageIcon("UI Formatting/Icons/icons8-medical-file-96.png"));
        JLabel centerText1 = new JLabel("Select a PDF order receipt to upload");
        centerText1.setFont(new Font("Arial", Font.PLAIN, 20));
        centerText1.setForeground(colorPalette.light);
        JLabel centerText2 = new JLabel("or drag and drop it here");
        centerText2.setFont(new Font("Arial", Font.PLAIN, 15));
        centerText2.setForeground(Color.GRAY);
        //adding elements to center panel
        topCenter.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        topCenter.add(centerIcon, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        topCenter.add(centerText1, gbc);
        gbc.gridy = 2;
        topCenter.add(centerText2, gbc);

        //adding function to panel incase user decides to upload pdf files instead of dragging and dropping 
        topCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ROIManager.readInFiles();

                //ensuring that information was sucessfully uploaded 
                if(pathTable.returnRowCount() > 0){
                    fileUIController.changeCard("Path Files");
                } else {
                    fileUIController.changeCard("No Files");
                }
            }
        });

        //adding elements to topPanel panel
        topPanel.add(topCenter, BorderLayout.CENTER);

        //bottomPanel panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        bottomPanel.setBackground(colorPalette.background);
        bottomPanel.setPreferredSize(new Dimension(1000, 400));
        fileUIController.setBackground(colorPalette.background);
        //adding elements to bottomPanel panel
        bottomPanel.add(fileUIController, BorderLayout.CENTER);

        //adding panels into the main panel
        middlePanel.add(topPanel, BorderLayout.NORTH);
        middlePanel.add(bottomPanel, BorderLayout.SOUTH);
    }
    
}
