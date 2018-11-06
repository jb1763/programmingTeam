import java.util.Arrays;
import java.util.Scanner;

public class KeyToCryptography {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String word = scan.nextLine();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		
		// Each row new row is a letter in an alphabet
		// 
		int[][] grid = new int[27][word.length()+1];
		
		for(int i = 0; i < 27 || i < word.length()+1; i++)
		{
			if(i<27) {
				grid[i][0] = i;
			}
			
			if(i<word.length()+1) {
				grid[0][i] = i;
			}
		}
		
		for(int m = 1; m < 27; m++) {
			
			for(int n = 1; n < word.length()+1; n++) {
				
				char alphaM = alpha.charAt(m-1);
				char wordN = word.charAt(n-1);
				
				if(alphaM != wordN) {
					//mismatch
					int left = grid[m][n-1];
					int diag = grid[m-1][n-1]+1;
					int up = grid[m-1][n]+1;
					
					int lowest = (left<diag)? left:diag;
					lowest = (lowest<up)? lowest:up;
					
					grid[m][n] = lowest;
				} else {
					grid[m][n] = grid[m-1][n-1];
				}
				
			}
			
		}
		System.out.println('\n');
		for(int i = 0; i<word.length()+1;i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		System.out.println(grid[26][word.length()]);
		
		
	}
}
