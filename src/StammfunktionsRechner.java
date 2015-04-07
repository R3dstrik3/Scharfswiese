
public class StammfunktionsRechner implements IntegralRechner{

	public double Integral(HalbKreis k, double von, double bis) {		
		return Fx(k,bis)- Fx(k,von);
	}
	
	public double Fx(HalbKreis k, double x){
		double r = k.getRadius();
		double v = k.getVerschiebungX();
		return (r*r*Math.asin((x-v)/r)+(x-v)*Math.sqrt(-x*x+2*v*x-v*v+r*r))/2;
	}

}
