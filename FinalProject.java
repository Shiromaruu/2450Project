import javax.swing.*;
import java.awt.*;


public class FinalProject {

    FinalProject(){
        JFrame jfrm = new JFrame("McGUI's GUI");
        jfrm.setSize(700,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating panel
        JPanel shoppingPane = new JPanel();
        JPanel foodPanel = new JPanel();
        drinkPanel = new JPanel();
        JPanel paymentPanel = new JPanel();
        
        //create splitPane
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(350);

        //creating tab pane
        JTabbedPane foodMenuTabbedPane = new JTabbedPane();
        foodMenuTabbedPane.addTab("Food",foodPanel);
        foodMenuTabbedPane.addTab("Drink",drinkPanel);
        foodMenuTabbedPane.addTab("Payment",paymentPanel);

        //drink Panel
        String cola = "cola";
        setMenuItem (cola, 15);

        String sprite = "sprite";
        setMenuItem (sprite, 10);

        JScrollBar jVert=new JScrollBar(Adjustable.VERTICAL,0,50,0,300);
        drinkPanel.add(jVert);

        //payment panel
        JRadioButton creditRB = new JRadioButton("Credit Card");
        JRadioButton venmoRB = new JRadioButton("Venmo");
        JRadioButton cashRB = new JRadioButton("Cash");


        creditRB.setFont(setDefaultFont());
        venmoRB.setFont(setDefaultFont());
        cashRB.setFont(setDefaultFont());

        //add to button group for mutual exclusive function(one only)
        ButtonGroup bg = new ButtonGroup();
        bg.add(creditRB);
        bg.add(venmoRB);
        bg.add(cashRB);

        paymentPanel.add(creditRB);
        paymentPanel.add(venmoRB);
        paymentPanel.add(cashRB);

        //creating labels
        JLabel shopping_cart = new JLabel("Shopping Cart");
        shopping_cart.setFont(setDefaultFont());
        costLabel = new JLabel("Total Cost: ");
        costLabel.setFont(setDefaultFont());

        //adding label to panels
        shoppingPane.add(shopping_cart);
        shoppingPane.add(costLabel);

        //adding respective pane to respective side
        splitPane.setLeftComponent(foodMenuTabbedPane);
        splitPane.setRightComponent(shoppingPane);

        //add to frame
        jfrm.add(splitPane);

        //set visible
        jfrm.setVisible(true);
    }
    JLabel costLabel;
    double totalCost;
    JPanel drinkPanel;
    private void setMenuItem (String foodItem, double cost) {
        //set the image
        String imagePath = "testImages/" + foodItem + "Logo.png";
        ImageIcon foodItemImg = new ImageIcon(getClass().getResource(imagePath));

        //set the button
        JButton foodItemButton = new JButton(foodItemImg);

        //set the preferred image size
        foodItemButton.setPreferredSize(new Dimension(100,100));

        //add button to drink panel
        drinkPanel.add(foodItemButton);

        //set Action Listener
        remoteActionListener(foodItemButton, cost);
    }

    private void remoteActionListener(JButton drinkButton, double cost) {
        drinkButton.addActionListener(e -> {
            totalCost += cost;
            costLabel.setText("Total Cost: $" + (totalCost));
        });
    }

    //default font generator for the java file
    public Font setDefaultFont (int font) {
        return new Font ("Molto",Font.ITALIC,font);
    }
    public Font setDefaultFont () {
        return new Font ("Molto",Font.ITALIC,22);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(FinalProject::new);
    }
}
