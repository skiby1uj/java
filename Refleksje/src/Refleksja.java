import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Refleksja {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Class cl = Class.forName("java.lang.String");
//		Constructor[] ca = cl.getDeclaredConstructors();
//		for(Constructor c: ca){
//			System.out.println(c);
//		}
//		Constructor c = cl.getConstructor(String.class); // public java.lang.String(java.lang.String)
//		String sAlaMaKota = (String)c.newInstance("Ala ma kota");
//		System.out.println(sAlaMaKota);
//		String[] sa = sAlaMaKota.split(" ");
//		for(String ss: sa){
//			System.out.println(ss);
//		}
//		
//		Method mSplit = cl.getDeclaredMethod("split", String.class);
//		String[] sAla = (String[])mSplit.invoke(sAlaMaKota, " ");
//		for(String s: sAla){
//			System.out.println(s);
//		}
//		Method[] ma = cl.getDeclaredMethods();
//		for(Method m: ma){
//			System.out.println(m.toString());
//		}
		
		//TODO args[0] nazwa klasy implementujaca metode getValue 
		//TODO args[1] poczatek przedzialu calkowania
		//TODO args[2] koniec przedzialu calkowania
		
		Class cl = Class.forName(args[0]);
		Method[] m = cl.getDeclaredMethods();
		Method getVal = cl.getDeclaredMethod("getValue", double.class);

		double xPocz = Double.parseDouble(args[1]);
		double xKon = Double.parseDouble(args[2]);
		double dx = (xKon - xPocz)/10000.;
		
		double calka = 0;
		for(int i = 1; i < 10000; i++){
			double tmp = (double)getVal.invoke(cl.getConstructor().newInstance(), (xPocz + i * dx));
			calka += tmp;
		}
		calka *= dx;
		System.out.println(calka);
//		Method getValueMethod = cl.getDeclaredMethod("getValue", double.class);
//		double d = 50;
//		double var1 = (double) getValueMethod.invoke((double)20);
//		System.out.println(var1);
		
		
	}
}
