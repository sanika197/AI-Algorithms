import java.util.*;

public class Main {
	
	static boolean isVariable(String s)  //check whether variable
	{
		if(s.length()==1)
		{
			return true;
		}
		
		return false;
	}
	
	static boolean isFunction(String s)   //check whether function
	{ 
		int ctr;
		ctr = 0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(')
			{
				ctr++;
			}
			if(s.charAt(i)==')')
			{
				ctr++;
			}
		}
		if(ctr>=2)
		{
			return true;
		}
		return false;
	}
	
	static boolean isConstant(String s) //check whether constant value
	{
		if(!isVariable(s) && !isFunction(s))
		{
			return true;
		}
		return false;
	}
	
	static String getPredicate(String exp)  //return the predicate
	{
		String predicate_1;
		predicate_1 = "";
		int i;
		for(i=0;i<exp.length();i++)  //Get the predicate of expression exp
		{
			if(exp.charAt(i)!='(')
			{
				predicate_1 = exp.substring(i,i+1);
			}
			else
			{
				break;
			}
		}
		return predicate_1;
	}
	
	
	static ArrayList<String> getArguments(String s1)  //return the array list of arguments
	{
		int i;
		String argument;
		ArrayList<String> arg_1 = new ArrayList<String>();
		i = 0;
		while(s1.charAt(i)!='(')
		{
			i++;
		}
		i++;
		while(i<s1.length())
		{
			argument = ""; ///*****
			while(s1.charAt(i)!=';' && i<s1.length()-1)
			{
				argument = argument + s1.substring(i,i+1);
				i++;
			}
			i++; //skip delimiter ',' or ')'
			arg_1.add(argument);  //extract and store all arguments of expression 1 in array list
		}
	 
		return arg_1;
	}
	

	static String unify(ArrayList<String> arg_1, ArrayList<String>arg_2, String ith_arg1, String ith_arg2, int i)
	{  
		
		String result;
		result = "";
		if(arg_1.size() == arg_2.size())
		{
			if((isVariable(ith_arg1) && isVariable(ith_arg2)) || (isConstant(ith_arg1) && isConstant(ith_arg2)))
			{
			
				if(ith_arg1.equals(ith_arg2))  //if the variables are constants are equal check other arguments
				{
					result = "null";
				}
							
				else if(isVariable(ith_arg1) && isVariable(ith_arg2))  //if both are variables
				{

					result = ith_arg2+"/"+ith_arg1;  //substitution
					for(int j=0;j<arg_2.size();j++)
					{
						if(arg_2.get(j).equals(ith_arg1))
						{
							arg_2.set(j, ith_arg2);
						}
					}
					for(int j=0;j<arg_1.size();j++)
					{
						if(arg_1.get(j).equals(ith_arg1))
						{
							arg_1.set(j, ith_arg2);
						}
					}
				}
				
				//similarly if both are constant
				else if(isConstant(ith_arg1) && isConstant(ith_arg2))
				{
					if(!ith_arg1.equals(ith_arg2))
					{	
						result = ith_arg1+"/"+ith_arg2;
						for(int j=0;j<arg_2.size();j++)
						{
							if(arg_2.get(j).equals(ith_arg2))
							{
								arg_2.set(j, ith_arg1);
							}
						}
						for(int j=0;j<arg_1.size();j++)
						{
							if(arg_1.get(j).equals(ith_arg2))
							{
								arg_2.set(j, ith_arg1);
							}
						}
					}
				}
				
			}
			
			
			else if(isFunction(ith_arg1) && isFunction(ith_arg2))  //if both arguments are some function
			{
				String i_arg1, i_arg2;
				i_arg1 = ith_arg1.replace(',' , ';');
				i_arg2 = ith_arg2.replace(',' , ';');
				if(getPredicate(i_arg1).equals(getPredicate(i_arg2)) == false)
				{
					result = "fail";
				}
				else
				{
					ArrayList<String> a1 = new ArrayList<String>();
					ArrayList<String> a2 = new ArrayList<String>();
					String ith_a1, ith_a2;
					a1 = getArguments(i_arg1);
					a2 = getArguments(i_arg2);
					
					result = "";  //***
					for(int k=0; k<a1.size();k++)
					{
						ith_a1 = a1.get(k);
						ith_a2 = a2.get(k);
						String ans = unify(a1, a2, ith_a1, ith_a2, k); //recursively call unify for nested functions
						result = result + ans +" ";
						
					}
				}
			}
			
			else if((isFunction(ith_arg1) && !isFunction(ith_arg2)) || (isFunction(ith_arg2) && !isFunction(ith_arg1)))
			{ //if any one is function and other is not.
				ArrayList<String> int_arg = new ArrayList<String>();
				
				
				if(isFunction(ith_arg1) && !isFunction(ith_arg2))
				{
					String para1 = ith_arg1.replace(',' , ';');
					int_arg = getArguments(para1);
					if(int_arg.contains(ith_arg2))
					{
						result = "fail";
					}
					else
					{
						result = ith_arg1+ "/" + ith_arg2; //substitute variable/constant with function
						for(int j=0;j<arg_2.size();j++)
						{
							if(arg_2.get(j).equals(ith_arg2))
							{
								arg_2.set(j, ith_arg1);
							}
						}
						for(int j=0;j<arg_1.size();j++)
						{
							if(arg_1.get(j).equals(ith_arg2))
							{
								arg_1.set(j, ith_arg1);
							}
						}
					}
				}
				else if(isFunction(ith_arg2) && !isFunction(ith_arg1))
				{
					String para2 = ith_arg2.replace(',' , ';');
					int_arg = getArguments(para2);
					if(int_arg.contains(ith_arg1))
					{
						result = "fail";
					}
					else
					{
						result = ith_arg2+"/" + ith_arg1;
						for(int j=0;j<arg_2.size();j++)
						{
							if(arg_2.get(j).equals(ith_arg1))
							{
								arg_2.set(j, ith_arg2);
							}
						}
						for(int j=0;j<arg_2.size();j++)
						{
							if(arg_2.get(j).equals(ith_arg1))
							{
								arg_2.set(j, ith_arg2);
							}
						}
					}
				}

			}
			//substitute the variable with a constant 
			else if(isVariable(ith_arg1) && isConstant(ith_arg2))  
			{
				result = ith_arg2+"/"+ith_arg1; 
				for(int j=0;j<arg_2.size();j++)
				{
					if(arg_2.get(j).equals(ith_arg1))
					{
						arg_2.set(j, ith_arg2);
					}
				}
				for(int j=0;j<arg_2.size();j++)
				{
					if(arg_2.get(j).equals(ith_arg1))
					{
						arg_2.set(j, ith_arg2);
					}
				}
			}
			else if(isVariable(ith_arg2) && isConstant(ith_arg1))
			{
				result = ith_arg1+"/"+ith_arg2;
				for(int j=0;j<arg_2.size();j++)
				{
					if(arg_2.get(j).equals(ith_arg2))
					{
						arg_2.set(j, ith_arg1);
					}
				}
				for(int j=0;j<arg_2.size();j++)
				{
					if(arg_2.get(j).equals(ith_arg2))
					{
						arg_2.set(j, ith_arg1);
					}
				}
			}
			else 
			{
				result = "fail";  //else fail
			}
		}
		else
		{
			result = "fail";  //fail if parameter length does not match
		}
		
		return result;
	}
	
