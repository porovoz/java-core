package course02.lesson03.transport;

public class Bus extends Transport{
    public Bus() {
        super("", "", 0, "", "", 0);
    }
    public Bus(String brand, String model, int productionYear, String productionCountry, String bodyColor,
               int maximumSpeed) {
        super(brand, model, productionYear, productionCountry, bodyColor, maximumSpeed);
    }

    @Override
    public String toString() {
        return "Brand: " + getBrand() + ", " + "Model: " + getModel() + ", " + "Year of production: " +
                getProductionYear() + ", " + "Production country: " + getProductionCountry() + ", " + "Body color: "
                + getBodyColor() + ", " + "Maximum speed: " + getMaximumSpeed() + " km/h";
    }

}
