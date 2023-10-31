import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Stack;


public class logic {
	public static boolean  valid (ArrayList query) {
		return (validBrace(query)&& validOp(query)&&validneg(query)) ; 
	}
  

public static boolean  validneg (ArrayList query) { 
	for (int i =1 ; i < query.size()-1 ; i ++){
		if (Character.isDigit(((String)query.get(i-1)).charAt(0)) && ((String)query.get(i))=="+-")
			return false ; 
		
	}
	return true;
}
public static boolean  validOp (ArrayList query) {
	String [] op = {"+" , "-" , "/","x"} ;
	// String [] operated = (String[])(query.toArray());

	// System.out.println("insde op" + operated);
	//
	if (query != null )
	for (int i =0 ; i < op.length ; i++)
			if (!query.isEmpty()) // tot check becuase size == 0;
				if ((String)query.get(query.size()-1) == op[i]) // if there is an operator at the begin 
					return false;

	boolean lastIsOp = true; // bolean to see if the -1 char is an operator 
	if (query != null || query.isEmpty())
	for (Object c : query)
		{
			for (int i =0 ; i < op.length ; i++)
			{
					if ((String) c == op [i] && lastIsOp == true )
						return false;
					else if ((String) c == op[i] && lastIsOp == false)
					{
						lastIsOp = true ; 
						break ;
					}
				if ( i == op.length -1)
					lastIsOp = false; 
			}

		}

	return true ;
}


public static boolean  validBrace (ArrayList query) {

	Stack<String> s = new Stack<>();
		for (Object c : query) 
			if (s.size() > 0 && isClosing(s.peek(), (String)c)) s.pop(); 
			else if ( isEnter( (String)c) )s.push((String)c);
		System.out.println(query);
		return s.size() == 0;
}


static public boolean isEnter(String x) {
		return (x == "{"  || x == "(" || x == "[" );
	}


static public boolean isClosing(String x, String c) {
		return (x == "{" && c == "}") || (x == "(" && c == ")") || (x == "[" && c == "]");
	}


public static ArrayList <String> tokinize (ArrayList query) {
	ArrayList <String> output = new ArrayList<String> ();
	for (int i = 0 ; i < query.size() ; i++ )	
	{
		System.out.println(query.get(i));
			if (output.isEmpty()) //check if empty and ad the number
				output.add((String)query.get(i));
			else // if the output is not empty
			{
				if (Character.isDigit((output.get(output.size()-1).charAt(0)))) //if the last is a digit
				{
					String temp =(String) output.get(output.size()-1); // the last number 
					
					if (Character.isDigit(((String)query.get(i)).charAt(0)))// if the last is digit we add it 
					{
						System.out.println("x"+query.get(i));
						temp += (String) query.get(i);
						output.remove(output.size()-1);
						output.add(temp);
					}
					else
						// if a op cut and add op 
					{
						System.out.println("cx"+query.get(i));
						output.add((String)query.get(i));
					}
				}
				else
					// if the last is op then add the number
				{
					System.out.println("xx"+query.get(i));
					output.add((String)query.get(i));
				}
			}
	}
	return output;
}

public static Stack<String> getOutput(ArrayList query) {
	String order [] = {"x" , "/" , "+" , "-"};
	Stack<String> prosess = new Stack<String>();
	Stack<String> notvalid = new Stack<String>();
	notvalid.add("notvalid");
	Stack<String> temp = new Stack<String>();
	int i = 0 ; 
	boolean neg = false;
	for (Object q : query) {
		System.out.println(q);
		if ((String)q!="+-"){
			for (int j = 0 ; j  < order.length; j++)
				if (neg == true && (String) q == order[j])
						return notvalid;
			if (neg != true)
			prosess.add((String)q);
			else 
				prosess.add ("-"+q);

		}
		else{
			neg = true;
		}
	}
	 
	// for(int i = 0 ; i < 3 ; i++)
	while(prosess.size()>1)
	{
		if (i> 3)
			break;
		// while(prosess.size()>1)
			System.out.println("inside"+ i + prosess.toString());
			// for (int c = 0 ; c < query.size() ; c++)
			while (!prosess.isEmpty())
			 // if ((String) query.get(c) == order[i])
				{
					
					try {
					String poped  = prosess.pop();
					if (poped.equals(order[i]))
					{
						double first = Double.parseDouble(prosess.pop()) ; 
						double second = Double.parseDouble(temp.pop()) ; 					double third =69;
						switch (order[i]) {
							case "x":
								third =second * first;
								break;

							case "/":
								if (first == 0)
									return notvalid;
								third =second / first;
								break;
							case "+":
								third =second + first;
								break;
							case "-":
								third =second - first;
								break;
							default:
								break;
						}
						temp.add(""+third);
					}


					else
					{
						temp.add(poped)	;
					}
				}
				catch(NumberFormatException nfe){
					return notvalid;
				}
				}
			prosess.addAll(temp);
			if (!temp.contains(order[i]))
			{
				i++; 
				temp.clear();
			}
			temp.clear();
	}

	return prosess;
}

}
