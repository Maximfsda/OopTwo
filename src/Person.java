import java.time.LocalDate;

public class Person {
    private int date;
    private String name;
    private String city;
    private String position;

    public Person(int date, String name, String city, String position) {
        setDate(date);
        setName(name);
        setCity(city);
        setPosition(position);
    }

    public void setDate(int date) {
        if(date <= 0){
            this.date = 0;
        }
        else{
            this.date = date;
        }
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            this.name = "Информация не указана";
        }
        else{
            this.name = name;
        }
    }

    public void setCity(String city) {
        if(city.isEmpty() || city == null){
            this.city = "Информация не указана";
        }
        else{
            this.city = city;
        }
    }

    public void setPosition(String position) {
        if(position.isEmpty() || position == null){
            this.position = "Информация не указана";
        }
        else{
            this.position = position;
        }
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getPosition() {
        return position;
    }
    private int getAgeInYear(){
        int currentYear = LocalDate.now().getYear();
        return currentYear - date;
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + getName() + ". Я из города " + getCity() + ". Я родился в " + getAgeInYear() + " году. Я работаю на должности " + getPosition() + ". Будем знакомы!";
    }
}
