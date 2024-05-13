package praktikum2;

import java.util.Random;

public class Positon {
    private final int xValue;
    private final int yValue;
    private int solarInput;
    private final int MIN = 10;
    private final int MAX = 500;
    private static final int PEAK_X = 5; // X-Koordinate des Höhepunkts
    private static final int PEAK_Y = 5; // Y-Koordinate des Höhepunkts
    private static final int PEAK_INTENSITY = 100; // Intensität am Höhepunkt

    public Positon (int x, int y){
        xValue=x;
        yValue=y;
        setSolarInput();
    }
    public int getxValue() {
        return xValue;
    }

    public int getyValue() {
        return yValue;
    }

    private void setSolarInput() {
        double scaleFactor = 5.0; // Skalierungsfaktor für eine schnellere Abnahme

        // Berechne den Abstand zwischen der aktuellen Position und dem Peak
        double distance = Math.sqrt(Math.pow(xValue - PEAK_X, 2) + Math.pow(yValue - PEAK_Y, 2));

        // Berechne die Intensität basierend auf dem Abstand
        double intensityd = PEAK_INTENSITY - distance;
        int intensity = (int)intensityd;

        // Begrenze die Intensität auf den Bereich zwischen MIN und MAX
        intensity = Math.max(MIN, Math.min(MAX, intensity));

        // Setze den Wert von solarInput auf die berechnete Intensität
        solarInput = intensity;
//        System.out.println("DEBUG: "+solarInput);

    }

    public int getSolarInput() {
        return solarInput;
    }

    @Override

    public String toString(){
        return String.format(xValue+", "+yValue);
    }
}
