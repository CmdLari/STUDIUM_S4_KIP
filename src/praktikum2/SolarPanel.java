package praktikum2;

public class SolarPanel {
    public static final int CAPACITY = 100;
    private Positon position;
    private int value;
    public SolarPanel (Positon position) {
        this.position= position;
        if(position.getSolarInput()>CAPACITY){
            this.value=CAPACITY;
        }
        else{
            this.value= position.getSolarInput();}
    };

    public Positon getPosition() {
        return position;
    }

    public void setPosition(Positon position) {
        this.position = position;
        if(position.getSolarInput()>CAPACITY){
            this.value=CAPACITY;
        }
        else{
            this.value= position.getSolarInput();}    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return String.format("Solarpanel: genutzte Kapazität:" +getValue()+"/100 [Position: "+getPosition()+"]");
    }
}
