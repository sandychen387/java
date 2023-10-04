package abstract_classes_and_interfaces;



public class ShowDog extends Dog{
	
	private int numTrophies;
	private String bestFeature;
	
	public ShowDog() {
		super();
		setName("Show Dog Doe");//super.setName;
		numTrophies = 0;
		bestFeature = "unknow";
	}
	
	public ShowDog(String name) {
		super(name);
		numTrophies = 0;
		bestFeature = "unknow";
	}
	
	public ShowDog(String name, double wt, double ht, boolean isVac, int ageDY, int numTrophies, String bestFeature) {
		super(name, wt, ht, isVac, ageDY);
		this.numTrophies = numTrophies;
		this.bestFeature = bestFeature;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {return false;
	}
		if(this == obj) {
			return true;
		}
		if(obj instanceof ShowDog) {
			ShowDog otherSD = (ShowDog)obj;
			if(super.equals(otherSD)) {//call parent equals
				if(bestFeature.equalsIgnoreCase(otherSD.bestFeature)) {
					if(numTrophies == otherSD.numTrophies) {
						return true;
					}
				}
			}
		}
		return false;//mismatch along the way
	}
	
	public int getNumTrophies() {
		return numTrophies;
	}
	
	public String getBestFeature() {
		return bestFeature;
	}
	
	public void setNumTrophies(int numTrophies) {
		this.numTrophies = numTrophies;
	}
	
	public void setBestFeature(String bestFeature) {
		this.bestFeature = bestFeature;
	}
}


