package tea;

import java.util.Scanner;

public class CodigoPrincipalTest {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int tabla[][] = new int[31][27];

		// Definicion de variables
		int Option = 0;
		// Valores introducidos por el usuario
		double Latitude = 0;
		double Longitude = 0;
		int Timezone = 0;
		int Day = 0;
		int Month = 0;
		int Year = 0;
		int UTCHour = 0;
		int UTCMinute = 0;
		// valores importados de la recoleccion de datos
		double DataBaseTest;
		// Valores calculados por metodos
		double JD = 0;
		double JC = 0;
		double GeomMeanLongSun = 0;
		double GeomMeanAnomSun = 0;
		double EccentEarthOrbit = 0;
		double SunEqOfCtr = 0;
		double SunTrueLong = 0;
		double SunTrueAnom = 0;
		double SunRadVector = 0;
		double SunAppLong = 0;
		double MeanObliqEcliptic = 0;
		double ObliqCorr = 0;
		double SunRtAscen = 0;
		double SunDeclin = 0;
		double VarY = 0;
		double EqOfTime = 0;
		double HASunrise = 0;
		double SolarNoon = 0;
		double SunriseTime = 0;
		double SunsetTime = 0;
		double SunlightDuration = 0;
		double TrueSolarTime = 0;
		double HourAngle = 0;
		double SolarZenithAngle = 0;
		double SolarElevationAngle = 0;
		double ApproxAtmosphericRefraction = 0;
		double SolarElevationCorrectedForAtmRefraction = 0;
		double SolarAzimuthAngle = 0;

		System.out.println("Calculadora de posicion solar");
		System.out.println("1) Ingresar datos");
		System.out.println("2) Calcular en base a datos recolectados");
		System.out.println("3) Informacion sobre el programa y datos");
		System.out.println("0) Salir");
		System.out.print("Opcion: ");
		Option = input.nextInt();

		switch (Option) {
		case 1:

			System.out.println("Ingrese datos para calcular la posicion del sol");
			System.out.println("--------------------------------");
			System.out.println("Ingrese la fecha que desea calcular");
			System.out.print("Dia: ");
			Day = input.nextInt();
			System.out.print("Mes: ");
			Month = input.nextInt();
			System.out.print("Año: ");
			Year = input.nextInt();
			System.out.println("--------------------------------");
			System.out.println("Ingrese hora en UTC - Tip: para convertir de hora uruguaya a UTC sumale 3 horas");
			System.out.print("Hora: ");
			UTCHour = input.nextInt();
			System.out.print("Minutos: ");
			UTCMinute = input.nextInt();
			System.out.println("--------------------------------");
			System.out.print("Ingrese datos de localizacion");
			System.out.print("Ingrese latitud (+ al N)");
			Latitude = input.nextDouble();
			System.out.print("Ingrese longitud (+ al E)");
			Longitude = input.nextDouble();
			System.out.print("Ingrese zona horaria (+ al E)");
			Timezone = input.nextInt();

			break;
		case 2:
			break;
		case 3:
			break;
		case 0:
			break;

		}

		for (int row = 0; row < 31; row++) {

			for (int col = 0; col < 27; col++) {
				
				switch(col) {
				
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8: 
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					break;
				case 15:
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					break;
				case 19:
					break;
				case 20:
					break;
				case 21:
					break;
				case 22:
					break;
				case 23:
					break;
				case 24:
					break;
				case 25:
					break;
				case 26:
					break;
				case 27:
					break;
				
				}
				
			}

		}

		// Asignacion de los valores a las variables usando los metodos y parametros
		// correspondientes

