
public class Main {
	public static void main(String [] agrs){	
		HalbKreis grass = new HalbKreis(1,0);
		HalbKreis ziege = new HalbKreis(1.5, 1);
		
		Problem p = new Problem(grass,ziege);
		p.setEpsilon(0.001);
		p.setMaxIterations(10000);
//		p.setIntegralRechner(new SummenApproximation());
		p.setIntegralRechner(new StammfunktionsRechner());
	
		p.solve();
	}
}
