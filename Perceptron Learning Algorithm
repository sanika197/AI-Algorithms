import java.util.*;

public class Main {
	
	static void AND_Gate(double w1, double w2, double theta, double learningRate, int itr) {
		int truth_Table[][] = {{0,0,0}, {0,1,0}, {1,0,0}, {1,1,1}};  //Truth table for 2 input AND gate
		int i, A, B, Yexp, Yact;
		double Wsum;
		
		for(i=0;i<4;i++)
		{
			A = truth_Table[i][0];  //Get input x1
			B = truth_Table[i][1];  //Get input x2
			Yexp = truth_Table[i][2];  //Get the expected output
			Wsum = w1*A + w2*B;  //Calculate weighted sum
			
			
			//compare with threshold value
			if(Wsum<theta)
			{
				Yact = 0;
			}
			else
			{
				Yact = 1;
			}
			
			if(Yact!=Yexp) //if the actual output is not equal to expected output
			{
				//Calculate and update the weights
				if(i==0)
				{
					System.out.println("\nIteration: "+itr+"\nx1\tx2\tYexp\tYact\tError\tw1\tw2"); 
				}
				w1 = w1 + learningRate*(Yexp - Yact)*A;
				w2 = (w2) + learningRate*(Yexp - Yact)*B;
				System.out.println(A+"\t"+B+"\t"+Yexp+"\t"+Yact+"\t"+(Yexp-Yact)+"\t"+w1+"\t"+w2); //Enter the values in o/p table
				System.out.println("------------------------------------------------------------\n");
				itr++;
				Analyze(-1,w1,w2,theta,learningRate,itr);
				break;
				
			}
			else
			{
				if(i==0)
				{
					System.out.println("\nIteration: "+itr+"\nx1\tx2\tYexp\tYact\tError\tw1\tw2");  //Represent each iteration in tabular format
				}
				System.out.println(A+"\t"+B+"\t"+Yexp+"\t"+Yact+"\t"+(Yexp-Yact)+"\t"+w1+"\t"+w2);
				
			}
		}
		
		
	}
	static void OR_Gate(double w1, double w2, double theta, double learningRate, int itr)
	{
		int truth_Table[][] = {{0,0,0}, {0,1,1}, {1,0,1}, {1,1,1}};  //Truth table for 2 input OR gate
		int i, j, A, B, Yexp, Yact;
		double Wsum;
		
		for(i=0;i<4;i++)
		{
			A = truth_Table[i][0];  //Get input x1
			B = truth_Table[i][1];  //Get input x2
			Yexp = truth_Table[i][2];  //Get the expected output
			Wsum = w1*A + w2*B;  //Calculate weighted sum
			
			
			//compare with threshold value
			if(Wsum<theta)
			{
				Yact = 0;
			}
			else
			{
				Yact = 1;
			}
			
			if(Yact!=Yexp) //if the actual output is not equal to expected output
			{
				//Calculate and update the weights
				if(i==0)
				{
					System.out.println("\nIteration: "+itr+"\nx1\tx2\tYexp\tYact\tError\tw1\tw2"); 
				}
				w1 = w1 + learningRate*(Yexp - Yact)*A;
				w2 = w2 + learningRate*(Yexp - Yact)*B;
				System.out.println(A+"\t"+B+"\t"+Yexp+"\t"+Yact+"\t"+(Yexp-Yact)+"\t"+w1+"\t"+w2); //Enter the values in o/p table
				System.out.println("------------------------------------------------------------\n");
				itr++;
				AnalyzeOR(-1,w1,w2,theta,learningRate, itr);
				break;
				
			}
			else
			{
				if(i==0)
				{
					System.out.println("\nIteration: "+itr+"\nx1\tx2\tYexp\tYact\tError\tw1\tw2");  //Represent each iteration in tabular format
				}
				System.out.println(A+"\t"+B+"\t"+Yexp+"\t"+Yact+"\t"+(Yexp-Yact)+"\t"+w1+"\t"+w2);
				
			}
		}
		
		
	}
	
	
	static void Analyze(int status,double w1, double w2, double theta, double learningRate, int itr)
	{
		if(status==-1)
		{
			AND_Gate(w1, w2, theta, learningRate, itr);
		}
	}
	
	static void AnalyzeOR(int status,double w1, double w2, double theta, double learningRate, int itr)
	{
		if(status==-1)
		{
			OR_Gate(w1, w2, theta, learningRate, itr);
		}
	}
	
	
	public static void main(String[] args) {
		double w1, w2, learningRate, theta;
		int ch;
		w1 = 0.0;
		w2 = 0.0;
		learningRate = 0.0;
		theta = 0.0;
		
		Scanner sc = new Scanner(System.in);
		//Input weights corresponding to 2 input values
		System.out.print("Enter weight 1: ");
		w1 = sc.nextDouble();
		
		System.out.print("Enter weight 2: ");
		w2 = sc.nextDouble();
		
		//Accept threshold from user
		System.out.print("Enter threshold value: ");
		theta = sc.nextDouble();
		
		//Accept the learning rate of perceptron training
		System.out.print("Enter the learning rate: ");
		learningRate = sc.nextDouble();
		
		do {
			System.out.println(" M E N U ");
			System.out.println("1. AND Gate\n2. OR Gate\n3. EXIT");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();
		
			switch(ch)
			{
			case 1: AND_Gate(w1, w2, theta, learningRate, 1);
				break;
				
			case 2: OR_Gate(w1, w2, theta, learningRate, 1);
				break;
				
			case 3: System.out.println("End of Program");
				break;
				
			default: System.out.println("Invalid input!");
				break;
			}
			}while(ch!=3);
	}

}