		JD = FormulaJD(Year, Month, Day, UTCHour, UTCMinute);
		JC = FormulaJC(JD);
		GeomMeanLongSun = GeomMeanLongSun(JC);
		GeomMeanAnomSun = GeomMeanAnomSun(JC);
		EccentEarthOrbit = EccentEarthOrbit(JC);
		SunEqOfCtr = SunEqOfCtr(GeomMeanAnomSun, JC);
		SunTrueLong = SunTrueLong(GeomMeanLongSun, SunEqOfCtr);
		SunTrueAnom = SunTrueAnom(GeomMeanAnomSun, SunEqOfCtr);
		SunRadVector = SunRadVector(EccentEarthOrbit, SunTrueAnom);
		SunAppLong = SunAppLong(SunTrueLong, JC);
		MeanObliqEcliptic = MeanObliqEcliptic(JC);
		ObliqCorr = ObliqCorr(MeanObliqEcliptic, JC);
		SunRtAscen = SunRtAscen(SunAppLong, ObliqCorr);
		SunDeclin = SunDeclin(ObliqCorr, SunAppLong);
		VarY = VarY(ObliqCorr);
		EqOfTime = EqOfTime(VarY, GeomMeanLongSun, EccentEarthOrbit, GeomMeanAnomSun);
		HASunrise = HASunrise(Latitude, SunDeclin);
		SolarNoon = SolarNoon(Longitude, EqOfTime, Timezone);
		SunriseTime = SunriseTime(SolarNoon, HASunrise);
		SunsetTime = SunsetTime(SolarNoon, HASunrise);
		SunlightDuration = SunlightDuration(HASunrise);
		TrueSolarTime = TrueSolarTime(UTCHour, UTCMinute, EqOfTime, Longitude, Timezone);
		HourAngle = HourAngle(TrueSolarTime);
		SolarZenithAngle = SolarZenithAngle(Latitude, SunDeclin, HourAngle);
		SolarElevationAngle = SolarElevationAngle(SolarZenithAngle);
		ApproxAtmosphericRefraction = ApproxAtmosphericRefraction(SolarElevationAngle);
		SolarElevationCorrectedForAtmRefraction = SolarElevationCorrectedForAtmRefraction(SolarElevationAngle,
				ApproxAtmosphericRefraction);
		SolarAzimuthAngle = SolarAzimuthAngle(Latitude, HourAngle, SolarZenithAngle, SunDeclin);

		System.out.println(JD);

