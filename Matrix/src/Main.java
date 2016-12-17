import java.util.Scanner;

 class Matrix {
	Scanner scanner = new Scanner(System.in);
	private int x;
	private double[][] tab;
	
	public Matrix(int x){
		this.x = x;
		tab = new double[x][x];
		inicialize();
	}
	
	public void inicialize(){
		System.out.println("Podaj");
		for(int i = 0; i < x; i++){
			for(int e = 0; e < x; e++){
				tab[i][e] = scanner.nextDouble();
			}
		}
	}
	
	public void print(){
		for(int i = 0; i < x; i++){
			for(int e = 0; e < x; e++){
				System.out.print(tab[i][e] + " ");
			}
			System.out.println();
		}
	}
	
	
	void add(Matrix m){
		if(m.x != this.x){
			System.out.println("Macierze sa roznej wielkosci nie mozna ich dodac");
		}
		else{
			for(int i = 0; i < x; i++){
				for(int e = 0; e < x; e++){
					tab[i][e] += m.tab[i][e];
				}
			}
		}
	}
	
	void substract(Matrix m){
		if(m.x != this.x){
			System.out.println("Macierze sa roznej wielkosci nie mozna ich odjac");
		}
		else{
			for(int i = 0; i < x; i++){
				for(int e = 0; e < x; e++){
					tab[i][e] -= m.tab[i][e];
				}
			}
		}
	}
	
	void multiply(double d){
		for(int i = 0; i < x; i++){
			for(int e = 0; e < x; e++){
				tab[i][e] *= d;
			}
		}
	}
	
	void multiply(Matrix m){
		if(m.x != this.x){
			System.out.println("Macierze sa roznej wielkosci nie mozna ich przemnozyc przez siebie");
		}
		else{
			double tmp[][] = new double[x][x];
			for(int i = 0; i < x; i++){
				for(int e = 0; e < x; e++){
					double tmp2 = 0;
					for(int j = 0; j < x; j++){
						tmp2 += tab[i][j] * m.tab[j][e];
					}
					tmp[i][e] = tmp2;
				}
			}
			for(int i = 0; i < x; i++){
				for(int e = 0; e < x; e++){
					tab[i][e] = tmp[i][e];
				}
			}
		}
	}
	
	double det(){
		double epsilon = 1e-12;
		double copy[][] = new double[x][x];
		for(int i = 0; i < x; i++){
			for(int e = 0; e < x; e++){
				copy[i][e] = tab[i][e];
			}
		}
		for(int k = 0; k < x - 1; k++){
			if(abs(copy[k][k]) < epsilon){
				System.out.println("Dzielenie przez zero. Error!");
				return 0;
			}
			for(int i = k + 1; i < x; i++){
				copy[i][k] /= copy[k][k];
			}
		    for(int i = k + 1; i < x; i++){
		    	for(int j = k + 1; j < x; j++){
		    		copy[i][j] -= (copy[i][k] * copy[k][j]);
		    	}
		    }
		}
		
		double det = copy[0][0];
	    for(int i = 1; i < x; i++){
	    	det *= copy[i][i];
	    }
	    return det;
	}
	
	private double abs(double liczba){
		if(liczba > 0){
			return liczba;
		}
		return liczba * -1;
	}
}
 
 //****************************************************

public class Main {

	public static void main(String[] args){
		Matrix matrix = new Matrix(3);
		System.out.println(matrix.det());
//		Matrix matrix2 = new Matrix(3);
//		matrix.multiply(matrix2);
//		matrix.print();
	}
}
