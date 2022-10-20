public class Flower {
    private String flower;
    private String country;
    private double cost;
    int lifeSpan;

    public Flower(String flower, String country, double cost, int lifeSpan) {
        setFlower(flower);
        setCountry(country);
        setCost(cost);
        setLifeSpan(lifeSpan);
    }

    public String getFlower() {
        return flower;
    }

    public void setFlower(String flower) {
        this.flower = validOrDefault(flower, "Роза");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = validOrDefault(country, "Russia");
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = Math.max(cost,1);
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan > 0 ? lifeSpan : 3;
    }

    public static String validOrDefault(String value, String defaulte) {
        return value == null || value.isEmpty() ? defaulte : value;
    }

    @Override
    public String toString() {
        return  flower + " из " +country + ", стоимость штуки -" + cost +
                ",срок стояния -" + lifeSpan +
                "дней.";
    }
}


