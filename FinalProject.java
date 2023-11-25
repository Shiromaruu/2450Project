import javax.swing.*;
import java.awt.*;

public class FinalProject {
    FinalProject(){
        JFrame jfrm = new JFrame("mcdonald's GUI");
        jfrm.setSize(700,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating panel
        JPanel panel = new JPanel();
        JPanel Food = new JPanel();
        JPanel Drink = new JPanel();
        JPanel Payment = new JPanel();


        //creating spit pane
        JSplitPane sp = new JSplitPane();
        sp.setDividerLocation(350);

        //creating tab pane
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Food",Food);
        tp.addTab("Drink",Drink);
        tp.addTab("Payment",Payment);

        //creating labels
        JLabel jlab1 = new JLabel("Shopping Cart");
        JLabel jlab2 = new JLabel("Test");
        jlab1.setFont(new Font("Molto", Font.BOLD, 25));




        //adding label to panels
        panel.add(jlab1);



        //adding respective pane to respective side
        sp.setLeftComponent(tp);
        sp.setRightComponent(panel);


        //add to frame
        jfrm.add(sp);

        //set visible
        jfrm.setVisible(true);

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FinalProject();
            }
        });
    }
}
