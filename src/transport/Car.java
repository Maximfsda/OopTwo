package transport;

import java.time.LocalDate;

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
    private Key key;
    private Insurance insurance;

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
               String winterTires,
               Key key,
               Insurance insurance) {
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
        this.key = key == null ? new Key() : key;
        this.insurance = insurance == null ? new Insurance() : insurance;
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

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public static String validOrDefaultCar(String value, String defaulte) {
        return value == null || value.isEmpty() ? defaulte : value;
    }

    public void tire(Car car) {
        String tireSummmer = "Летняя";
        String tireWinter = "Зимняя";
        if (winterTires.contains(tireSummmer)) {
            this.winterTires = tireWinter;
            System.out.println("Резина заменена на зимнюю.");
        } else {
            this.winterTires = tireSummmer;
            System.out.println("Резина заменена на летнюю.");
        }
    }

    @Override
    public String toString() {
        return "Марка -" + mark +
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
                (getKey().isKeyAccess() ? "Безключевой доступ" : "Ключевой доступ") +
                (getKey().isRemoteStart() ? "Удаленный запуск" : "Обычный запуск") +
                ", номер страховки: " + getInsurance().getNumber() +
                ", стоимость страховки: " + getInsurance().getCost() +
                ", срок действия страховки: " + getInsurance().getExpireDate();
    }

    public static class Key {
        private final boolean remoteStart;
        private final boolean keyAccess;

        public Key(boolean remoteStart, boolean keyAccess) {
            this.remoteStart = remoteStart;
            this.keyAccess = keyAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteStart() {
            return remoteStart;
        }

        public boolean isKeyAccess() {
            return keyAccess;
        }
    }

    public static class Insurance {

        private final LocalDate expireDate;
        private final double cost;
        private final String number;

        public Insurance(LocalDate expireDate, double cost, String number) {
            this.expireDate = expireDate == null ? LocalDate.now().plusDays(365) : expireDate;
            this.cost = cost;
            this.number = number == null ? "123456789" : number;
        }
        public Insurance(){
            this(null,10_000,null);
        }


        public LocalDate getExpireDate() {
            return expireDate;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        public void checkExpireDate() {
            if (expireDate.isBefore(LocalDate.now()) || expireDate.isEqual(LocalDate.now())) {
                System.out.println("Нужно срочно ехать оформлять новую страховку!");
            }
        }

        public void checkNumber() {
            if (number.length() != 9) {
                System.out.println("Номер страховки некорректный!");
            }
        }
    }
}

