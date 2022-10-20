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
    private String bodyTupe;
    private String regNumber;
    private final int placesCount;
    private boolean winterTires;
    private final Key key;
    private final Insurance insurance;

    public Car(String mark,
               String model,
               int yearManufacture,
               String assemblyCountry,
               String bodyTupe,
               int placesCount,
               double engineCapacity,
               String bodyColour, String gearBox, String regNumber, boolean tires) {
        this.mark = validOrDefaultCar(mark, "default");
        this.model = validOrDefaultCar(model, "default");
        this.yearManufacture = yearManufacture >= 0 ? yearManufacture : 2000;
        this.assemblyCountry = validOrDefaultCar(assemblyCountry, "default");
        this.bodyTupe = validOrDefaultCar(bodyTupe, "default");
        this.placesCount = Math.max(placesCount, 1);
        setEngineCapacity(engineCapacity);
        setBodyColour(bodyColour);
        setGearBox(gearBox);
        setRegNumber(regNumber);
        setWinterTires(tires);
    }

    public void setSeasonTires() {
        int currentMonth = LocalDate.now().getMonthValue();
        this.winterTires = currentMonth <= 4 || currentMonth >= 11;
    }

    public boolean isRegNumberValid() {
        if (this.regNumber.length() != 9) {
            return false;
        }
        char[] regNumbersChars = this.regNumber.toCharArray();
        return isNumberLetter(regNumbersChars[0])
                && isNumber(regNumbersChars[1])
                && isNumber(regNumbersChars[2])
                && isNumber(regNumbersChars[3])
                && isNumberLetter(regNumbersChars[4])
                && isNumberLetter(regNumbersChars[5])
                && isNumber(regNumbersChars[6])
                && isNumber(regNumbersChars[7])
                && isNumber(regNumbersChars[8]);
    }

    public boolean isNumber(char symbol) {
        return Character.isDigit(symbol);
    }

    public boolean isNumberLetter(char symbol) {
        String allowedSymbols = "АВЕКМНОРСТУХ";
        return allowedSymbols.contains("" + symbol);
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
        this.gearBox = validOrDefaultCar(gearBox, "defoult");
    }

    public String getBodyTupe() {
        return bodyTupe;
    }

    public void setBodyTupe(String bodyTupe) {
        this.bodyTupe = bodyTupe;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = validOrDefaultCar(regNumber, "defoult");
    }

    public int getPlacesCount() {
        return placesCount;
    }

    public boolean isWinterTires() {
        return winterTires;
    }

    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }

    public static String validOrDefaultCar(String value, String defaulte) {
        return value == null || value.isEmpty() ? defaulte : value;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", bodyColour='" + bodyColour + '\'' +
                ", yearManufacture=" + yearManufacture +
                ", assemblyCountry='" + assemblyCountry + '\'' +
                ", gearBox='" + gearBox + '\'' +
                ", bodyTupe='" + bodyTupe + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", placesCount=" + placesCount +
                ", winterTires=" + winterTires +
                '}';
    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keyLessAccess;

        public Key(boolean remoteEngineStart, boolean keyLessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keyLessAccess = keyLessAccess;
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeyLessAccess() {
            return keyLessAccess;
        }
    }

    public static class Insurance {
        private final LocalDate validUntil;
        private final float cost;
        private final String number;

        public Insurance(LocalDate validUntil, float cost, String number) {
            this.validUntil = validUntil != null ? validUntil : LocalDate.now().plusDays(10);
            this.cost = Math.max(cost, 1);
            this.number = validOrDefaultCar(number, "defoult");
        }

        public boolean isNumberValid() {
            return number.length() == 9;
        }

        public boolean isInsuranceValid() {
            return LocalDate.now().isBefore(this.validUntil);
        }
    }
}

