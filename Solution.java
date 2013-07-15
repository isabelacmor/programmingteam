import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		String blank = in.nextLine();
		for(int i = 0; i < numCases; i++){
			String line = in.nextLine();
			
			Queue<String> q = buildQ(line);
			Queue<String> p = new LinkedList<String>();
			//System.out.println(q);
			
			//transform infix to postfix
			Stack s = new Stack();
			
			while(!q.isEmpty()){
				//number
				if(!q.peek().equals("*") && !q.peek().equals("/") && !q.peek().equals("+") && !q.peek().equals("-") && !q.peek().equals("(") && !q.peek().equals(")")){
					p.add(q.poll());
				}
				//left parenthesis
				else if(q.peek().equals("(")){
					s.push(q.poll());
				}
				//right parenthesis
				else if(q.peek().equals(")")){
					while(!s.isEmpty() && !s.peek().equals("(")){
						p.add((String) s.pop());
					}
					s.pop(); //pops (
				}
				//operator
				else if(q.peek().equals("*") || q.peek().equals("/") || q.peek().equals("+") || q.peek().equals("-")){
					if(s.isEmpty() || s.peek().equals("(")){
						s.push(q.poll());
					}
					else{
						while(!s.isEmpty() && !s.peek().equals("(") && prec(q.peek()) <= prec((String)s.peek())){
							p.add((String) s.pop());
						}
						s.push(q.poll());
					}
				}
				//never gets here
				else{}
			}
			
			while(!s.empty()){
				p.add((String) s.pop());
			}
			
			//System.out.println(p);
			
			evalPostFix(p);
		}
	}
	
	public static int prec(String op){
		if(op.equals("*") || op.equals("/")) return 1;
		else return 0;
	}
	
	public static Queue<String> buildQ(String s){
		Queue<String> q = new LinkedList<String>();
		
		Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))");
		Matcher m = pattern.matcher(s);
		while(m.find()) {
		    q.add(m.group());
		}
		
		return q;
	}
	
	public static void evalPostFix(Queue<String> p){
		Stack s = new Stack();
		
		while(!p.isEmpty()){
			//number
			if(!p.peek().equals("*") && !p.peek().equals("/") && !p.peek().equals("+") && !p.peek().equals("-") && !p.peek().equals("(") && !p.peek().equals(")")){
				s.push(p.poll());
			}
			//operator
			else{
				int a = Integer.parseInt((String)s.pop());
				int b = Integer.parseInt((String)s.pop());
				String op = p.poll();
				//System.out.println(b + " " + op + " " + a);
				if(op.equals("+")) s.push(Integer.toString(b+a));
				else if(op.equals("-")) s.push(Integer.toString(b-a));
				else if(op.equals("*")) s.push(Integer.toString(b*a));
				else s.push(Integer.toString(b/a));
			}
		}
		
		System.out.println(s.pop());
	}
}
