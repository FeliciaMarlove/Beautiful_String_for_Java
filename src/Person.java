import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
DUMMY CLASSES FOR TEST ONLY
Getters methods have to follow usual Java naming conventions:
- starting with "get", "has" or "is" followed by an UpperCase word
 */

public class Person<T, K, V> {
    private int age;
    private boolean hasSportyHobbies;
    private boolean isSmoker;
    private String name;
    private List<T> hobbies;
    private Map<K, V> education;
    private double[] lastWeightMeasurements;
    private Double[] lastWeightMeasurementsWrapper;
    private Person companion;
    private Person[] parents;

    /*
        Dummy constructor for demonstration purpose. Shallow copies made for code brevity. Don't try this at home ;)
    */

    public Person(int age, boolean hasSportyHobbies, boolean isSmoker, String name, List<T> hobbies, Map<K, V> education, double[] lastWeightMeasurements, Double[] lastWeightMeasurementsWrapper, Person companion, Person[] parents) {
        this.age = age;
        this.hasSportyHobbies = hasSportyHobbies;
        this.isSmoker = isSmoker;
        this.name = name;
        this.hobbies = hobbies;
        this.education = education;
        this.lastWeightMeasurements = lastWeightMeasurements;
        this.lastWeightMeasurementsWrapper = lastWeightMeasurementsWrapper;
        this.companion = companion;
        this.parents = parents;
    }

    public Person(int age, boolean hasSportyHobbies, boolean isSmoker, String name, Double[] lastWeightMeasurementsWrapper) {
        this.age = age;
        this.hasSportyHobbies = hasSportyHobbies;
        this.isSmoker = isSmoker;
        this.name = name;
        this.lastWeightMeasurementsWrapper = lastWeightMeasurementsWrapper;
    }

    public Person() {
    }

    // Setters omitted for code brevity


    public int getAge() {
        return age;
    }

    public boolean hasSportyHobbies() {
        return hasSportyHobbies;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public String getName() {
        return name;
    }

    public List<T> getHobbies() {
        return hobbies;
    }

    public Map<K, V> getEducation() {
        return education;
    }

    public double[] getLastWeightMeasurements() {
        return lastWeightMeasurements;
    }

    public Double[] getLastWeightMeasurementsWrapper() {
        return lastWeightMeasurementsWrapper;
    }

    public Person getCompanion() {
        return companion;
    }

    public Person[] getParents() {
        return parents;
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

    public static Person dummyPopulate() {
        List<Hobby> hobbies = List.of(new Hobby("Ski", 1), new Hobby("Jogging", 20), new Hobby("Basket", 4), new Hobby("Painting", 1));
        Map<String, Education> education = Map.of("Higher long", new Education("Master degree", "AI"), "Higher short", new Education("Bachelor degree", "Computer science"));
        double[] weightMeasurements = {55.08, 58.92, 60.23, 56.05};
        Double[] weightMeasurementsW = Arrays.stream(weightMeasurements).boxed().toArray(Double[]::new);
        Person companion = new Person(24, true, false, "Dukette", weightMeasurementsW);
        Person father = new Person(55, false, true, "Duke sr", weightMeasurementsW);
        Person mother = new Person(56, true, true, "Duk'ster", weightMeasurementsW);
        return new Person(25, true, false, "Duke", hobbies, education, weightMeasurements, weightMeasurementsW, companion, new Person[]{mother, father});
    }
}

class Hobby {
    private String name;
    private Integer frequencyPerMonth;

    public Hobby(String name, Integer frequencyPerMonth) {
        this.name = name;
        this.frequencyPerMonth = frequencyPerMonth;
    }

    public String getName() {
        return name;
    }

    public Integer getFrequencyPerMonth() {
        return frequencyPerMonth;
    }
}

class Education {
    private String name;
    private String specialization;

    public Education(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}
