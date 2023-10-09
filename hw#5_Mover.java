package hw5;
import java.lang.String;
public interface Mover {
	
	default String move() {return "";};
	default String move(int count) {return "";};
	
	void speak();
	void eat();

}
