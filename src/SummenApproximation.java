
public class SummenApproximation implements IntegralRechner{
	
	public static double h = 0.001;
	
	public double Integral(HalbKreis k, double von, double bis){
		double erg = 0;
		double radius = k.getRadius();
		double verschiebung = k.getVerschiebungX();
		for (double x=von; x<bis; x+=h){
			double wert = h*(Math.sqrt(Math.pow(radius,2)-((Math.pow(x-verschiebung,2)))));
			if (! Double.isNaN(wert)){
				erg += wert;
			}
		}
		
		return erg;
	}
}
