package IO;

public class DataStorage { //jezeli klasa ma same konstruktory i gettery to klasa immutable (niemodyfikowalna)

    private int index;
    private String data1;
    private String data2;

    public DataStorage(int index, String data1, String data2) {
        this.index = index;
        this.data1 = data1;
        this.data2 = data2;
    }

    public int getIndex() {
        return index;
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }
}

