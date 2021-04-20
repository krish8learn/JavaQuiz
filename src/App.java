import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class App extends JFrame implements ActionListener{
    public static void main(String[] args) throws Exception {
        System.out.println("Application Starting");
        new App();
    }

    JButton b1, b2;
    JTextField t1;
    App(){
        //here we setup the background page
        setBounds(400,200, 1200, 500);
        getContentPane().setBackground(Color.GREEN);
        setLayout(null);

        //load the quiz image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel l1 = new JLabel(i1);
		l1.setBounds(0, 0, 600, 700);
		add(l1);
		
		JLabel l2 = new JLabel("Simple minds");
		l2.setFont(new Font("Viner Hand ITC", Font.BOLD,22));
		l2.setForeground(Color.BLUE);
		l2.setBounds(850, 40, 300, 45);
		add(l2);
		
		JLabel l3 = new JLabel("Enter your name");
		l3.setFont(new Font("Viner Hand ITC", Font.BOLD,17));
		l3.setForeground(Color.BLUE);
		l3.setBounds(850, 130, 300, 20);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(780, 180, 300, 40);
		t1.setFont(new Font("Viner Hand ITC", Font.BOLD,20));
		add(t1);
		

        b1 = new JButton("Click");
        b1.setBounds(780,270,120,20);
        b1.setBackground(new Color(30,144,254));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Exit");
        b2.setBounds(960, 270, 120,20);
        b2.setBackground(new Color(30,144,254));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            String name = t1.getText();
            this.setVisible(false);
            new App1(name);
        }else{
            System.exit(0);
        }
    }
}
