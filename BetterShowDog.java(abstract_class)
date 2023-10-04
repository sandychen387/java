package abstract_classes_and_interfaces;



public class BetterShowDog extends ShowDog{
	private Trick[]tricks;
	private int numTricks;
	public static final int MAX_TRICKS = 5;
	
	public BetterShowDog() {
		super("Better Show Dog Doe");
		tricks = new Trick[MAX_TRICKS];
		numTricks = 0;
	}
	
	public BetterShowDog(String name) {
		super(name);
		tricks = new Trick[MAX_TRICKS];
		numTricks = 0;
	}

	public BetterShowDog(String name, double wt, double ht, boolean isVac,
			int ageDY, int numTrophies, String bestFeature) {
		super(name, wt, ht, isVac, ageDY, numTrophies, bestFeature);
	}
	
	@Override
	public String toString() {
		String s = super.toString() + "\nBetterShowDog[ number of tricks = "
				+ numTricks + ":\n" + getTricksAsString() + "]";
		return s;
	}
	
	private String getTricksAsString() {
		String s = "";
		for(int i = 0; i < numTricks; i++) {
			s += tricks[i].toString();
		}
		return s;
	}
	
	public boolean addTrick(String trickName, int skillLevel) {
		if(numTricks <MAX_TRICKS) {
			if((trickName != null)&& isValid(skillLevel)) {
				for(int i =0;i<numTricks;i++) {
					if(tricks[i] != null && tricks[i].name.equalsIgnoreCase(trickName)){
						return false;//prevent duplicate trick entry by canning the tricks
					}
				}//end of scanning tricks array
				tricks[numTricks++] = new Trick(trickName, skillLevel);//use the constructor from the inner class
				return true;//indicate successful addition of the tricj to the array
			}
		}
		return false;//could not add the trick
	}
	
	public boolean removeTrickByName(String trickName) {
		for(int i =0; i < numTricks; i++) {
			if(tricks[i].name.equalsIgnoreCase(trickName)) {
				//found the trick to be removed
				for(int j=i; j<numTricks-1;j++) {//stat at he index of the found item for removal
					tricks[j]=tricks[j+1];//shift downard to ensure no gaps)
				}
				tricks[--numTricks] = null;//decrement to nullify correct representation
				return true;
			}
		}
		return false;
	}
	
	public int getSkillLevelForTrickByNam(String trickName) {
		for(int i=0;i<numTricks;i++) {
			if(tricks[i].name.equalsIgnoreCase(trickName)) {
				return tricks[i].skillLevel;
			}
		}
		return -1;//non-existent trick
	}
	
	public boolean isValid(int value) {
		return(value > 0 && value <= 10);
	}
	
	private class Trick{
		
		private String name;
		private int skillLevel;
		
		public Trick(String name, int skillLevel) {
			this.name = name;
			this.skillLevel = skillLevel;
		}
		
		@Override
		public String toString() {
			String s = "Trick[name= " + name + ", skill level= " + skillLevel + "]\n";
			return s;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o == null) {
				return false;
			}
			if(this == o) {
				return true;
			}
			if(o instanceof Trick) {
				Trick otherT = (Trick)o;
				if(this.name.equalsIgnoreCase(otherT.name)) {
					if(this.skillLevel == otherT.skillLevel) {
						return true;
					}
				}
			}
			return false;
		}
	}//close bracket Trick class
}//closing bracket for the BetterShowDog




