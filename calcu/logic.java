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
			if (!query.isEmpty())
			if ((String)query.get(query.size()-1) == op[i])
				return false;

	boolean lastIsOp = true;
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
}
