import java.lang.reflect.*;
import java.util.*;

public abstract class BeautifulString <T> {
    private static final String get = Suffixes.GET.get();
    private static final String has = Suffixes.HAS.get();
    private static final String is = Suffixes.IS.get();

    public static <T> void show(T objectToOuput) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method[] methods = objectToOuput.getClass().getDeclaredMethods();

        for (Method m: methods) {
            if (Modifier.isPublic(m.getModifiers())) {
                if (m.getName().startsWith(get) && Character.isUpperCase(m.getName().charAt(get.length()))) {
                    printBeautifully(m, objectToOuput, get);
                } else
                if (m.getName().startsWith(is) && Character.isUpperCase(m.getName().charAt(is.length()))) {
                    printBeautifully(m, objectToOuput, is);
                } else
                if (m.getName().startsWith(has) && Character.isUpperCase(m.getName().charAt(has.length()))) {
                    printBeautifully(m, objectToOuput, has);
                }
            }

        }
        System.out.println("(the object is of type " + objectToOuput.getClass().getName() + ")");
        System.out.println("-------------------------------------------------------\n" +
                "Information automatically output with BeautifulString.\n" +
                "Please find original source code at: https://github.com/FeliciaMarlove/Beautiful_String_for_Java\n" +
                "Thank you for reporting any bug or improvement ideas.");
    }

    private static <T> void printBeautifully(Method m, T o, String suffix) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Method retrievedMethod = o.getClass().getMethod(m.getName());
        String attributeName = "";
        String[] words;
        switch (suffix) {
            case "get":
                words = m.getName().substring("get".length()).split("(?=\\p{Upper})");
                break;
            case "is":
                words = m.getName().substring("is".length()).split("(?=\\p{Upper})");
                break;
            case "has":
                words = m.getName().substring("has".length()).split("(?=\\p{Upper})");
                break;
            default:
                words = new String[]{"Did", "you", "follow", "naming", "conventions", "?"};
                break;
        }
        Arrays.stream(words).forEach(s -> System.out.print(s + " "));
        Object gottenData = retrievedMethod.invoke(o);
        if (gottenData instanceof Collection) {
            System.out.println( ": \t{" + gottenData.getClass().getSimpleName() + "} " + gottenData);
        } else if (gottenData instanceof Map) {
            System.out.println( ": \t{" + gottenData.getClass().getSimpleName() + "} " + gottenData);
        } else if (gottenData.getClass().isArray()) {
            System.out.println( ": \t{" + gottenData.getClass().getSimpleName() + "} " + gottenData);
        } else if (gottenData instanceof String || gottenData instanceof Number) {
            System.out.println( ": \t{" + gottenData.getClass().getSimpleName() + "} " + gottenData);
        } else {
            System.out.println( ": \t{" + gottenData.getClass().getSimpleName() + "} ");
        }

    }


    /*
    For development purpose
     */
    private static void testMethod(String prefix, Method m) {
        System.out.println(prefix.toUpperCase());
        System.out.println(m.getName());
        System.out.println(m.getReturnType());
    }
}

enum Suffixes {
    GET("get"),
    HAS("has"),
    IS("is");

    private final String suffix;

    Suffixes(String suffix) {
        this.suffix = suffix;
    }

    public String get() {
        return suffix;
    }
}
