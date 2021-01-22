package core;

public class Contador {

    private int index;

    public Contador(){}
    public Contador(int index){
        this.setIndex(index);
    }
    public Contador(Contador contador){
        this.setIndex(contador.getIndex());
    }

    public void incrementar(){
        this.index++;
    }
    public void incrementar(int i){
        this.index += i;
    }

    public void decrementar(){
        this.index--;
    }
    public void decrementar(int i){
        this.index -= i;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
