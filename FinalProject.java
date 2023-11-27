import javax.swing.*;
import java.awt.*;

public class FinalProject {
    FinalProject(){
        JFrame jfrm = new JFrame("McGUI's GUI");
        jfrm.setSize(700,600);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating panel
        JPanel panel = new JPanel(new BorderLayout());
        JPanel foodPanel = new JPanel();
        JPanel drinkPanel = new JPanel(new BorderLayout());
        JPanel paymentPanel = new JPanel();

        //create splitPane
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(350);

        //creating tab pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Food",foodPanel);
        tabbedPane.addTab("Drink",drinkPanel);
        tabbedPane.addTab("Payment",paymentPanel);

        //Food Panel
        ImageIcon food1 = new ImageIcon(getClass().getResource("cheeseburger.jpg"));
        ImageIcon food2 = new ImageIcon(getClass().getResource("double cheeseburger.jpg"));
        ImageIcon food3 = new ImageIcon(getClass().getResource("fries.jpg"));
        ImageIcon food4 = new ImageIcon(getClass().getResource("cheeseburger combo.jpg"));
        ImageIcon food5 = new ImageIcon(getClass().getResource("double cheeseburger combo.jpg"));

        JButton cb = new JButton("Cheeseburger",food1);
        cb.setVerticalTextPosition(SwingConstants.BOTTOM);
        cb.setHorizontalTextPosition(SwingConstants.CENTER); 
        JButton dcb = new JButton("Double Cheeseburger",food2);
        dcb.setVerticalTextPosition(SwingConstants.BOTTOM);
        dcb.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton fSmall = new JButton("S Fries",food3);
        fSmall.setVerticalTextPosition(SwingConstants.BOTTOM);
        fSmall.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton fMedium = new JButton("M Fries",food3);
        fMedium.setVerticalTextPosition(SwingConstants.BOTTOM);
        fMedium.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton fLarge = new JButton("L Fries",food3);
        fLarge.setVerticalTextPosition(SwingConstants.BOTTOM);
        fLarge.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton cbCombo = new JButton("Cheeseburger Combo",food4);
        cbCombo.setVerticalTextPosition(SwingConstants.BOTTOM);
        cbCombo.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton dcbCombo = new JButton("Double Cheeseburger Combo",food5);
        dcbCombo.setVerticalTextPosition(SwingConstants.BOTTOM);
        dcbCombo.setHorizontalTextPosition(SwingConstants.CENTER);

        //add food buttons to Food panel
        foodPanel.add(cb);
        foodPanel.add(dcb);
        foodPanel.add(fSmall);
        foodPanel.add(fMedium);
        foodPanel.add(fLarge);
        foodPanel.add(cbCombo);
        foodPanel.add(dcbCombo);

        //drink Panel
        ImageIcon colaImg = new ImageIcon(getClass().getResource("cola.PNG"));
        ImageIcon sprImg = new ImageIcon(getClass().getResource("sprite.jpg"));
        ImageIcon pepImg = new ImageIcon(getClass().getResource("pepsi.png"));
        JButton cola = new JButton(colaImg);
        JButton sprite = new JButton(sprImg);
        JButton pepsi = new JButton(pepImage);

        JPanel drinks = new JPanel(new GridLayout(4,4,1,1));

        cola.setPreferredSize(new Dimension(100,100));
        sprite.setPreferredSize(new Dimension(100,100));
        pepsi.setPreferredSize(new Dimension(100,100));

        drinks.add(cola);
        drinks.add(sprite);
        drinks.add(pepsi);

        //add buttons to drink panel
        drinkPanel.add(drinks,BorderLayout.NORTH);

        //buttons for drink panel(sizes)
        JRadioButton small = new JRadioButton("Small");
        JRadioButton medium = new JRadioButton("Medium");
        JRadioButton large = new JRadioButton("Large");

        ButtonGroup sizegrp = new ButtonGroup();
        sizegrp.add(small);
        sizegrp.add(medium);
        sizegrp.add(large);

        //panel for size of drinks buttons
        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sizePanel.add(small);
        sizePanel.add(medium);
        sizePanel.add(large);

        drinkPanel.add(sizePanel,BorderLayout.SOUTH);


        //payment panel
        JRadioButton cc = new JRadioButton("Credit Card");
        JRadioButton ven = new JRadioButton("Venmo");
        JRadioButton cash = new JRadioButton("Cash");

        cc.setFont(new Font("Molto",Font.ITALIC,25));
        ven.setFont(new Font("Molto",Font.ITALIC,25));
        cash.setFont(new Font("Molto", Font.ITALIC,25));

        //add to button group for mutual exclusive function(one only)
        ButtonGroup bg=new ButtonGroup();
        bg.add(cc);
        bg.add(ven);
        bg.add(cash);

        paymentPanel.add(cc);
        paymentPanel.add(ven);
        paymentPanel.add(cash);

        //creating labels
        JLabel shopping_cart = new JLabel("Shopping Cart");
        shopping_cart.setFont(new Font("Molto", Font.BOLD, 25));

        //button panel for right component
        JPanel buttonPanel=new JPanel();

        //setting button panel to be aligned along left side of right panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //clear and checkout buttons
        JButton clear=new JButton("Clear");
        JButton check=new JButton("Check Out");
        clear.setPreferredSize(new Dimension(150,50));
        check.setPreferredSize(new Dimension(150,50));
        buttonPanel.add(check);
        buttonPanel.add(clear);

        //adding buttonPanel to the bottom of the panel
        panel.add(buttonPanel,BorderLayout.SOUTH);

        //adding label to panels
        panel.add(shopping_cart,BorderLayout.NORTH);

        //adding respective pane to respective side
        splitPane.setLeftComponent(tabbedPane);
        splitPane.setRightComponent(panel);

        //add to frame
        jfrm.add(splitPane);

        //set visible
        jfrm.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(FinalProject::new);
    }
}
