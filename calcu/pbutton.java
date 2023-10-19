import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
public class pbutton{
	String name ; 
	int val;
	JButton button = new JButton() ; 
	String intoInputBox ;
	int func ; 


	pbutton(String name ) {
		this.name = name ;
		this.button = new JButton(name);
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(this.button.equals((JButton)obj));
	}
	/*
	 * execution of a button when pressed ;
	 *
	 */
	 void exe (int code) {
		 switch (code)
		 {
			case 69 : // c , ce
				 calculator.query.clear();
				 break ; 
			case 99 : //  = 
				  //
				 if (calculator.query != null){
		/* 			calculator.outquery =  calculator.query.toString(); */
					calculator.clac(calculator.query);
					calculator.query.clear();
				 }

				 break;
			case -1 :
				 if (!calculator.query.isEmpty())
				 calculator.query.remove(calculator.query.size()-1);
				 break;
			case -2 :
				 break; 
		}
	 }


	 void prosess ()
	 {
		 if (this.func != 0 && this.func !=1 )
			 exe (this.func) ;
		 else 
			 calculator.query.add(this.name);
	 }
	 
}
/**
 * 
 */
class instructions {
	 static String map [][] = {
		 {   "x^3" ,"y^/x" ,"sin-1" ,"cos-1" , "tan-1"} , 
		 {   "1/x" ,"e^x" ,"ln" ,"dms" , "deg"} , 
		 {   "^" ,"ce" ,"c" ,"del" , "/"} , 
		 {   "ℼ" ,"7" ,"8" ,"9" , "x"} , 
		 {   "n!" ,"4" ,"5" ,"6" , "-"} , 
		 {   "+-" ,"1" ,"2" ,"3" , "+"} , 
		 {   "(" ,")" ,"0" ,"." , "="} , 
	 } ;  
	 static int func [][] = {
		 {1 ,2 , 3, 4 ,5 } , 
		 {6 ,7 , 8, 9 ,10 } , 
		 {11 ,69 , 69, -1 , 1 } , 
		 {0, 0, 0, 0 , 1 } , 
		 {18 , 0, 0, 0 ,1  } , 
		 {-2,  0, 0, 0 ,1 } , 
		 {0, 0 , 0, 25 ,99 } 
		 // 0 are just numbers so no funtion
		 // 1 for basic operations  
	 } ;  
	 
	private instructions(){}
}
