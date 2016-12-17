import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	static File plik;
	static Map<Character, Integer> countChars;

	public static void main(String[] args) throws FileNotFoundException{
		plik = new File("src/tekst.txt");
		countChars = new HashMap<Character, Integer>();
		
		try{
			countEverythingAndPrint(plik);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//funkcja ktorej uzywalem do przerobienia bazy na bazy danych, moze sie jeszcze przydac
	private static void czytajZapisuj(int ileWwierszu) throws FileNotFoundException{
		Scanner scanner = connect(new File("src/bankomat1.txt"));
		PrintWriter zapis = new PrintWriter("src/nazwa_pliku2.txt");
		int wiersz = 0;
		int linia = 0;
		while(scanner.hasNext()){
			wiersz++;
			String word = scanner.next();
			if(wiersz == 2){
				word = formatujGodzine(word);
			}
			if(wiersz == 8 && linia >= 17863){
				zapis.print(word);
			}else if (linia >= 17863){
				zapis.print(word + " ");
			}
			
			
			if(wiersz == ileWwierszu){
				wiersz = 0;
				linia++;
				if(linia >= 17863)
					zapis.println();
			}
		}
		scanner.close();
		zapis.close();
	}
	
	private static String formatujGodzine(String time) {
		if(time.length() == 5){
			return time;
		}
		if(time.charAt(1) == ':'){
			time = "0" + time;
		}
		if(time.charAt(2) == ':' && time.length() == 4){
			char tmp = time.charAt(3);
			time = time.substring(0, 3);
			time += ("0" + tmp);
		}
		return time;
	}
	
	private static Scanner connect(File file) throws FileNotFoundException{
		try{
			return new Scanner(file);
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	private static void countEverythingAndPrint(File file) throws FileNotFoundException{
		Scanner scanner = null;
		try{
			scanner = connect(file);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		Pattern patern = Pattern.compile("[a-ząężźćśł][.?!]|[0-9]+[.,][0-9]+[.?!]");
		Matcher m;
		int countSentence = 0;
		int countWorld = 0;

		while (scanner.hasNext()){
			String world = scanner.next();
			countWorld++;
			
			m = patern.matcher(world);
			if(m.find()){
				countSentence++;
			}
			
			int length = world.length() -1;
			while(length >= 0){
				if(countChars.get(world.charAt(length)) == null){
					countChars.put(world.charAt(length), 1);
				}
				else {
					int count = countChars.get(world.charAt(length));
					countChars.put(world.charAt(length), count+1);
				}
				length--;
			}
			
		}
		scanner.close();
		System.out.println("Sentence: " + countSentence);
		System.out.println("World: " + countWorld);
		printHashMap(countChars);
	}
	
	private static void printHashMap(Map<Character, Integer> map){
		for (Map.Entry<Character, Integer>  entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
