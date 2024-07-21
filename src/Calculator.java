import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//ActionLIstener is an action event occurs when we click a button, press enter etc.
public class Calculator implements ActionListener{ 

    //JFrame require base container for all grafical components.
    JFrame frame;
    JTextField textfield;
    JButton [] numberButtons = new JButton[10];  // Arrays for num btn.
    JButton [] functionButtons = new JButton[8];  // Arrays for fun btn.
    JButton addButton, subButton, mulButton, divButton; // global var declaration.
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel; // organise components, layout set on frame.

    Font myfont = new Font("Ink Free", Font.BOLD, 36);
     
    double num1=0, num2=0, result=0;
    char operator;

    Calculator(){

        // set the frame 
         frame = new JFrame("Calculator"); // title yr frame
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close the frame
         frame.setSize(420, 550);
         frame.setLayout(null);

         // set the textfield area on the frame
         textfield = new JTextField();
         textfield.setBounds(50, 25, 300, 50);
         textfield.setFont(myfont);
         textfield.setEditable(false);

         // crate buttons
         addButton = new JButton("+");
         subButton = new JButton("-");
         mulButton = new JButton("*");
         divButton = new JButton("/");
         decButton = new JButton(".");
         equButton = new JButton("=");
         delButton = new JButton("Delete");
         clrButton = new JButton("Clear");

         functionButtons[0] = addButton;
         functionButtons[1] = subButton;
         functionButtons[2] = mulButton;
         functionButtons[3] = divButton;
         functionButtons[4] = decButton;
         functionButtons[5] = equButton;
         functionButtons[6] = delButton;
         functionButtons[7] = clrButton;

         for(int i=0; i<8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false); // for no outline in btn
         }
        
         for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
         }

         delButton.setBounds(50, 430, 145, 50);
         clrButton.setBounds(205, 430, 145, 50);

         panel = new JPanel(); // to add panel on the frame
         panel.setBounds(50, 100, 300, 300);
         panel.setLayout(new GridLayout(4,4,10,10));
          //panel.setBackground(Color.GRAY);
          
          // row - 1
         panel.add(numberButtons[1]);
         panel.add(numberButtons[2]);
         panel.add(numberButtons[3]);
         panel.add(addButton);

         // row - 2
         panel.add(numberButtons[4]);
         panel.add(numberButtons[5]);
         panel.add(numberButtons[6]);
         panel.add(subButton);

         // row - 3
         panel.add(numberButtons[7]);
         panel.add(numberButtons[8]);
         panel.add(numberButtons[9]);
         panel.add(mulButton);

         // row - 4
         panel.add(decButton);
         panel.add(numberButtons[0]);
         panel.add(equButton);
         panel.add(divButton);
        
         frame.add(panel);
         frame.add(delButton);
         frame.add(clrButton);
         frame.add(textfield);
         frame.setVisible(true);
    }



    public static void main(String args[]){
         Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0; i<10; i++){ 
            if(e.getSource() == numberButtons[i]){ // for action perform of number buttons in textfield.
                // here use concatenation of string val
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton){ // add dec btn to action perform.
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == addButton){ 
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton){ 
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulButton){ 
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton){ 
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource() == equButton){ 
            num2 = Double.parseDouble(textfield.getText());
            
            switch(operator){
                case'+' :
                     result = num1+num2;
                     break;
                case'-' :
                     result = num1-num2;
                     break;
                case'*' :
                     result = num1*num2;
                     break;
                case'/' :
                     result = num1/num2;
                     break;
                }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
         if(e.getSource() == clrButton){ 
            textfield.setText("");
        }
        if(e.getSource() == delButton){ 
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0; i<string.length()-1; i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
    }
}
