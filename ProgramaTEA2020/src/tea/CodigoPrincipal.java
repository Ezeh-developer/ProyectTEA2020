package tea;
import static java.lang.Math.abs;

import java.util.Scanner;

public class CodigoPrincipal {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Definicion de variables
		
		// Variables intoducidas desde el teclado
		double latitude;
		double longitude;
		double JD;
		int TimeZone;
		int Day;
		int Month;
		int Year;
		int UTCHour;
		int UTCMinute;
		
		System.out.println("Ingrese la fecha que desea calcular");
		System.out.print("Dia: ");
		Day = input.nextInt();
		System.out.print("Mes: ");
		Month = input.nextInt();
		System.out.print("Año: ");
		Year = input.nextInt();
		System.out.println("Ingrese hora");
		System.out.print("Hora: ");
		UTCHour= input.nextInt();
		System.out.print("Minutos: ");
		UTCMinute= input.nextInt();
		
		JD = FormulaJD(Year, Month, Day, UTCHour, UTCMinute);
		
		System.out.println(JD);
		
	}
	
	// los siguientes metodos son datos sobre la posicion del sol

	public static double FormulaJD(double Y, double M, double D, double H, double MM) {
		double JD;
		int A;
		int B;
		int C;
		int E;
		int F;
		
		if(M <= 2) {
			Y--;
			M = M + 12;
		}
		
		A = (int)(Y/100);
		B = A/4;
		C = 2 - A + B;
		E = (int)(365.25*(Y+4716));
		F = (int)(30.6001*(M+1));

		JD = C+D+E+F-1524.5 + (double)((MM/60+H)/24);
		
		return JD;
	}
	
	public static double FormulaJC(double JD) {
		double JC;
		
		JC = (JD-2451545)/36525;
		
		return JC;
	}
	
	public static double GeomMeanLongSun(double JC) {
		double GeomMeamLongSun;
		
		GeomMeamLongSun = (280.46646 + JC * (36000.76983 + JC * 0.0003032)) % 360;
		
		return GeomMeamLongSun;
	}
	
	public static double GeomMeanAnomSun(double JC) {
		double GeomMeanAnomSun;
		
		GeomMeanAnomSun = 357.52911+JC*(35999.05029 - 0.0001537*JC);
		
		return GeomMeanAnomSun;
	}
	
	
	
}
