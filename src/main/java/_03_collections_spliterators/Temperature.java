package _03_collections_spliterators;

public class Temperature {
    private String unit;
    private double temp;

    public Temperature(String unit, double temp) {
        this.unit = unit;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "unit='" + unit + '\'' +
                ", temp=" + temp +
                '}';
    }
}
