import java.util.ArrayList;
import java.util.Stack;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;
public class calculator extends JFrame implements ActionListener ,KeyListener {
   static TextField inbox = new TextField();
   static TextField outbox = new TextField();
    pbutton buttons [] = new pbutton[35];
    JPanel jp = new JPanel();
    static ArrayList <String> query = new ArrayList <String> ();
    static String outquery = "";
    static long output =0 ;


    public static void main(String[] args) {
            calculator app = new calculator();
    }


    public calculator() {
        super("calculator");
        setSize(500, 500);
	setResizable(false);
	setLocation(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	inbox.setPreferredSize( new Dimension(200,200) );
	outbox.setPreferredSize( new Dimension(200,200) );
	inbox.setFocusable(false);
	outbox.setFocusable(false);
	int bunnum = 0; //buttons number 

	for (int i = 0 ; i < 7; i ++ ) 
	{
		for (int c = 0; c < 5; c++) {
			buttons[bunnum]= new pbutton(instructions.map[i][c]);
			buttons[bunnum].func = (instructions.func[i][c]);
			buttons[bunnum].code = (instructions.code[i][c]);
			buttons[bunnum].scode = (instructions.scode[i][c]);
			jp.add(buttons[bunnum].button);
			buttons[bunnum].button.addActionListener(this);
			buttons[bunnum].button.addKeyListener(this);
			bunnum ++;
		}
	}

	jp.setLayout(new GridLayout (7,5)); // the more not inculded 
        add(jp, BorderLayout.SOUTH);
	add(inbox, BorderLayout.NORTH);
	add(outbox, BorderLayout.CENTER);
        setVisible(true);
	jp.setFocusable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e){
	    System.out.println("button clicked");
	    if( e.getSource() instanceof JButton) {
	      // String out = ((JButton)e.getSource()).getText();
	       // System.out.println(out);
	       pbutton gotButton = getButton((JButton)e.getSource());
	       gotButton.prosess(); // enter the function to prosees the button in any way possible
	       String out = ""; 
	       for (String c : query) //gathering info from the query
		       out+= c;
	       inbox.setText(out);
	       outbox.setText(outquery);
	
    
		}
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

System.out.println("keyTyped");

    }

    @Override
    public void keyPressed(KeyEvent e) {
	System.out.println("keyPressed");		      // String out = ((JButton)e.getSource()).getText();
	       // System.out.println(out);
	       pbutton gotButton = getButton(e.getKeyCode());
	       if (gotButton != null)
	       {
		       System.out.println(gotButton);
		       gotButton.prosess(); // enter the function to prosees the button in any way possible
		       String out = ""; 
		       for (String c : query) //gathering info from the query
			       out+= c;
		       inbox.setText(out);
		       outbox.setText(outquery);
	       }
	       else return;

    }
    @Override
    public void keyReleased(KeyEvent e) {
	System.out.println("keyReleased");

    }
    
    pbutton getButton(JButton input) { 
	for (pbutton x : buttons)
		if (x.button.equals(input))
			return x ; 
	return null ;
    }
    pbutton getButton(int code) { 
	    System.out.println(code);
	for (pbutton x : buttons)
		if (x.code == (code) || x.scode == code )
		{
			// System.out.println("code : " + x.code + "x" + code);
			return x ; 
		}
	return null ;
    }
    
	static void clac (ArrayList query) {
		System.out.println(query);	
		ArrayList <ArrayList <String> >  tokens ; 
		if (logic.valid(query)){
			System.out.println("isValid");
			query = logic.tokinize(query);
			System.out.println(outquery);
			Stack last = logic.getOutput(query);
			outquery = last.toString();
		}
		else{ // done 
			outquery = ("notValid");
		}

	}
    

}
