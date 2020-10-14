import java.util.List;
import java.util.Map;

/*
DUMMY CLASS FOR TEST ONLY
Getters methods have to follow usual Java naming conventions:
- starting with "get", "has" or "is" followed by an UpperCase word
 */

public class ExampleThing<T, K, V> {
    private int theIntAttribute;
    private boolean hasTheBooleanAttribute;
    private boolean isTheBooleanAttribute;
    private String theStringAttribute;
    private Object theObjectAttribute;
    private double[] theArrayOfDoubles;
    private List<T> theGenericList;
    private Map<K, V> theGenericMap;
    private String name;

    public ExampleThing(int theIntAttribute, boolean hasTheBooleanAttribute, boolean isTheBooleanAttribute, String theStringAttribute, Object theObjectAttribute, double[] theArrayOfDoubles, List<T> theGenericList, Map<K, V> theGenericMap, String name) {
        /*
        Dummy constructor for demonstration purpose. Shallow copies made for code brevity. Don't try this at home ;)
         */
        this.theIntAttribute = theIntAttribute;
        this.hasTheBooleanAttribute = hasTheBooleanAttribute;
        this.isTheBooleanAttribute = isTheBooleanAttribute;
        this.theStringAttribute = theStringAttribute;
        this.theObjectAttribute = theObjectAttribute;
        this.theArrayOfDoubles = theArrayOfDoubles;
        this.theGenericList = theGenericList;
        this.theGenericMap = theGenericMap;
        this.name = name;
    }

    public ExampleThing() {
    }

    // Setters omitted for code brevity

    public int getTheIntAttribute() {
        return theIntAttribute;
    }

    public boolean hasTheBooleanAttribute() {
        return hasTheBooleanAttribute;
    }

    public boolean isTheBooleanAttribute() {
        return isTheBooleanAttribute;
    }

    public String getTheStringAttribute() {
        return theStringAttribute;
    }

    public Object getTheObjectAttribute() {
        return theObjectAttribute;
    }

    public double[] getTheArrayOfDoubles() {
        return theArrayOfDoubles;
    }

    public List<T> getTheGenericList() {
        return theGenericList;
    }

    public Map<K, V> getTheGenericMap() {
        return theGenericMap;
    }

    public String getName() {
        return name;
    }

    private void getTheNothingBecauseWeOnlyInputPublicGetters() {
        // example of non working getter method
    }

    private void gettheNothingBecauseGetIsNotFollowedByAnUppercaseCharacter() {
        // example of non working getter method
    }

    private void GetTheNothingBecauseItsNotLowerCamelCase() {
        // example of non working getter method
    }

    private void youKnowWhyThisWontShow() {
        // example of non working getter method
    }

    public static ExampleThing[] dummyPopulate() {
        return new ExampleThing[]{
                new ExampleThing(5, true, false, "an example thing", new ExampleItem("an example item", 17, new double[]{5.0, 2.3, 52.2}, new Double[]{7.0, 2.5, 0.2}, new ExampleThing(), new ExampleThing[5]), new double[]{1.1, 2.2, 3.3}, List.of("what", "e", "ver"), Map.of(1, "first", 2,"second", 3, "third"), "my thing's name"),
                new ExampleThing(10, false, true, "another example thing", new ExampleItem("another example item", 52, new double[]{5.0, 2.3, 52.2}, new Double[]{7.0, 2.5, 0.2}, new ExampleThing(), new ExampleThing[5]), new double[]{1.1, 2.2, 3.3}, List.of("wher", "e", "ver"), Map.of(1, "one", 2,"two", 3, "three"), "my other thing's name")
        };

    }
}
