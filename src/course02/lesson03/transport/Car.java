package course02.lesson03.transport;

import java.util.Objects;

public class Car extends Transport {
    private double engineVolume;
    private String gearbox;
    private final String bodyType;
    private String registrationPlateNumber;
    private final int seatQuantity;
    private boolean winterTyres;
    private final Key key;

    public Car() {
        super("", "", 0, "", "", 0);
        engineVolume = 1.5;
        gearbox = "A";
        bodyType = "sedan";
        registrationPlateNumber = "x000xx000";
        seatQuantity = 5;
        winterTyres = false;
        key = new Key();
    }

    public Car(String brand, String model, int productionYear, String productionCountry, String bodyColor,
               int maximumSpeed, double engineVolume, String gearbox, String bodyType,
               String registrationPlateNumber, int seatQuantity, boolean winterTyres, Key key) {
        super(brand, model, productionYear, productionCountry, bodyColor, maximumSpeed);
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
        this.key = new Key(key.remoteStartEngine, key.keylessAccess);
    }

    public double getEngineVolume() {
        return engineVolume;
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

//    public void setKey(Key key) {
//        this.key = key;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && seatQuantity == car.seatQuantity && winterTyres == car.winterTyres && Objects.equals(gearbox, car.gearbox) && Objects.equals(bodyType, car.bodyType) && Objects.equals(registrationPlateNumber, car.registrationPlateNumber) && Objects.equals(key, car.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineVolume, gearbox, bodyType, registrationPlateNumber, seatQuantity, winterTyres, key);
    }

    @Override
    public String toString() {
        return "Brand: " + getBrand() + ", " + "Model: " + getModel() + ", " + "Year of production: " + getProductionYear() + ", " +
                "Assembled in: " + getProductionCountry() + ", " + "Body color: " + getBodyColor() + ", " +
                "Maximum speed: " + getMaximumSpeed() + " km/h" + ", " + String.format("Engine volume - %.1f l." , engineVolume) +
                "Gearbox: " + gearbox + ", " + "Body type: " + bodyType + ", " + "Registration plate number: " +
                registrationPlateNumber + ", " + "Seat quantity: " + seatQuantity + ", " + (isWinterTyres() ? "winter" : "summer") +
                " tyres" + ", " + (getKey().isKeylessAccess() ? "keyless access" : "access with a key") + ", " +
                (getKey().isRemoteStartEngine() ? "remote start engine" : "classic start engine");
    }

    public void changeTyres(int currentMonth) {
        this.winterTyres = currentMonth >= 11 || currentMonth <= 4;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return remoteStartEngine == key.remoteStartEngine && keylessAccess == key.keylessAccess;
        }

        @Override
        public int hashCode() {
            return Objects.hash(remoteStartEngine, keylessAccess);
        }
    }
}
