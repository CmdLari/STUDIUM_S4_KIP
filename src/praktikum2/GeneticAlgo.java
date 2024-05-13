package praktikum2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticAlgo {
    private final float mutationRate;
    private SolarPanelPopulation population;
    private final int xMaxValue;
    private final int yMaxValue;
    private final int generationCount;

    private static float SELECTION_RATE = 0.5f;

    /**
     * @param mutationRate
     * @param populationSize  number of solar panels
     * @param generationCount number of generations before the algo terminates (must be >1)
     * @param xMaxValue       max width of the roof
     * @param yMaxValue       max length of the roof
     */
    public GeneticAlgo(float mutationRate, int populationSize, int xMaxValue, int yMaxValue, int generationCount) throws IllegalArgumentException {
        checkArguments(mutationRate, populationSize, xMaxValue, yMaxValue, generationCount);
        this.mutationRate = mutationRate;
        this.population = new SolarPanelPopulation(populationSize, xMaxValue, yMaxValue);
        this.xMaxValue = xMaxValue;
        this.yMaxValue = yMaxValue;
        this.generationCount = generationCount;
    }

    private void checkArguments(float mutationRate, int populationSize, int xMaxValue, int yMaxValue, int generationCount) throws IllegalArgumentException {
        if (generationCount < 1) throw new IllegalArgumentException("generationCount must be greater 1");
        if (mutationRate < 0) throw new IllegalArgumentException("mutationRate must be greater 0");
        if (populationSize < 1) throw new IllegalArgumentException("populationSize must be greater 1");
        if (xMaxValue < 1 || yMaxValue < 1)
            throw new IllegalArgumentException("xMaxValue and yMaxValue must be greater 1");


    }

    public void run() {
        int generation = 0;
        int sunInputValue = 0;
        while (generation < generationCount) {

            //Selektion
            SolarPanelPopulation selectedPanels = new SolarPanelPopulation(0, xMaxValue, yMaxValue);
            population.sortPanels();
            for (int i = 0; i <= population.getSize() * SELECTION_RATE; i++) {
                selectedPanels.addSolarPanel(population.getAtIndex(i));
            }

            SolarPanelPopulation children = new SolarPanelPopulation(0, xMaxValue, yMaxValue);
            while (children.getSize() < population.getSize()) {
                SolarPanel parent1 = selectedPanels.selectParent(new SolarPanel[0]);
                SolarPanel[] avoid = new SolarPanel[1];
                avoid[0] = parent1;
                SolarPanel parent2 = selectedPanels.selectParent(avoid);

                //Erzeugen von Kinder mit single point cross-over
                Positon child1Position = new Positon(parent1.getPosition().getxValue(), parent2.getPosition().getyValue());
                Positon child2Position = new Positon(parent2.getPosition().getxValue(), parent1.getPosition().getyValue());

                children.addSolarPanel(new SolarPanel(child1Position));
                children.addSolarPanel(new SolarPanel(child2Position));
            }
            for (int i=0; i<children.getSize(); i++){
                mutate(children.getAtIndex(i));
            }
            population = children;
            generation++;

        }

        SolarPanel best = population.getAtIndex(0);

        //System.out.println(population);

        System.out.println(String.format("Beste gefundene Position: \n "+best));
    }

    private void mutate(SolarPanel solarPanel) {
        Random rnd = new Random();
        if (mutationRate > rnd.nextFloat()) {
            int newxRand = solarPanel.getPosition().getxValue() + rnd.nextInt(3);
            int newYRand = solarPanel.getPosition().getyValue() + rnd.nextInt(3);
            int newXValue = newxRand > xMaxValue ? 0 : newxRand;
            int newYValue = newYRand > yMaxValue ? 0 : newYRand;
            Positon newPos = new Positon(newXValue, newYValue);
            solarPanel.setPosition(newPos);
        }

    }
}
