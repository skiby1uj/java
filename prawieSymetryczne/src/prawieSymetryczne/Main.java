package prawieSymetryczne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
		static File plik = null;
		static Scanner scanner = null;
		static Map<String, Integer> slowa = new HashMap<String, Integer>();
		static Pattern pattern = Pattern.compile("[^(a-zA-Z0-9\\s)]");
		static int suma = 0;
		
	public static void main(String[] args) throws FileNotFoundException {	
		try{
			
			plik = new File(args[0]);
		}
		catch (Exception e) {
			System.out.println("Nie podałes sciezki do pliku. \nDomyślna sciezka to: src/prawieSymetryczne/tekst.txt");
			plik = new File("src/prawieSymetryczne/tekst.txt");
		}
		try{
			scanner = new Scanner(plik);
		}catch (Exception e) {
			System.out.println("Nie udalo sie otworzyc pliku");
		}
		
		while(scanner != null && scanner.hasNext()){
			String slowo = scanner.next();
			slowo = slowo.toLowerCase();
			Matcher m = pattern.matcher(slowo);
			slowo = m.replaceAll("");
			addHashMap(slowa, slowo);
		}
		System.out.println(suma);
		printHashMap(slowa);
		System.out.println("Wszystkich slow prawie symetrycznych: " + suma);
	}
	
	private static boolean czyPrawieSym(String slowo){
		int len = slowo.length();
		int tmp = 0;
		boolean prawieSym = true;
		if(len == 1){
			return false;
		}
		while(len >= 1 && prawieSym){//przechodzimy po slowie
			if(slowo.charAt(tmp) == (char)(slowo.charAt(len-1)+1)){
				prawieSym = true;
			}
			else if(slowo.charAt(tmp) == slowo.charAt(len-1)){
				prawieSym = true;
			}
			else if(slowo.charAt(tmp) == (char)(slowo.charAt(len-1)-1)){
				prawieSym = true;
			}
			else if((char)(slowo.charAt(len-1)+1) == '{'){//znak jest z
				if(slowo.charAt(tmp) == 'a'){
					prawieSym =true;
				}
			}
			else if((char)(slowo.charAt(len-1)-1) == '`'){//znak a
				if(slowo.charAt(tmp) == 'z'){
					prawieSym =true;
				}
			}
			else{
				return false;
			}
			len--;
			tmp++;
		}
		return prawieSym;
	}
	
	private static void addHashMap(Map<String, Integer> map, String slowo){
		if(czyPrawieSym(slowo)){
			if(slowa.get(slowo) == null){
				slowa.put(slowo, 1);
			}
			else {
				int count = slowa.get(slowo);
				slowa.put(slowo, count+1);
			}
			suma++;
		}
	}
	
	private static void printHashMap(Map<String, Integer> map){
		for (Map.Entry<String, Integer>  entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
