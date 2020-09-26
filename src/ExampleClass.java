import java.util.List;
import java.util.Map;

/*
Getters methods have to follow usual Java naming conventions:
- starting with "get", "has" or "is" followed by an UpperCase word
 */

public class ExampleClass<T, K, V> {
    private int theIntAttribute;
    private boolean hasTheBooleanAttribute;
    private boolean isTheBooleanAttribute;
    private String theStringAttribute;
    private Object theObjectAttribute;
    private double[] theArrayOfDoubles;
    private List<T> theGenericList;
    private Map<K, V> theGenericMap;

    public ExampleClass(int theIntAttribute, boolean hasTheBooleanAttribute, boolean isTheBooleanAttribute, String theStringAttribute, Object theObjectAttribute, double[] theArrayOfDoubles, List<T> theGenericList, Map<K, V> theGenericMap) {
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
    }

    public ExampleClass() {
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
}
