package praktikum8;
import java.util.Scanner;

public class Hidrokarbon_DisSet {
	private static Scanner input;
	static int[] DS;
	
	public static int Find (int X) {
    	int F = -1;
    	while (DS[X] != -1) {
    		X = DS[X];
    		F = X;
    	}
    	return F;
    }
    
    public static void Union (int X, int Y) {
    	int findX = Find(X); // ROOT
    	int findY = Find(Y);
    	if (findX == -1 & findY == -1)
    		DS[X] = Y;
    	else if (findX == -1 & findY != -1)
    		DS[X] = findY;
    	else if (findX != -1 & findY == -1)
    		DS[findX] = Y;
    	else if (findX != findY)
    		DS[findX] = findY;
    }

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int n = 1;
		
		do {
			System.out.println("~~~~~  Senyawa HIDROKARBON  ~~~~~");
			System.out.print("Masukkan panjang C utama [6-10] : ");
			int C = input.nextInt();
			if (C < 6 || C > 10) {
				System.out.println("Panjang C utama tidak sesuai range");
				break;
			}
			System.out.print("Masukkan jumlah cabang [1-3] 	: ");
			int cab = input.nextInt();
			if (cab < 1 || cab > 3) {
				System.out.println("Jumlah cabang tidak sesuai range");
				break;
			}
			System.out.println("Masukkan posisi cabang	 : ");
			int[] posisi = new int[cab];
			for (int i = 0; i < cab; i++) {
				posisi[i] = input.nextInt();
			}
			
			 DS = new int[C + cab];
			for (int i = 0; i <  DS.length; i++)
				 DS[i] = -1;

			for (int i = 0; i < cab; i++)
				Union(C + i, posisi[i] - 1);

			for (int i = 0; i < C; i++) {
				if (i < C - 1)
					Union(i, i + 1);
			}
			
			String[] Senyawa = new String[2];
			if (cab == 1)
				Senyawa[0] = "metil";
			else if (cab == 2)
				Senyawa[0] = "dimetil";
			else if (cab == 3)
				Senyawa[0] = "trimetil";

			if (C == 6)
				Senyawa[1] = "Heksana";
			else if (C == 7)
				Senyawa[1] = "Heptana";
			else if (C == 8)
				Senyawa[1] = "Oktana";
			else if (C == 9)
				Senyawa[1] = "Nonana";
			else if (C == 10)
				Senyawa[1] = "Dekana";

			System.out.println("\nSenyawa C (Disjoint Set)");
       		System.out.print("Array atom C	: ");
            	for (int i = 0; i < DS.length; i++)
            		System.out.print( "C" +"\t");
            	System.out.println(" ");

			System.out.print("Array 		: ");
			for (int i = 0; i <  DS.length; i++)
				System.out.print(i +"\t");
			System.out.println();

			System.out.print("Value 		: ");
			for (int i = 0; i <  DS.length; i++)
				System.out.print(DS[i]+"\t");
			System.out.println();

			System.out.print("Senyawa : ");
			for (int i = 0; i < cab; i++)
				System.out.print(posisi[i] + " ");
			System.out.println(Senyawa[0] + " " + Senyawa[1]);

			System.out.println("\nApakah ingin membuat senyawa lagi <1/0>");
			n = input.nextInt();
		} while(n == 1 );
		System.out.println("SELAMAT BELAJAR~");
	}

	
}


