package praktikum2;

public class AlgoTest {

    private static int ROOF_X = 100;
    private static int ROOF_Y = 100;
    private static float MUTATION_RATE = 0.4f;
    private static int POPULATION_SIZE = 10;
    private static int GENRATION_COUNT = 10;

    public static void main(String[] args) {
        GeneticAlgo algo= new GeneticAlgo(MUTATION_RATE,POPULATION_SIZE,ROOF_X,ROOF_Y,GENRATION_COUNT);
        algo.run();
    }
}