	static ArrayList<String> solution(ArrayList<String> arg_1, ArrayList<String> arg_2)
	{
		ArrayList<String> sol = new ArrayList<String>();
		String result;
		int i;
		for(i=0;i<arg_1.size();i++)
 		{
			result = unify(arg_1, arg_2, arg_1.get(i), arg_2.get(i), i); //call unify on the arguments from both expression
			
			//add the result in the solution set
			if(result.equals("fail"))
			{
				sol.add(result);
				break;
			}
			else if(!result.equals("null") && result.contains(" "))
			{
				String res[] = new String[10];
				res = result.split(" ");
				for(String r: res)
				{
					sol.add(r);
				}
			}
			else if(result.equals("null")==false)
			{
				sol.add(result);
			}
		}
		return sol;
	}
	
	public static void main(String[] args) {
		String str1, str2;
		int i;
		
		Scanner sc = new Scanner(System.in);
		
		//Accept 2 logical expression
		System.out.println("Enter the first expression: ");
		str1 = sc.next();
		System.out.println("Enter the second expression: ");
		str2 = sc.next();
		
		ArrayList<String> arg_1 = new ArrayList<String>();
		ArrayList<String> arg_2 = new ArrayList<String>();
		ArrayList<String> subs = new ArrayList<String>();
		
		//Get the arguments of both the expressions
		arg_1 = getArguments(str1);
		arg_2 = getArguments(str2);
		
		if(!getPredicate(str1).equals(getPredicate(str2)))  //if predicates don't match
		{
			System.out.println("Unification not possible!");
		}
		else if(arg_1.equals(arg_2))
		{
			System.out.println("Already unified!");  //if the input expressions are already unified.
		}
		else
		{
			subs = solution(arg_1, arg_2);
			
			if(subs.contains("fail"))
			{
				System.out.println("Unification not possible!"); //if any one of the substitution fails return error message
			}
			
			 
			else
			{
				i = 0;
				System.out.println("Unification possible!\nThe substitutions are as follows: ");
				while(i<subs.size())
				{
					if(subs.get(i).equals("null")==false) 
					{
						System.out.print("["+subs.get(i)+"] ");  //displaying the proper substitutions
					}
					i++;
				}
			}
		}
			
		
	}
}	

