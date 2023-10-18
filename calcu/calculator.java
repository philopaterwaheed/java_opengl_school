import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class calculator extends JFrame implements ActionListener {
    TextField box = new TextField();
    pbutton buttons [] = new pbutton[35];
    JPanel jp = new JPanel();
    public static void main(String[] args) {
            calculator app = new calculator();
    }
    public calculator() {
        super("calculator");
        setSize(500, 500);
	setResizable(false);
	this.setLocation(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	box.setSize(300,400);
	
	int bunnum = 0;
	for (int i = 0 ; i < 7; i ++ ) 
	{
		for (int c = 0; c < 5; c++) {
			buttons[bunnum]= new pbutton(instructions.map[i][c]);
			jp.add(buttons[bunnum].button);
			buttons[bunnum].button.addActionListener(this);
			bunnum ++;
		}
	}

	jp.setLayout(new GridLayout (7,5)); // the more not inculded 
        add(jp, BorderLayout.SOUTH);
	add(box, BorderLayout.SOUTH);
        setVisible(true);
	jp.setFocusable(false);
	System.out.println("hello");
    }
    @Override
    public void actionPerformed(ActionEvent e){
	    System.out.println("button clicked");
	    if( e.getSource() instanceof JButton) {
	      String out = ((JButton)e.getSource()).getText();
	       System.out.println(out);
    
    	}
    }

}
