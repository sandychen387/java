package abstract_classes_and_interfaces;

public class Driver {
	
	public static void main(String[] args) {
		
	//	Pet p = new Pet();
		
		Dog d = new Dog();
		d.setFavoriteToy("ball");
		d.setFavoriteFood("Steake");
		d.play();
		d.eat(new Food("banana",100,2));
		d.eat();
		d.speak("AAAA");
		
		BetterShowDog bsd1 = new BetterShowDog("BSD1");
		BetterShowDog bsd2 = new BetterShowDog("BSD2");
		BetterShowDog bsd3 = new BetterShowDog("BSD3");
		BetterShowDog bsd4 = new BetterShowDog("BSD4");
		
		System.out.println(bsd1.addTrick("jump",1 ));
		System.out.println(bsd1.addTrick("sing",10 ));
		System.out.println(bsd1.addTrick("sit",2 ));
		System.out.println(bsd1.addTrick("smile",9 ));//should return false..duplicate name not allowed
		System.out.println(bsd1.addTrick("jump",1 ));
		System.out.println(bsd1.addTrick("roll",8));
		System.out.println(bsd1.addTrick("fall",10));
		Dog d1 = new Dog();
		Dog fido = new Dog();
		Dog scooby = new Dog();
		Dog d2 = new Dog("R2D2", 100.2,48,true,9);

		ShowDog sd1 = new ShowDog();
		sd1.setNumTrophies(4);
		sd1.setBestFeature("fur");
		sd1.setWeight(20);
		sd1.setHeight(9);
		ShowDog sd2 = new ShowDog("Fancytastic", 12,10,true,3,2,"eyes");
		ShowDog sd3 = new ShowDog("Fancytastic", 12,10,true,3,2,"eyes");
		ShowDog sd4 = new ShowDog("Fancytastic", 12,10,true,3,2,"eyes");
		ShowDog sd5 = new ShowDog("Fancytastic", 12,10,true,3,2,"eyes");
		
		Dog [] allDogs = {d1,d2,fido,scooby,sd1,sd2,sd3,sd4,sd5,bsd1,bsd2,bsd3,bsd4};
		BetterShowDog[] bsDogs = {bsd1,bsd2,bsd3,bsd4};
		for(int i =0; i <bsDogs.length; i++) {
			System.out.println("ALL DOGS"+i+" "+bsDogs[i].toString());
		}
		System.out.println("----\n\n-----");
		for(int i =0; i < allDogs.length-1;i++) {
			System.out.println("Dog number "+ allDogs[i].getDogNumber() + "vs Dog number " + allDogs[i+1].getDogNumber() + " = " + allDogs[i].compareTo(allDogs[i+1]));
		}
		System.out.println("Dog number "+allDogs[7].getDogNumber() + " vs Gog number " + allDogs[7].getDogNumber() +" = " + allDogs[7].compareTo(allDogs[7]));
	}

}
