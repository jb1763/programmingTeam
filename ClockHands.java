import java.util.Scanner;

public class ClockHands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String time = sc.next();
			if(time.equals("0:00")) {
				break;
			}
			String hour;
			String minute;
			if(time.length() == 5) {
				hour = time.substring(0, 2);
				minute = time.substring(3, 5);
			} else {
				hour = time.substring(0, 1);
				minute = time.substring(2, 4);
			}
			
			double hourNum = Double.parseDouble(hour);
			double minuteNum = Double.parseDouble(minute);
			
			double Hangle = (hourNum * 30 + (minuteNum * .5)) % 360;
			double Mangle = (minuteNum * 6);
			
			double Fangle = Math.abs(Hangle - Mangle);
			
			if(Fangle > 180) {
				Fangle = 360 - Fangle;
			}
			String output = String.format("%.3f", Fangle);
			System.out.println(output);		
			
			
			
			
		}
	}

}
