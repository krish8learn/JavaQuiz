import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
    
    JButton next,submit, lifeline;
    JLabel qno, question;
    String q[][] = new String[10][5];
    String correctAns [][] = new String[10][2];
    JRadioButton op1, op2, op3, op4;
    ButtonGroup group;
    String ans[][] = new String[10][1];
    public static int count = 0;
    public static int ansgiven = 0;
    public int timer = 15;
    public static int score = 0;
    String username ="";
    Quiz(String username){
        this.username = username;
        setBounds(250,50,1440,950);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1440,392);
        add(l1);

        qno = new JLabel();
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setBounds(100,450, 50, 30);
        add(qno);

        question = new JLabel();
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setBounds(150,450, 900, 50);
        add(question);


        q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";


        correctAns[0][1] = "JDB";
        correctAns[1][1] = "int";
        correctAns[2][1] = "java.util package";
        correctAns[3][1] = "Marker Interface";
        correctAns[4][1] = "Heap memory";
        correctAns[5][1] = "Remote interface";
        correctAns[6][1] = "import";
        correctAns[7][1] = "Java Archive";
        correctAns[8][1] = "java.lang.StringBuilder";
        correctAns[9][1] = "Bytecode is executed by JVM";

        op1 = new JRadioButton();
        op1.setFont(new Font("Dialog", Font.PLAIN, 22));
        op1.setBounds(170, 520, 700, 30);
        add(op1);

        op2 = new JRadioButton();
        op2.setFont(new Font("Dialog", Font.PLAIN, 22));
        op2.setBounds(170, 550, 700, 30);
        add(op2);

        op3 = new JRadioButton();
        op3.setFont(new Font("Dialog", Font.PLAIN, 22));
        op3.setBounds(170, 580, 700, 30);
        add(op3);

        op4 = new JRadioButton();
        op4.setFont(new Font("Dialog", Font.PLAIN, 22));
        op4.setBounds(170, 610, 700, 30);
        add(op4);

        group = new ButtonGroup();
        group.add(op1);
        group.add(op2);
        group.add(op3);
        group.add(op4);

        next = new JButton("Next");
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.setBounds(1100,550, 200, 40);
        next.addActionListener(this);
        add(next);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));

        lifeline = new JButton("50-50");
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.setBounds(1100,600, 200, 40);
        lifeline.addActionListener(this);
        add(lifeline);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));

        submit = new JButton("Submit");
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.setBounds(1100,650, 200, 40);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        
        start(0);
    }

    public void start (int count){
        qno.setText((count+1)+".");
        question.setText(q[count][0]);
        op1.setLabel(q[count][1]);
        op1.setActionCommand(q[count][1]);
        op2.setLabel(q[count][2]);
        op2.setActionCommand(q[count][2]);
        op3.setLabel(q[count][3]);
        op3.setActionCommand(q[count][3]);
        op4.setLabel(q[count][4]);
        op4.setActionCommand(q[count][4]);
        group.clearSelection();
    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == next){
            ansgiven = 1;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);
            repaint();
            if(group.getSelection() == null){
                ans[count][0] = "";
            }else{
                ans[count][0] = group.getSelection().getActionCommand();
            }
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }else if(ae.getSource() == submit){
            ansgiven = 1;
            if(group.getSelection() == null){
                ans[count][0] = "";
            }else{
                ans[count][0] = group.getSelection().getActionCommand();
            }

            for(int i=0; i<ans.length; i++){
                if(ans[i][0].equals(correctAns[i][1])){
                    score += 10;
                }else{
                    score +=0;
                }
            }
            this.setVisible(false);
            new score(username, score).setVisible(true);
        }else if (ae.getSource()==lifeline){
            if(count==2 || count == 4 || count == 6 || count == 8 || count == 9){
                op2.setEnabled(false);
                op3.setEnabled(false);
            }else{
                op1.setEnabled(false);
                op4.setEnabled(false);
            }
        }     
    }

    public void paint(Graphics g){
        super.paint(g);
        String time = "Time Left - " + timer + "s"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        
        if(timer >0){
            g.drawString(time, 1100, 500);
        }else{
            g.drawString("Times Up", 1100, 500);
        }
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }

        if(ansgiven == 1){
            ansgiven = 0;
            timer = 15;
        }else if(timer<0){
            timer = 15;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if(count== 9){
                if(group.getSelection() == null){
                    ans[count][0] = "";
                }else{
                    ans[count][0] = group.getSelection().getActionCommand();
                }

                for(int i=0; i<ans.length; i++){
                    if(ans[i][0].equals(correctAns[i][1])){
                        score += 10;
                    }else{
                        score +=0;
                    }
                }
                this.setVisible(false);
                new score(username, score).setVisible(true);
            }else{
                if(group.getSelection() == null){
                    ans[count][0] = "";
                }else{
                    ans[count][0] = group.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    
    }

    public static void main(String[] args) {
        new Quiz("").setVisible(true);
    }
}
