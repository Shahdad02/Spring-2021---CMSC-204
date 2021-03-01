/**
 *
 * Notation Class 
 * @author Shah's Thermal
 *
 */
public class Notation {
	
	/**
	 * converts infix to a postfix expression
	 * @param complexInfix used to convert
	 * @return converted postfix
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String complexInfix) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		NotationStack<String> stack = new NotationStack<String>();
		NotationQueue<String> queue = new NotationQueue<String>();
		char[] ch = complexInfix.toCharArray();
		
		try {
			
			for(int i = 0; i < ch.length; i++) {
				
				if(ch[i] == ' ') {
					continue;
					
				} else if(Character.isDigit(ch[i])) {
					queue.enqueue(String.valueOf(ch[i]));
					
				} 
				
				if(ch[i] == '(') {
					stack.push(String.valueOf(ch[i]));
				}
				
				if(ch[i] == '+') {
					if(!stack.isEmpty()) {
						while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*")  || stack.top().equals("/")) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(String.valueOf(ch[i]));
				}
				
				if(ch[i] == '-') {
					if(!stack.isEmpty()) {
						while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*")  || stack.top().equals("/")) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(String.valueOf(ch[i]));
				}
				
				if(ch[i] == '*') {
					if(!stack.isEmpty()) {
						while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*")  || stack.top().equals("/")) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(String.valueOf(ch[i]));
				}
				
				if(ch[i] == '/') {
					if(!stack.isEmpty()) {
						while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*")  || stack.top().equals("/")) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(String.valueOf(ch[i]));
				}
				
				if(ch[i] == ')') {
					while(!stack.isEmpty() && stack.top().equals("(")) {
						queue.enqueue(stack.pop());
						
					}
					if(stack.isEmpty() || !stack.top().equals("(")) {
						throw new InvalidNotationFormatException();
						
					}
					if(!stack.isEmpty() && stack.top().equals("(")) {
						stack.pop();
					}
				}
			}
			
			while(!stack.isEmpty() && stack.top().equals("(")) {
				queue.enqueue(stack.pop());
				
			}
			
		}catch(QueueOverflowException e) {
			e.printStackTrace();
			
		}catch(StackOverflowException ex) {
			ex.printStackTrace();
			
		}catch(StackUnderflowException ue) {
			ue.printStackTrace();
		}
		
		return queue.toString();
	}
	
	/**
	 * 
	 * @param complexPostfix expression to convert
	 * @return converted infix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String complexPostfix) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		String infix, top;
		NotationStack<String> stack = new NotationStack<String>();
		char[] ch = complexPostfix.toCharArray();
		
		try {
			
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == ' ') {
					continue;
					
				} else if(Character.isDigit(ch[i])) {
					stack.push(String.valueOf(ch[i]));
					
				} else if(ch[i] == '+' || ch[i] == '-' || ch[i] == '*' || ch[i] == '/') {
					
					if(stack.size() < 2) {
						throw new InvalidNotationFormatException();
						
					} else {
						top = stack.pop();
						infix = "(" + stack.pop() + ch[i] + top + ")";
						stack.push(infix);
						
					}
				}
			}
			if(stack.size() > 1) {
				throw new InvalidNotationFormatException();
				
			}
		} catch(StackUnderflowException e) {
			e.printStackTrace();
			
		} catch(StackOverflowException ex) {
			ex.printStackTrace();
			
		}
		
		return stack.toString();
	}
	
	/**
	 * this completes the calculation between variables
	 * @param one parsed as double to calculate
	 * @param two parsed as double to calculate
	 * @param ch operator to be used to calculate the two variables
	 * @return calculation result
	 */
	private static double operation(String one, String two, char ch) {
		double result = 0;
		double first, second;
		
		switch(ch) {
		case '+':
			first = Double.parseDouble(one);
			second = Double.parseDouble(two);
			result = first + second;
			break;
		
		case '-':
			first = Double.parseDouble(one);
			second = Double.parseDouble(two);
			result = first - second;
			break;
			
		case '*':
			first = Double.parseDouble(one);
			second = Double.parseDouble(two);
			result = first * second;
			break;
			
		case '/':
			first = Double.parseDouble(one);
			second = Double.parseDouble(two);
			result = first / second;
			break;
		}
		return result;
	}
	
	/**
	 * 
	 * @param complexPostfix to be converted
	 * @return converted postfix to infix
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String complexPostfix) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		double result = 0;
		String first, second;
		NotationStack<String> stack = new NotationStack<String>();
		char[] ch = complexPostfix.toCharArray();
		
		try {
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == ' ') {
					continue;
					
				}else if(Character.isDigit(ch[i]) || ch[i] == '(') {
					stack.push(String.valueOf(ch[i]));
					
				}else {
					if(stack.size() < 2) {
						throw new InvalidNotationFormatException();
						
					}else {
						first = stack.pop();
						second = stack.pop();
						result = operation(first, second, ch[i]);
						stack.push(Double.toString(result));
					}
				}
			}
			if(stack.size() > 1) {
				throw new InvalidNotationFormatException();
			}
		} catch(StackOverflowException e) {
			e.printStackTrace();
			
		} catch(StackUnderflowException ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
