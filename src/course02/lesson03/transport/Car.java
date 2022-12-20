package course02.lesson02.transport;

import java.util.Objects;

public class Car {
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int productionYear;
    private final String productionCountry;
    private String gearbox;
    private final String bodyType;
    private String registrationPlateNumber;
    private final int seatQuantity;
    private boolean winterTyres;
    private Key key;

    public Car(String brand,
               String model,
               int productionYear,
               String productionCountry,
               String color,
               double engineVolume,
               String gearbox,
               String bodyType,
               String registrationPlateNumber,
               int seatQuantity,
               boolean winterTyres,
               Key key) {
        if (brand == null || brand.isEmpty()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (productionYear <= 0) {
            this.productionYear = 2000;
        } else {
            this.productionYear = productionYear;
        }
        if (productionCountry == null || productionCountry.isEmpty()) {
            this.productionCountry = "default";
        } else {
            this.productionCountry = productionCountry;
        }
        if (color == null || color.isEmpty()) {
            this.color = "white";
        } else {
            this.color = color;
        }
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (gearbox == null || gearbox.isEmpty()) {
            this.gearbox = "A";
        } else {
            this.gearbox = gearbox;
        }
        if (bodyType == null || bodyType.isEmpty()) {
            this.bodyType = "sedan";
        } else {
            this.bodyType = bodyType;
        }
        if (registrationPlateNumber == null || registrationPlateNumber.isEmpty()) {
            this.registrationPlateNumber = "x000xx000";
        } else {
            this.registrationPlateNumber = registrationPlateNumber;
        }
        if (seatQuantity < 2 || seatQuantity > 9) {
//            seatQuantity = 5;
            throw new IndexOutOfBoundsException("Seat quantity must be from 2 to 9 including driver");
        } else {
            this.seatQuantity = seatQuantity;
        }
        this.winterTyres = winterTyres;
        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }
    }

    public Car(String brand,
               String model,
               int productionYear,
               String productionCountry,
               String color,
               double engineVolume
    ) {
        this(
                brand,
                model,
                productionYear,
                productionCountry,
                color,
                engineVolume,
                "A",
                "sedan",
                "x000xx000",
                5,
                true,
                new Key()
        );
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getColor() {
        return color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationPlateNumber() {
        return registrationPlateNumber;
    }

    public int getSeatQuantity() {
        return seatQuantity;
    }

    public boolean isWinterTyres() {
        return winterTyres;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public void setColor(String color) {
        if (color == null || color.isEmpty()) {
            this.color = "white";
        } else {
            this.color = color;
        }
    }

    public void setGearbox(String gearbox) {
        if (gearbox == null || gearbox.isEmpty()) {
            this.gearbox = "A";
        } else {
            this.gearbox = gearbox;
        }
        if (gearbox != null && !gearbox.equals("A") && !gearbox.equals("M")) {
            System.out.println("Incorrect gearbox");
        }
    }

    public void setRegistrationPlateNumber(String registrationPlateNumber) {
        if (registrationPlateNumber == null || registrationPlateNumber.isEmpty()) {
            this.registrationPlateNumber = "x000xx000";
        } else {
            this.registrationPlateNumber = registrationPlateNumber;
        }
    }
    public void setWinterTyres(boolean winterTyres) {
        this.winterTyres = winterTyres;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && productionYear == car.productionYear && seatQuantity == car.seatQuantity && winterTyres == car.winterTyres && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(productionCountry, car.productionCountry) && Objects.equals(gearbox, car.gearbox) && Objects.equals(bodyType, car.bodyType) && Objects.equals(registrationPlateNumber, car.registrationPlateNumber) && Objects.equals(key, car.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, productionYear, productionCountry, gearbox, bodyType, registrationPlateNumber, seatQuantity, winterTyres, key);
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", " + "Model: " + model + ", " + "Year of production: " + productionYear + ", " +
                "Assembled in: " + productionCountry + ", " + "Body color: " + color + ", " +
                String.format("Engine volume - %.1f l." , engineVolume) + "Gearbox: " + gearbox + ", " +
                "Body type: " + bodyType + ", " + "Registration plate number: " + registrationPlateNumber + ", " +
                "Seat quantity: " + seatQuantity + ", " + (isWinterTyres() ? "winter" : "summer") + " tyres" + ", " +
                (getKey().isKeylessAccess() ? "keyless access" : "access with a key") + ", " +
                (getKey().isRemoteStartEngine() ? "remote start engine" : "classic start engine");
    }

    //    Date date = new Date();
//    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//    int month = localDate.getMonthValue();
    public void changeTyres(int month) {
        if (month == 11 || month == 12 || month == 1 || month == 2 || month == 3 || month == 4) {
            winterTyres = !winterTyres;
            System.out.println("It is time to change tyres!");
        }
    }

    public boolean isCorrectRegistrationPlateNumber() {
//x000xx000
        if (registrationPlateNumber.length() != 9) {
            return false;
        }
        char[] chars = registrationPlateNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3]) &&
                Character.isDigit(chars[6]) && Character.isDigit(chars[7]) &&
                Character.isDigit(chars[8]);
    }

    public static class Key {
        private final boolean remoteStartEngine;
        private final boolean keylessAccess;

        public Key(boolean remoteStartEngine, boolean keylessAccess) {
            this.remoteStartEngine = remoteStartEngine;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteStartEngine() {
            return remoteStartEngine;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }
}
