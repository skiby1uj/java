package sqrt;
import java.util.Date;
//pierwiastek n stopnia metoda Newtona
public class mySqrt {

	public static void main(String[] args) {
		/*int n = Integer.parseInt(args[0]);
		double number = Double.parseDouble(args[1]);
		double dopEpsilon = 0.01; 
		double x = sqrt(number, n, dopEpsilon);
		System.out.println("sqrt(" + number + "," + n + ") = " + x);
		System.out.println("With precision: " + dopEpsilon);*/
		Date tim = new Date();
		long tmieIn =  tim.getTime();
		//System.out.println(tmieIn);
		for(int i = 0; i < 1000000; i++){
			pow(2, 1000);
		}
		Date time = new Date();
		long timeOut = time.getTime();
		
		
		//System.out.println(timeOut);
		System.out.println(timeOut-tmieIn);
		tim = new Date();
		tmieIn =  tim.getTime();
		for(int i = 0; i < 1000000; i++){
			pow1(2, 1000);
		}
		time = new Date();
		timeOut = time.getTime();
		timeOut = time.getTime();
		System.out.println(timeOut-tmieIn);
		
	}
	
	private static double sqrt(double number, int n, double dopEpsilon){
		double x = number;
		double epsilon = abs(number - pow(x, n));
		while(epsilon >= dopEpsilon){
			x = (1./n)*((n-1.)*x + (number/pow(x, n-1)));
			epsilon = abs(number - pow(x, n));
		}
		return x;
	}
	
	private static double pow1(double number, int n){
		
		//double output = number;
		double output = 1;
		for(int i = 0; i < n ; i++){
		output *= number;
	}
	
	return output;
	
	}
	
	private static double pow(double number, int n){//algorytm szybkiego potenkowania
		/*Date tim = new Date();
		long tmieIn =  tim.getTime();*/
		double output = number;
		double tmp = 1;
		while(tmp * 2 <= n){
			output *= output;
			tmp *= 2;
		}
		while(tmp < n){
			output *= number;
			tmp ++;
		}
		/*long timeOut = tim.getTime();
		System.out.println(timeOut-tmieIn);*/
		return output;
		
	}
	
	private static double abs(double number) {
		if(number >= 0.){
			return number;
		}
		return number * -1;
	}
}
