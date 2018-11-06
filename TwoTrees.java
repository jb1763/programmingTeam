import java.util.Scanner;

class TwoTrees {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			double xOne = sc.nextDouble();
			double yOne = sc.nextDouble();
			double xTwo = sc.nextDouble();
			double yTwo = sc.nextDouble();
			
			if(xOne == xTwo && yOne == yTwo) {
				System.out.println("Impossible.");
				continue;
			}
			
			double yDiff = yTwo - yOne;
			yDiff = Math.pow(yDiff, 2);
			double xDiff = xTwo - xOne;
			xDiff = Math.pow(xDiff, 2);
			double length = yDiff + xDiff;
			length = Math.sqrt(length);
			
			double midX = (xOne + xTwo)/2;
			double midY = (yOne + yTwo)/2;
			
			double ChangeInX = (xTwo - xOne) * -1;
			double ChangeInY = (yTwo - yOne);
			
			double xOneNew = midX + (ChangeInY * .5) ;
			double yOneNew = midY + (ChangeInX * .5) ;
			double xTwoNew = midX - (ChangeInY * .5) ;
			double yTwoNew = midY - (ChangeInX * .5) ;
			
			String xOneNewString = String.format("%.10f", xOneNew);
			String yOneNewString = String.format("%.10f", yOneNew);
			String xTwoNewString = String.format("%.10f", xTwoNew);
			String yTwoNewString = String.format("%.10f", yTwoNew);
			
			System.out.println(xOneNewString + " " + yOneNewString + " " + xTwoNewString + " " + yTwoNewString);
		}
		
		sc.close();
		
	}

}
