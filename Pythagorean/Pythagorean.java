import java.lang.Math;

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double sumab = legA*legA + legB*legB;
        double c = Math.sqrt(sumab);
        System.out.println(c);
        return c;
    }
}