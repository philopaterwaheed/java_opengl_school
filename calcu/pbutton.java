import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
public class pbutton{
	String name ; 
	int val;
	JButton button = new JButton() ; 
	String intoInputBox ;
	int func ; 
	int code = 240 ;
	int scode = 240 ;


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
	 void prosesscode ()
	 {
		 if (this.func != 0 && this.func !=1 )
			 exe (this.func) ;
		 else 
			 calculator.query.add(""+this.val);
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
	 static int code [][] = {
		 {-1 ,-2 , -3, -4 ,-5 } , 
		 {-6 ,-7 ,-8, -9 ,-10 } , 
		 {-11 ,-69 , KeyEvent.VK_C, KeyEvent.VK_BACK_SPACE ,KeyEvent.VK_DIVIDE  } , 
		 {-230,  KeyEvent.VK_7,  KeyEvent.VK_8,  KeyEvent.VK_9 ,KeyEvent.VK_MULTIPLY } , 
		 {-18 ,  KeyEvent.VK_4,  KeyEvent.VK_5,  KeyEvent.VK_6 ,KeyEvent.VK_MINUS  } , 
		 {-2,   KeyEvent.VK_1,  KeyEvent.VK_2,  KeyEvent.VK_3 ,KeyEvent.VK_ADD } , 
		 {-20, -20 , -20, -25 , KeyEvent.VK_EQUALS} 

	 } ;  
	 static int scode [][] = {
		 {-1 ,-2 , -3, -4 ,-5 } , 
		 {-6 ,-7 ,-8, -9 ,-10 } , 
		 {-11 ,-69 , KeyEvent.VK_C, KeyEvent.VK_DELETE,47 } , 
		 {-230,  KeyEvent.VK_NUMPAD7,  KeyEvent.VK_NUMPAD8,  KeyEvent.VK_NUMPAD9 ,KeyEvent.VK_MULTIPLY } , 
		 {-18 ,  KeyEvent.VK_NUMPAD4,  KeyEvent.VK_NUMPAD5,  KeyEvent.VK_NUMPAD6 ,109  } , 
		 {-2,   KeyEvent.VK_NUMPAD1,  KeyEvent.VK_NUMPAD2,  KeyEvent.VK_NUMPAD3 ,KeyEvent.VK_ADD } , 
		 {-20, -20 , -20, -25 , KeyEvent.VK_ENTER} 

	 } ;  
	 
	private instructions(){}
}
