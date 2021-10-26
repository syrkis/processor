package processor;

class CityRecord {
    int id;
    int year;
    int population;

    public CityRecord(int id, int year, int population) {
        this.id = id;
        this.year = year;
        this.population = population;
    }

    public String toString() {
        return "id: " + this.id + ", year: " + this.year + ", population: " + this.population;
    }
}
