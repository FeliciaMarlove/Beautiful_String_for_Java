/*
DUMMY CLASS FOR TEST ONLY
Getters methods have to follow usual Java naming conventions:
- starting with "get", "has" or "is" followed by an UpperCase word
 */

public class ExampleItem {
    private String name;
    private int age;
    private double[] quotations;
    private Double[] betterQuotations;
    private Person thing;
    private Person[] things;

    public ExampleItem(String name, int age, double[] quotations, Double[] betterQuotations, Person thing, Person[] things) {
        this.name = name;
        this.age = age;
        this.quotations = quotations;
        this.betterQuotations = betterQuotations;
        this.thing = thing;
        this.things = things;
    }

    public Double[] getBetterQuotations() {
        return betterQuotations;
    }

    public Person[] getThings() {
        return things;
    }

    public Person getThing() {
        return thing;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double[] getQuotations() {
        return quotations;
    }
}
