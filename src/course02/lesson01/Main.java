package course02.lesson01;
public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("Lada", "Granta", 2015, "Russia", "yellow", 1.7);
        Car audiA8 = new Car("Audi", "A8 50L TDI quattro", 2020, "Germany", "black", 3.0);
        Car bmwZ8 = new Car("BMW", "Z8", 2021, "Germany", "black", 3.0);
        Car kiaSportage = new Car("Kia", "Sportage 4th generation", 2018, "South Korea", "red", 2.4);
        Car hyundaiAvante = new Car("Hyundai", "Avante", 2016, "South Korea", "orange", 1.6);

        System.out.println(ladaGranta);
        System.out.println(audiA8);
        System.out.println(bmwZ8);
        System.out.println(kiaSportage);
        System.out.println(hyundaiAvante);
        System.out.println();

        Human maksim = new Human("Maksim", "Minsk", 1988, "brand-manager");
        Human anya = new Human("Anya", "Moscow", 1993, "methodist of educational programs");
        Human katya = new Human("Katya", "Kaliningrad", 1992, "product-manager");
        Human artem = new Human("Atrem", "Moscow", 1995, "director of business development");
        Human vladimir = new Human("Vladimir", "Kazan", 2001, "unemployed");

        System.out.println(maksim);
        System.out.println(anya);
        System.out.println(katya);
        System.out.println(artem);
        System.out.println(vladimir);
    }
}
