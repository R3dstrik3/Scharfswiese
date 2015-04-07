public class Problem {

	private double epsilon;

	private int maxIter = 1000000;

	private HalbKreis grass;

	private HalbKreis ziege;

	private IntegralRechner rechner = new SummenApproximation();

	
	
	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public int getMaxIterations() {
		return maxIter;
	}

	public void setMaxIterations(int maxIter) {
		this.maxIter = maxIter;
	}

	public IntegralRechner getIntegralRechner() {
		return rechner;
	}

	public void setIntegralRechner(IntegralRechner rechner) {
		this.rechner = rechner;
	}

	public Problem(HalbKreis grass, HalbKreis ziege){
		this.grass = grass;
		this.ziege = ziege;
	}
	
	public void solve() {
		double anfang = (double)System.currentTimeMillis()/1000;
		double schrittweite = 0.2;
		int i;
		for (i = 0; i < maxIter && Math.abs(diff(0)) >= epsilon; i++) {
			
			if (Math.abs(diff(schrittweite)) < Math.abs(diff(0))) {
				ziege.setRadius(ziege.getRadius() + schrittweite);
			}
			if (Math.abs(diff(-schrittweite)) < Math.abs(diff(0))) {
				ziege.setRadius(ziege.getRadius() - schrittweite);
			}

			if (schrittweite == 0) {
				break;
			}
			schrittweite /= 2;
		}
		
		System.out.print("Abbruch durch:\t");
		if (Math.abs(diff(0)) < epsilon) {
			System.out.println("epsilon");
		} else if (schrittweite == 0) {
			System.out.println("0 Schrittweite");
		} else {
			System.out.println("maxIter");
		}
		
		double ende = (double) System.currentTimeMillis()/1000;
		int convert = (int) ((ende - anfang)*1000);
		float laufzeit =((float) convert)/1000;
		
		System.out.println("\nLaufzeit:\t"+ laufzeit + " sek");
		System.out.println("\nIterationen:\t"+i);
		System.out.println("\nSchnittstelle:\t" + getSchnittstelle());
		System.out.println("\nRadius Ziege:\t" + ziege.getRadius());
		System.out.println("\nSchrittweite:\t" + schrittweite);
		System.out.println("\nAbweichung:\t" + diff(0));
		System.out.println("\nFlaecheGrassZiege:\t"+flaechegrassziege());
	}

	public double diff(double changeradius) {
		double radius = ziege.getRadius();
		ziege.setRadius(radius + changeradius);
//		double diff = Math.PI/2 - flaechegrassziege();
//		double diff = rechner.Integral(grass, -grass.getRadius(), grass.getRadius()) - flaechegrassziege();
		double diff = Math.pow(grass.getRadius(), 2)*Math.PI/4 - flaechegrassziege();
		ziege.setRadius(radius);
		return diff;
	}

	public double flaechegrassziege() {
		return  (rechner.Integral(grass, grass.getRadius() - ziege.getRadius(), getSchnittstelle())
				+ rechner.Integral(ziege, getSchnittstelle(), grass.getRadius()));
	}

	public double getSchnittstelle() {
//		return 1 - (ziege.getRadius() * ziege.getRadius()) / 2;
		double r1 = grass.getRadius();
		double r2 = ziege.getRadius();
		double v1 = grass.getVerschiebungX();
		double v2 = ziege.getVerschiebungX();
		return (r2*r2-r1*r1-v2*v2+v1*v1)/(2*(v1-v2));
	}
}
