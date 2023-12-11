//
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalProject {
    JPanel foodPanel;
    JPanel drinkPanel;
    JPanel drinks;
    JPanel paymentPanel;
    DefaultListModel<String> listModel;
    JLabel totalLabel;
    
    FinalProject() {
        JFrame jfrm = new JFrame("McGUI's GUI");
        jfrm.setSize(700,600);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating panel
        JPanel panel = new JPanel(new BorderLayout());
        foodPanel = new JPanel();
        drinkPanel = new JPanel(new BorderLayout());
        paymentPanel = new JPanel();

        //create splitPane
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(350);

        //creating tab pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Food",foodPanel);
        tabbedPane.addTab("Drink",drinkPanel);
        tabbedPane.addTab("Payment",paymentPanel);

        //Food Panel-----
        setMenuItem("Cheeseburger", "FoodImages/cheeseburger.jpg", foodPanel, 10);
        setMenuItem("Double Cheeseburger", "FoodImages/double_cheeseburger.jpg", foodPanel, 10);

        //set fry
        char[] frySize = {'S', 'M', 'L'};
        double[] fryCost = {5.00, 6.00, 7.00};
        for (int i = 0; i < 3; i++) {
            setMenuItem(frySize[i] + " Fries", "FoodImages/fries.jpg", foodPanel, fryCost[i]);
        }

        setMenuItem("Cheeseburger Combo", "FoodImages/cheeseburger_combo.jpg", foodPanel, 10);
        setMenuItem("Double Cheeseburger Combo", "FoodImages/double_cheeseburger_combo.jpg", foodPanel, 10);

        //drink Panel-----

        //create drinks panel
        drinks = new JPanel(new GridLayout(4,4,1,1));

        //create buttons
        setMenuItem("Cola", "FoodImages/cola.PNG", drinkPanel, 3.00);
        setMenuItem("Pepsi", "FoodImages/pepsi.jpg", drinkPanel, 3.00);
        setMenuItem("Sprite", "FoodImages/sprite.jpg", drinkPanel, 3.00);


        drinkPanel.add(drinks,BorderLayout.NORTH); //add buttons to drink panel

        //buttons for drink panel(sizes)-----
        ButtonGroup sizeGroup = new ButtonGroup();
        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] drinkSizes = {"Small", "Medium", "Large"}; //create sizes for drinks
        for (String drinkSize : drinkSizes) {
            setDrinkSize(drinkSize, sizeGroup, sizePanel); //create radioButtons
        }

        drinkPanel.add(sizePanel,BorderLayout.SOUTH);

        //payment panel-----
        ButtonGroup bg = new ButtonGroup();

        String[] paymentType = {"Credit Card", "Venmo", "Cash"};
        for (String s : paymentType) {
            setPaymentTypes(s, bg); //sets payment types
        }

        //creating labels
        JLabel shopping_cart = new JLabel("Shopping Cart");
        shopping_cart.setFont(setDefaultFont(25));

        //button panel for right component
        JPanel buttonPanel = new JPanel();

        //setting button panel to be aligned along left side of right panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //clear and checkout buttons
        JButton clearBtn = new JButton("Clear");
        JButton checkOutBtn = new JButton("Check Out");
        totalLabel = new JLabel("Total: $0.00");
        clearBtn.setPreferredSize(new Dimension(150,50));
        checkOutBtn.setPreferredSize(new Dimension(150,50));
        listModel = new DefaultListModel<>();
        JList<String> itemList = new JList<>(listModel);
        
        buttonPanel.add(checkOutBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(totalLabel);
        buttonPanel.add(itemList);

        clearBtn.addActionListener(new ClearButtonClickListener());
        checkOutBtn.addActionListener(new ButtonClickListener());

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
    //default font generator for the java file
    public Font setDefaultFont (int font) {
        return new Font ("Molto",Font.ITALIC,font);
    }
    
    public void setMenuItem(String foodName, String filePath, JPanel menuPanel, double cost) {
        if (foodPanel != null) {
            foodItem(foodName, filePath, cost);
        }
        else if (drinkPanel != null) {
            drinkItem(filePath, cost);
        }
    }
    
    private void foodItem(String foodName, String filePath, double cost) {
        //creates image icon
        ImageIcon foodIcon = new ImageIcon(getClass().getResource(filePath));
        //create JButton
        JButton foodButton = new JButton(foodName, foodIcon);
        //align text position
        foodButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        foodButton.setHorizontalTextPosition(SwingConstants.CENTER);

        //set action listener
        FoodListener(foodButton, cost);

        //add to food Panel
        foodPanel.add(foodButton);
    }

    private void drinkItem(String filePath, double cost) {
        //create image icon
        ImageIcon drinkImg = new ImageIcon(getClass().getResource(filePath));

        //create JButton
        JButton drinkButton = new JButton(drinkImg);

        //get preferred image size
        drinkButton.setPreferredSize(new Dimension(100,100));

        DrinkListener(drinkButton, cost);

        //add to panel
        drinks.add(drinkButton);
    }
    
    private void FoodListener (JButton foodButton, double cost) {
        foodButton.addActionListener(e -> listModel.addElement("Food: " + foodButton.getText() + " - Cost: $" + cost));
    }
    
    public void setPaymentTypes(String paymentType, ButtonGroup buttonGroup){
        PaymentTypes(paymentType, buttonGroup);
    }
    
    private void PaymentTypes (String paymentType, ButtonGroup buttonGroup) {
        JRadioButton paymentTypeButton = new JRadioButton(paymentType);
        paymentTypeButton.setFont(setDefaultFont(25));
        buttonGroup.add(paymentTypeButton);
        paymentPanel.add(paymentTypeButton);
    }
    
    public void setDrinkSize (String size, ButtonGroup sizeGroup, JPanel sizePanel ) {
        DrinkSize(size, sizeGroup, sizePanel);
    }
    
    private void DrinkSize (String size, ButtonGroup sizeGroup, JPanel sizePanel) {
        JRadioButton drinkSize = new JRadioButton(size);
        sizeGroup.add(drinkSize);
        sizePanel.add(drinkSize);
        DrinkSizeListener(drinkSize);
    }
    
    private void DrinkSizeListener (JRadioButton drinkSize) {
        drinkSize.addActionListener(e -> listModel.addElement("Drink Size: " + drinkSize.getText() + " - Cost: $" + cost));
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double totalCost = calculateTotalCost();
            totalLabel.setText("Total: $" + totalCost);
        }
        private double calculateTotalCost() {
            double totalCost = 0.0;
            for (int i=0; i < listModel.getSize(); i++) {
                String item = listModel.getElementAt(i);
                String[] parts = item.split(" - Cost:\\$");
                if(parts.length == 2) {
                    totalCost += Double.parseDouble(parts[1]);
                }
            }
            return totalCost;
        }
    }

    private class ClearButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            listModel.clear();
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(FinalProject::new);
    }
}
 
