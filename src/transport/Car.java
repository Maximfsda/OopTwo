package transport;

public class Car {
    private final String mark;
    private final String model;
    private double engineCapacity;
    private String bodyColour;
    private final int yearManufacture;
    private final String assemblyCountry;
    private String gearBox;
    private final String bodyTupe;
    private String regNumber;
    private final int placesCount;
    private String winterTires;
//    private final Key key;
//    private final Insurance insurance;

    public Car(String mark,
               String model,
               double engineCapacity,
               String bodyColour,
               int yearManufacture,
               String assemblyCountry,
               String gearBox,
               String bodyTupe,
               String regNumber,
               int placesCount,
               String winterTires) {
        this.mark = validOrDefaultCar(mark, "Информация неизвестна.");
        this.model = validOrDefaultCar(model, "Информация неизвестна.");
        this.yearManufacture = yearManufacture >= 0 ? yearManufacture : 2000;
        this.assemblyCountry = validOrDefaultCar(assemblyCountry, "Информация неизвестна.");
        this.bodyTupe = validOrDefaultCar(bodyTupe, "Информация неизвестна.");
        this.placesCount = Math.max(placesCount, 2);
        setEngineCapacity(engineCapacity);
        setBodyColour(bodyColour);
        setGearBox(gearBox);
        setRegNumber(regNumber);
        setWinterTires(winterTires);
    }

    public boolean isRegNumberValid() {
        //x000xx000
        if (regNumber.length() != 9) {
            return false;
        }
        char[] chars = regNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3]) &&
                Character.isDigit(chars[6]) && Character.isDigit(chars[7]) && Character.isDigit(chars[8]);
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity > 0.0 ? engineCapacity : 1.5;
    }

    public String getBodyColour() {
        return bodyColour;
    }

    public void setBodyColour(String bodyColour) {
        this.bodyColour = validOrDefaultCar(bodyColour, "White");
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public String getAssemblyCountry() {
        return assemblyCountry;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = validOrDefaultCar(gearBox, "МКПП");
    }

    public String getBodyTupe() {
        return bodyTupe;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = validOrDefaultCar(regNumber, "х000хх000");
    }

    public int getPlacesCount() {
        return placesCount;
    }

    public void setWinterTires(String winterTires) {
        this.winterTires = validOrDefaultCar(winterTires, "Информация неизвестна.");
    }
    public String getWinterTires() {
        return winterTires;
    }

    public static String validOrDefaultCar(String value, String defaulte) {
        return value == null || value.isEmpty() ? defaulte : value;
    }
    public void tire (Car car) {
        String tireSummmer = "Летняя";
        String tireWinter = "Зимняя";
        if(winterTires.contains(tireSummmer) ){
            this.winterTires = tireWinter;
            System.out.println("Резина заменена на зимнюю.");
        }
        else{
            this.winterTires = tireSummmer;
            System.out.println("Резина заменена на летнюю.");
        }
    }

    @Override
    public String toString() {
        return
                "Марка -" + mark +
                ",модель -" + model +
                ",обьем двигателя -" + engineCapacity +
                ",цвет кузова -" + bodyColour +
                ",год выпуска -" + yearManufacture +
                ",страна производства -" + assemblyCountry +
                ",коробка передач -" + gearBox +
                ",тип кузова -" + bodyTupe +
                ",регистрационный номер -" + regNumber +
                ",колчисетво сидячих мест -" + placesCount +
                ",тип шин -" + winterTires +
                '}';
    }
}

