package processor;

class CityRecord {
    int id;
    int year;
    String city;
    int population;

    public CityRecord(int id, int year, String city, int population) {
        this.id = id;
        this.year = year;
        this.city = city;
        this.population = population;
    }

    public String toString() {
        return "id: " + this.id + ", year: " + this.year + ", city: " + this.city + ", population: " + this.population;
    }
}
