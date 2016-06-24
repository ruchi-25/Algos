/*
 *Program to check for balanced parentheses in an expression using stack.
  Given an expression as string comprising of opening and closing characters
  of parentheses - (), curly braces - {} and square brackets - [], we need to 
  check whether symbols are balanced or not.
  For balanced : Last First to close should be last unclosed
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class BalancedParantheses {
	public boolean areBalancedParantheses(String str){
		if(null == str || str.length() == 0){
			return true;			 
		}
		
		//lenght of string
		int n = str.length();
		
		//Map of parantheses to be compared with
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		
		Stack<Character> s = new Stack<Character>();
		
		for(int i = 0; i < n; i++){
			char c = str.charAt(i);
			
			//check character for opening parantheses
			if(map.keySet().contains(c)){
				s.push(c);
			}//check character for closing parantheses
			else if(map.values().contains(c)){
				//if topmost element in a nonempty stack 
				//is opening parantheses of the current closing parantheses
				if(!s.empty() && map.get(s.peek()) == c){
					s.pop();
				}else{
					return false;
				}
			}
		}
		return s.empty();		
	}
	
	public static void main(String[] args){
		String str = "123[()]123{}{[()()]()}abs";
		System.out.println(new BalancedParantheses().areBalancedParantheses(str));
	}
}
