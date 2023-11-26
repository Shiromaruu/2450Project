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

        //drink Panel
        ImageIcon colaImg=new ImageIcon(getClass().getResource("cola.png"));
        ImageIcon sprImg=new ImageIcon(getClass().getResource("sprite.png"));
        JButton cola=new JButton(colaImg);
        JButton sprite=new JButton(sprImg);

        cola.setPreferredSize(new Dimension(100,100));
        sprite.setPreferredSize(new Dimension(100,100));

        drinkPanel.add(cola);
        drinkPanel.add(sprite);

        JScrollBar jVert=new JScrollBar(Adjustable.VERTICAL,0,50,0,300);
        drinkPanel.add(jVert);


        //payment panel
        JRadioButton cc=new JRadioButton("Credit Card");
        JRadioButton ven=new JRadioButton("Venmo");
        JRadioButton cash=new JRadioButton("Cash");

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
