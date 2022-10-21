package transport;

public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car ("Lada", "Granta", 1.7, "желтого цвета",2015,"сборка в России","Автомат","Седана","xx122xx221",3,"Зимняя");
        Car audi = new Car ("Audi", "A8 50 L TDI quattro", 3.0, "черный цвет кузова",2020,"сборка в Германии","МКПП","Седана","xx124xx221",4,"Летняя");
        Car bmw = new Car ("BMW", "Z8", 3.0, "черный цвет кузова",2021,"сборка в Германии","Автомат","Седана","xx122xx221",3,"Зимняя");
        Car kia = new Car ("Kia", "Sportage 4-го поколения",2.4, "цвет кузова — красный",2018,"сборка в Южной Корее","Автомат","Седана","xx122xx221",3,"Зимняя");
        Car hyundai = new Car ( "hyundai","Avante", 1.6, "цвет кузова — оранжевый",2016,"сборка в Южной Корее","Автомат","Седана","xx122xx221",3,"Зимняя");
        System.out.println(ladaGranta);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hyundai);
        ladaGranta.tire(ladaGranta);
        System.out.println(ladaGranta);
        ladaGranta.setRegNumber("в567ро1f2");
        System.out.println(ladaGranta.isRegNumberValid());


    }
}
