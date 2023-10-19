import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class calculator extends JFrame implements ActionListener {
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
	
	inbox.setPreferredSize( new Dimension(50,50) );
	int bunnum = 0; //buttons number 

	for (int i = 0 ; i < 7; i ++ ) 
	{
		for (int c = 0; c < 5; c++) {
			buttons[bunnum]= new pbutton(instructions.map[i][c]);
			buttons[bunnum].func = (instructions.func[i][c]);
			jp.add(buttons[bunnum].button);
			buttons[bunnum].button.addActionListener(this);
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
    
    pbutton getButton(JButton input) { 
	for (pbutton x : buttons)
		if (x.button.equals(input))
			return x ; 
	return null ;
    }
    
	void clac (ArrayList query) {
		
		ArrayList <ArrayList <String> >  

	}
    

}
