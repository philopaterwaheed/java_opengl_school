import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
public class pbutton{
	String name ; 
	int val;
	JButton button = new JButton() ; 
	pbutton(String name ) {
		this.name = name ;
		this.button = new JButton(name);
	}
}
class instructions {
	 static String map [][] = {
		 {   "x^3" ,"y^/x" ,"sin-1" ,"cos-1" , "tan-1"} , 
		 {   "1/x" ,"e^x" ,"ln" ,"dms" , "deg"} , 
		 {   "^" ,"ce" ,"c" ,"del" , "%"} , 
		 {   "ℼ" ,"7" ,"8" ,"9" , "x"} , 
		 {   "n!" ,"4" ,"5" ,"6" , "-"} , 
		 {   "+-" ,"1" ,"2" ,"3" , "+"} , 
		 {   "(" ,")" ,"0" ,"." , "="} , 
	 } ;  
	private instructions(){}
}
