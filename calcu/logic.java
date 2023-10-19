import java.util.Stack;
import java.util.ArrayList;


public class logic {
	public static boolean  valid (ArrayList query) {
		return (validBrace(query)&& validOp(query)) ; 
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
		if (Character.isDigit(((String)query.get(i)).charAt(0)))
			if (output.isEmpty())
				output.add((String)query.get(i));
			else
				if (Character.isDigit(output.get(output.size()-1).charAt(output.get(output.size()-1).length()-1)))
				{
					String temp = output.get(output.size() -1); 
					temp += (String) query.get(i);
					output.add(temp);
				}
				else
				{
					output.add((String)query.get(i));
				}
	}
	return output;
}

}
