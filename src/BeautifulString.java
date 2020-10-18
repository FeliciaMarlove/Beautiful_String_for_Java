import java.lang.reflect.*;
import java.util.*;

public abstract class BeautifulString<T> {
    private static final String get = Suffixes.GET.get();
    private static final String has = Suffixes.HAS.get();
    private static final String is = Suffixes.IS.get();
    private static int level = 0;

    public static <T> void show(T objectToOutput) {
        try {
            Method[] methods = objectToOutput.getClass().getDeclaredMethods();
            for (Method m : methods) {
                if (Modifier.isPublic(m.getModifiers())) {
                    if (m.getName().startsWith(get) && Character.isUpperCase(m.getName().charAt(get.length()))) {
                        printBeautifully(m, objectToOutput, get);
                    } else if (m.getName().startsWith(is) && Character.isUpperCase(m.getName().charAt(is.length()))) {
                        printBeautifully(m, objectToOutput, is);
                    } else if (m.getName().startsWith(has) && Character.isUpperCase(m.getName().charAt(has.length()))) {
                        printBeautifully(m, objectToOutput, has);
                    }
                }
            }
            printTabs();
            System.out.println("(the object is of type " + objectToOutput.getClass().getName() + ")");
            --level;

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            System.out.println("Something bad happened!\n" + e.getMessage());
        }
    }

    private static <T> void printBeautifully(Method m, T o, String prefix) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method retrievedMethod = o.getClass().getMethod(m.getName());
        String[] words = m.getName().substring(prefix.length()).split("(?=\\p{Upper})");
        printTabs();
        Arrays.stream(words).forEach(s -> System.out.print(s + " "));
        String returnType = retrievedMethod.getReturnType().getSimpleName();
        process(returnType, retrievedMethod, o);
    }

    private static <T> void process(String returnType, Method method, T o) throws InvocationTargetException, IllegalAccessException {
        String outputPrefix = ": \t{" + returnType + "} ";

        T data;

        if (returnType.endsWith("[]")) {
            //TODO further cases to test: multidimensional arrays, heterogeneous arrays, Objects arrays
            data = (T) getArrayWrapped(returnType, method.invoke(o));
        } else {
            data = (T) method.invoke(o);
        }

        if (data == null) {
            System.out.println(outputPrefix + data);
        //TODO further cases to test: collections or maps of custom classes objects
        } else if (data instanceof Collection) {
            System.out.println(outputPrefix + data);
        } else if (data instanceof Map) {
            System.out.println(outputPrefix + data);
        } else if (data.getClass().isArray()) {
            System.out.println(outputPrefix + Arrays.deepToString((Object[]) data));
        } else if (data instanceof String || data instanceof Number || data instanceof Boolean) {
            System.out.println(outputPrefix + data);
        } else {
            ++level;
            //TODO - consider limiting output in case of recursion! cfr java doc on deepToString
            System.out.println(outputPrefix);
            show(data);

        }
    }

    private static <T> Object[] getArrayWrapped(String returnType, T o) {
        if (o == null) return null;
        switch (returnType) {
            case "double[]" :
                double[] doubleArray = (double[]) o;
                Double[] doubleArrayWrapped = new Double[doubleArray.length];
                for (int i = 0; i < doubleArray.length; i++) {
                    doubleArrayWrapped[i] = doubleArray[i];
                }
                return doubleArrayWrapped;
            case "int[]" :
                int[] intArray = (int[]) o;
                Integer[] integerArrayWrapped = new Integer[intArray.length];
                for (int i = 0; i < intArray.length; i++) {
                    integerArrayWrapped[i] = intArray[i];
                }
                return integerArrayWrapped;
            case "float[]" :
                float[] floatArray = (float[]) o;
                Float[] floatArrayWrapped = new Float[floatArray.length];
                for (int i = 0; i < floatArray.length; i++) {
                    floatArrayWrapped[i] = floatArray[i];
                }
                return floatArrayWrapped;
            case "long[]" :
                long[] longArray = (long[]) o;
                Long[] longArrayWrapped = new Long[longArray.length];
                for (int i = 0; i < longArray.length; i++) {
                    longArrayWrapped[i] = longArray[i];
                }
                return longArrayWrapped;
            case "char[]" :
                char[] charArray = (char[]) o;
                Character[] characterArrayWrapped = new Character[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    characterArrayWrapped[i] = charArray[i];
                }
                return characterArrayWrapped;
            case "byte[]" :
                byte[] byteArray = (byte[]) o;
                Byte[] byteArrayWrapped = new Byte[byteArray.length];
                for (int i = 0; i < byteArray.length; i++) {
                    byteArrayWrapped[i] = byteArray[i];
                }
                return byteArrayWrapped;
            case "short[]" :
                short[] shortArray = (short[]) o;
                Short[] shortArrayWrapped = new Short[shortArray.length];
                for (int i = 0; i < shortArray.length; i++) {
                    shortArrayWrapped[i] = shortArray[i];
                }
                return shortArrayWrapped;
            case "boolean[]" :
                boolean[] booleanArray = (boolean[]) o;
                Boolean[] booleanArrayWrapped = new Boolean[booleanArray.length];
                for (int i = 0; i < booleanArray.length; i++) {
                    booleanArrayWrapped[i] = booleanArray[i];
                }
                return booleanArrayWrapped;
            case "Object[]" : case "Double[]": case "Integer[]": case "Character[]": case "Float[]": case "Long[]": case "Byte[]": case "Boolean[]": case "Short[]": return (Object[])o;
            default: return (Object[])o;
        }
    }

    private static void printFooter() {
        System.out.println("-------------------------------------------------------\n" +
                "Information automatically output with BeautifulString.\n" +
                "Please find original source code at: https://github.com/FeliciaMarlove/Beautiful_String_for_Java\n" +
                "Thank you for reporting any bug or improvement ideas.");
    }

    private static void printTabs() {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
    }


    /*
    For development and test purpose
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
