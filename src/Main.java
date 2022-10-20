public class Main {
    public static void main(String[] args) {

        Person maksim = new Person(1991, "Максим", "Москва", "методист образовательных программ");
        Person any = new Person(1991, "Аня", "Москва", "методистом образовательных программ");
        Person kate = new Person(1992, "Катя", "Калининград", "продакт-менеджером");
        Person artem = new Person(1993, "Артем", "Москва", "директором по развитию бизнеса");
        Person vladimir = new Person(21,"Владимир", "Казани", "сейчас нигде не работает.");

        System.out.println(vladimir);


        Flower roza = new Flower("Роза", "Голландии", 35.59,-1);
        Flower hriz = new Flower("Хризантема", "", -15.00,5);
        Flower pion = new Flower("Пион", "Англия", 69.90,1);
        Flower gipso = new Flower("Гипсофила", "Турция", 19.50,10);
        System.out.println(roza);
        System.out.println(hriz);
        System.out.println(pion);
        System.out.println(gipso);



    }
}