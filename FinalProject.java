import javax.swing.*;
import java.awt.*;

public class FinalProject {
    FinalProject(){
        JFrame jfrm = new JFrame("McGUI's GUI");
        jfrm.setSize(700,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating panel
        JPanel panel = new JPanel();
        JPanel foodPanel = new JPanel();
        JPanel drinkPanel = new JPanel();
        JPanel paymentPanel = new JPanel();
        
        //create splitPane
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(350);

        //creating tab pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Food",foodPanel);
        tabbedPane.addTab("Drink",drinkPanel);
        tabbedPane.addTab("Payment",paymentPanel);

        //creating labels
        JLabel shopping_cart = new JLabel("Shopping Cart");
        shopping_cart.setFont(new Font("Molto", Font.BOLD, 25));

        //adding label to panels
        panel.add(shopping_cart);

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