		input.close();

	}

	// los siguientes metodos son formulas para datos de la posicion del sol
	// en una fecha, hora y lugar determinado

	public static double FormulaJD(double Y, double M, double D, double H, double MM) {
		double JD;
		int A;
		int B;
		int C;
		int E;
		int F;

		if (M <= 2) {
			Y--;
			M = M + 12;
		}

		A = (int) (Y / 100);
		B = A / 4;
		C = 2 - A + B;
		E = (int) (365.25 * (Y + 4716));
		F = (int) (30.6001 * (M + 1));

		JD = C + D + E + F - 1524.5 + (double) ((MM / 60 + H) / 24);

		return JD;
	}

	public static double FormulaJC(double JD) {
		double JC;

		JC = (JD - 2451545) / 36525;

		return JC;
	}

	public static double GeomMeanLongSun(double JC) {
		double GeomMeamLongSun;

		GeomMeamLongSun = (280.46646 + JC * (36000.76983 + JC * 0.0003032)) % 360;

		return GeomMeamLongSun;
	}

	public static double GeomMeanAnomSun(double JC) {
		double GeomMeanAnomSun;

		GeomMeanAnomSun = 357.52911 + JC * (35999.05029 - 0.0001537 * JC);

		return GeomMeanAnomSun;
	}

	public static double EccentEarthOrbit(double JC) {
		double EccentEarthOrbit;

		EccentEarthOrbit = 0.016708634 - JC * (0.000042037 + 0.0000001267 * JC);

		return EccentEarthOrbit;
	}

	public static double SunEqOfCtr(double GeomMeanAnomSun, double JC) {
		double SunEqOfCtr;

		SunEqOfCtr = Math.sin(Math.toRadians(GeomMeanAnomSun) * 1.914602 - JC * (0.004817 + 0.000014 * JC))
				+ Math.sin(Math.toRadians(2 * GeomMeanAnomSun)) * (0.019993 - 0.000101 * JC)
				+ Math.sin(Math.toRadians(3 * GeomMeanAnomSun)) * 0.000289;

		return SunEqOfCtr;
	}

	public static double SunTrueLong(double GeomMeanLongSun, double SunEqOfCtr) {
		double SunTrueLong;

		SunTrueLong = GeomMeanLongSun + SunEqOfCtr;

		return SunTrueLong;
	}

	public static double SunTrueAnom(double GeomMeanAnomSun, double SunEqOfCtr) {
		double SunTrueAnom;

		SunTrueAnom = GeomMeanAnomSun + SunEqOfCtr;

		return SunTrueAnom;
	}

	public static double SunRadVector(double EccentEarthOrbit, double SunTrueAnom) {
		double SunRadVector;

		SunRadVector = (1.000001018 * (1 - EccentEarthOrbit * EccentEarthOrbit))
				/ (1 + EccentEarthOrbit * Math.cos(Math.toRadians(SunTrueAnom)));

		return SunRadVector;
	}

	public static double SunAppLong(double SunTrueLong, double JC) {
		double SunAppLong;

		SunAppLong = SunTrueLong - 0.00569 - 0.00478 * Math.sin(Math.toRadians(125.04 - 1934.136 * JC));

		return SunAppLong;
	}

	public static double MeanObliqEcliptic(double JC) {
		double MeanObliqEcliptic;

		MeanObliqEcliptic = 23 + (26 + ((21.448 - JC * (46.815 + JC * (0.00059 - JC * 0.001813)))) / 60) / 60;

		return MeanObliqEcliptic;
	}

	public static double ObliqCorr(double MeanObliqEcliptic, double JC) {
		double ObliqCorr;

		ObliqCorr = MeanObliqEcliptic + 0.00256 * Math.cos(Math.toRadians(125.04 - 1934.136 * JC));

		return ObliqCorr;
	}

	public static double SunRtAscen(double SunAppLong, double ObliqCorr) {
		double SunRtAscen;

		SunRtAscen = Math.toDegrees(Math.atan2(Math.cos(Math.toRadians(SunAppLong)),
				Math.cos(Math.toRadians(ObliqCorr)) * Math.sin(Math.toRadians(SunAppLong))));

		return SunRtAscen;
	}

	public static double SunDeclin(double ObliqCorr, double SunAppLong) {
		double SunDeclin;

		SunDeclin = Math
				.toDegrees(Math.asin(Math.sin(Math.toRadians(ObliqCorr)) * Math.sin(Math.toRadians(SunAppLong))));

		return SunDeclin;
	}

	public static double VarY(double ObliqCorr) {
		double VarY;

		VarY = Math.tan(Math.toRadians(ObliqCorr / 2)) * Math.tan(Math.toRadians(ObliqCorr / 2));

		return VarY;
	}

	public static double EqOfTime(double VarY, double GeomMeanLongSun, double EccentEarthOrbit,
			double GeomMeanAnomSun) {
		double EqOfTime;

		EqOfTime = 4 * Math.toDegrees(VarY * Math.sin(2 * Math.toRadians(GeomMeanLongSun))
				- 2 * EccentEarthOrbit * Math.sin(Math.toRadians(GeomMeanAnomSun))
				+ 4 * EccentEarthOrbit * VarY * Math.sin(Math.toRadians(GeomMeanAnomSun))
						* Math.cos(2 * Math.toRadians(GeomMeanLongSun))
				- 0.5 * VarY * VarY * Math.sin(4 * Math.toRadians(GeomMeanLongSun))
				- 1.25 * EccentEarthOrbit * EccentEarthOrbit * Math.sin(2 * Math.toRadians(GeomMeanAnomSun)));

		return EqOfTime;
	}

	public static double HASunrise(double Latitude, double SunDeclin) {
		double HASunrise;

		HASunrise = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(90.833))
				/ (Math.cos(Math.toRadians(Latitude)) * Math.cos(Math.toRadians(SunDeclin)))
				- Math.tan(Math.toRadians(Latitude)) * Math.tan(Math.toRadians(SunDeclin))));

		return HASunrise;
	}

	public static double SolarNoon(double Longitude, double EqOfTime, double Timezone) {
		double SolarNoon;

		SolarNoon = (720 - 4 * Longitude - EqOfTime + Timezone * 60) / 1440;

		return SolarNoon;
	}

	public static double SunriseTime(double SolarNoon, double HASunrise) {
		double SunriseTime;

		SunriseTime = (SolarNoon * 1440 - HASunrise * 4) / 1440;

		return SunriseTime;
	}

	public static double SunsetTime(double SolarNoon, double HASunrise) {
		double SunsetTime;

		SunsetTime = (SolarNoon * 1440 + HASunrise * 4) / 1440;

		return SunsetTime;
	}

	public static double SunlightDuration(double HASunrise) {
		double SunlightDuration;

		SunlightDuration = 8 * HASunrise;

		return SunlightDuration;
	}

	public static double TrueSolarTime(double UTCHour, double UTCMinute, double EqOfTime, double Longitude,
			double Timezone) {
		double TrueSolarTime;

		TrueSolarTime = (UTCHour * 60 + UTCMinute) * 1440 + EqOfTime + 4 * Longitude - 60 * Timezone % 1440;

		return TrueSolarTime;
	}

	public static double HourAngle(double TrueSolarTime) {
		double HourAngle;

		if ((TrueSolarTime / 4) < 0) {
			HourAngle = TrueSolarTime / 4 + 180;
		} else {
			HourAngle = TrueSolarTime / 4 - 180;
		}

		return HourAngle;
	}

	public static double SolarZenithAngle(double Latitude, double SunDeclin, double HourAngle) {
		double SolarZenithAngle;

		SolarZenithAngle = Math
				.toDegrees(Math.acos(Math.sin(Math.toRadians(Latitude)) * Math.sin(Math.toRadians(SunDeclin))
						+ Math.cos(Math.toRadians(Latitude)) * Math.cos(Math.toRadians(SunDeclin))
								* Math.cos(Math.toRadians(HourAngle))));

		return SolarZenithAngle;
	}

	public static double SolarElevationAngle(double SolarZenithAngle) {
		double SolarElevationAngle;

		SolarElevationAngle = 90 - SolarZenithAngle;

		return SolarElevationAngle;
	}

	public static double ApproxAtmosphericRefraction(double SolarElevationAngle) {
		double ApproxAtmosphericRefraction = 0;

		// Info para for's
		double base1 = 58.1 / Math.tan(Math.toRadians(SolarElevationAngle))
				- 0.07 / Math.tan(Math.toRadians(SolarElevationAngle));
		double base2 = 0.000086 / Math.tan(Math.toRadians(SolarElevationAngle));

		if (SolarElevationAngle > 85) {
			SolarElevationAngle = 0;
		} else {

			if (SolarElevationAngle > 5) {

				for (int exponent = 0; exponent < 4; exponent++) {
					base1 = base1 * base1;
				}
				for (int exponent = 0; exponent < 6; exponent++) {
					base2 = base2 * base2;
				}

				if (SolarElevationAngle > -0.575) {
					ApproxAtmosphericRefraction = 1735 + SolarElevationAngle * (-518.2 + SolarElevationAngle
							* (103.4 + SolarElevationAngle * (-12.79 + SolarElevationAngle * 0.711)));
				} else {
					ApproxAtmosphericRefraction = -20.772 / Math.tan(Math.toRadians(SolarElevationAngle)) / 3600;

				}
			}

		}

		return ApproxAtmosphericRefraction;
	}

	public static double SolarElevationCorrectedForAtmRefraction(double SolarElevationAngle,
			double ApproxAtmosphericRefraction) {
		double SolarElevationCorrectedForAtmRefraction;

		SolarElevationCorrectedForAtmRefraction = SolarElevationAngle + ApproxAtmosphericRefraction;

		return SolarElevationCorrectedForAtmRefraction;
	}

	public static double SolarAzimuthAngle(double Latitude, double HourAngle, double SolarZenithAngle,
			double SunDeclin) {
		double SolarAzimuthAngle;

		if (HourAngle > 0) {
			SolarAzimuthAngle = Math.toDegrees(Math
					.acos(((Math.sin(Math.toRadians(Latitude)) * Math.cos(Math.toRadians(SolarZenithAngle)))
							- Math.sin(Math.toRadians(SunDeclin)))
							/ (Math.cos(Math.toRadians(Latitude)) * Math.sin(Math.toRadians(SolarZenithAngle))))
					+ 180 % 360);
		} else {
			SolarAzimuthAngle = 540 - Math.toDegrees(
					Math.acos(((Math.sin(Math.toRadians(Latitude)) * Math.cos(Math.toRadians(SolarZenithAngle)))
							- Math.sin(Math.toRadians(SunDeclin)))
							/ (Math.cos(Math.toRadians(Latitude)) * Math.sin(Math.toRadians(SolarZenithAngle)))))
					% 360;
		}

		return SolarAzimuthAngle;
	}

	// Metodos para calcular los datos de la posicion del sol en cada mes
	
	public static double MonthValuesJanuary() {
		
		
		
		return 0;
	}
}
