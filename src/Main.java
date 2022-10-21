
public class Main {
    public static void main(String[] args) {

        Person maksim = new Person(1991, "Максим", "Москва", "методист образовательных программ");
        Person any = new Person(1991, "Аня", "Москва", "методистом образовательных программ");
        Person kate = new Person(1992, "Катя", "Калининград", "продакт-менеджером");
        Person artem = new Person(1993, "Артем", "Москва", "директором по развитию бизнеса");
        Person vladimir = new Person(21, "Владимир", "Казани", "сейчас нигде не работает.");

        System.out.println(vladimir);


        Flower roza = new Flower(null, "Голландии", 35.59);
        Flower hriz = new Flower("Хризантема", null, 15.00, 5);
        Flower pion = new Flower("Пион", "Англия", 69.90, 1);
        Flower gipso = new Flower("Гипсофила", "Турция", 19.50, 10);
        printInfo(roza);
        printInfo(hriz);
        printInfo(pion);
        printInfo(gipso);

        bouqueting(roza,roza,roza,hriz,hriz,hriz,hriz,hriz,gipso);
    }

    private static void printInfo(Flower flower) {
        System.out.println(flower);
    }

    private static void bouqueting(Flower... flowers){
        double cost = 0;
        int minlifeSpan = Integer.MAX_VALUE;
        for (Flower flower : flowers) {
            if(flower.lifeSpan < minlifeSpan){
                minlifeSpan = flower.lifeSpan;
            }
            cost += flower.getCost();
        }
        cost*=1.1;
        System.out.println("Стоимость букета: " + cost);
        System.out.println("Срок стояния букета: " + minlifeSpan);
    }


}