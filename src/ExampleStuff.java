public class ExampleStuff {
    private String name;
    private int age;
    private double[] quotations;
    private Double[] betterQuotations;
    private ExampleThing thing;
    private ExampleThing[] things;

    public ExampleStuff(String name, int age, double[] quotations, Double[] betterQuotations, ExampleThing thing, ExampleThing[] things) {
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

    public ExampleThing[] getThings() {
        return things;
    }

    public ExampleThing getThing() {
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
