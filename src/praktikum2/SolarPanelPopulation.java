package praktikum2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SolarPanelPopulation {
    private List<SolarPanel>solarPanelList=new ArrayList<>();
    private Random random = new Random();

    public SolarPanelPopulation(int popSize, int maxX, int maxY) {
        for (int i=0; i<popSize; i++){
            int x = random.nextInt(maxX);
            int y = random.nextInt(maxY);

            solarPanelList.add(new SolarPanel(new Positon(x,y)));

            }
    }

    public void addSolarPanel(SolarPanel solarPanel){
        solarPanelList.add(solarPanel);
    }

    public SolarPanel getAtIndex(int index){
        return solarPanelList.get(index);
    }

    public int getSize(){
        return solarPanelList.size();
    }

    public void sortPanels(){
        List<SolarPanel> newList = new ArrayList<>();
        while(!solarPanelList.isEmpty()){
            SolarPanel panel = solarPanelList
                    .stream()
                    .max(Comparator.comparing(SolarPanel::getValue))
                    .get();

            newList.add(panel);
            solarPanelList.remove(panel);
        }
        solarPanelList = newList;
    }

    public SolarPanel selectParent(SolarPanel[] avoid) {
        SolarPanel selected = null;
        Random rng= new Random();
        do {
            selected = getAtIndex(rng.nextInt(getSize()));
        } while (contains(avoid, selected));
        return selected;
    }
    private static boolean contains(Object[] array, Object element) {
        if (array == null)
            return false;

        for (Object obj : array) {
            if (obj.equals(element))
                return true;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (SolarPanel solarPanel : solarPanelList){
            stringBuilder.append(String.format(solarPanel+"\n"));
        }
        return stringBuilder.toString();
    }

}
