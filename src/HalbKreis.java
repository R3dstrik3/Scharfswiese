
public class HalbKreis {
	
	private double radius;
	
	private double verschiebungX;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getVerschiebungX() {
		return verschiebungX;
	}

	public void setVerschiebungX(double verschiebungX) {
		this.verschiebungX = verschiebungX;
	}
	
	public HalbKreis(double r, double vX){
		setRadius(r);
		setVerschiebungX(vX);
	}
}
