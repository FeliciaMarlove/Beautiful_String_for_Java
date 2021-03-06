import java.lang.reflect.*;
import java.util.*;

public abstract class BeautifulString<T> {
    private static final String get = Suffixes.GET.get();
    private static final String has = Suffixes.HAS.get();
    private static final String is = Suffixes.IS.get();
    private static int level = 0;
    private static boolean extraProcess = false;

    public static <T> void print(T objectToOutput) {
        try {
            show(objectToOutput);
        } catch (Exception e) {
            System.out.println("Something went wrong, please send me feedback!");
        } finally {
            printFooter();
        }
    }

    private static <T> void show(T objectToOutput) {
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

    private static <T,D,K,V> void process(String returnType, Method method, T o) throws InvocationTargetException, IllegalAccessException {
        String outputPrefix = ": \t{" + returnType + "} ";

        T data;

        if (returnType.endsWith("[]")) {
            data = (T) getArrayWrapped(returnType, method.invoke(o));
        } else {
            data = (T) method.invoke(o);
        }

        if (data == null) {
            System.out.println(outputPrefix + data);
        } else if (data instanceof Collection) {
            if(checkIfCustomCollection((Collection<T>) data)) {
                System.out.println(outputPrefix);
                processCutomClassCollection((Collection<T>) data);
            } else {
                System.out.println(outputPrefix + data);
            }
        } else if (data instanceof Map) {
            if(checkIfCustomMap((Map<K,V>) data)) {
                System.out.println(outputPrefix);
                processCutomClassMap((Map<K,V>) data);
            } else {
                System.out.println(outputPrefix + data);
            }
        } else if (data.getClass().isArray()) {
            if (extraProcess) {
                System.out.println(outputPrefix);
                processCutomClassArray((D[])data);
            } else {
                System.out.println(outputPrefix + Arrays.deepToString((Object[]) data));
            }
        } else if (data instanceof String || data instanceof Number || data instanceof Boolean) {
            System.out.println(outputPrefix + data);
        } else {
            ++level;
            System.out.println(outputPrefix);
            show(data);
        }
    }

    private static boolean checkIfCustomMap(Map data) {
        return ((Map)data).keySet().stream().anyMatch(key -> !isJavaClass(key.getClass()))
                || ((Map)data).values().stream().anyMatch(value -> !isJavaClass(value.getClass()));
    }

    private static <K,V> void processCutomClassMap(Map<K,V> data) {
        int index = 1;
        for (Map.Entry<K,V> entry : data.entrySet()) {
            ++level;
            printTabs();
            System.out.println("[" + index + "] {");
            printTabs();
            System.out.println("key: ");
            if (isJavaClass(entry.getKey().getClass())) {
                ++level;
                printTabs();
                System.out.println(entry.getKey());
                --level;
            } else {
                ++level;
                show(entry.getKey());
                --level;
            }
            printTabs();
            System.out.println("value:");
            if (isJavaClass(entry.getValue().getClass())) {
                ++level;
                printTabs();
                System.out.println(entry.getValue());
                --level;
            } else {
                ++level;
                show(entry.getValue());
                --level;
            }
            ++level;
            printTabs();
            --level;
            System.out.println("}");
            index++;
        }
    }


    private static boolean checkIfCustomCollection(Collection data) {
        return ((Collection) data).stream().anyMatch(item -> !isJavaClass(item.getClass()));
    }

    private static <T> void processCutomClassCollection(Collection<T> data) {
        int index = 1;
        for (T item: data) {
            ++level;
            System.out.print("[" + index + "]");
            show(item);
            index++;
        }
    }

    private static <T> void processCutomClassArray(T[] o) {
        extraProcess = false;
        int index = 1;
        for (T item: o) {
            ++level;
            System.out.print("[" + index + "]");
            show(item);
            index++;
        }
    }

    private static <T> T[] getArrayWrapped(String returnType, T o) {
        if (o == null) return null;
        switch (returnType) {
            case "double[]" :
                double[] doubleArray = (double[]) o;
                Double[] doubleArrayWrapped = new Double[doubleArray.length];
                for (int i = 0; i < doubleArray.length; i++) {
                    doubleArrayWrapped[i] = doubleArray[i];
                }
                return (T[]) doubleArrayWrapped;
            case "int[]" :
                int[] intArray = (int[]) o;
                Integer[] integerArrayWrapped = new Integer[intArray.length];
                for (int i = 0; i < intArray.length; i++) {
                    integerArrayWrapped[i] = intArray[i];
                }
                return (T[]) integerArrayWrapped;
            case "float[]" :
                float[] floatArray = (float[]) o;
                Float[] floatArrayWrapped = new Float[floatArray.length];
                for (int i = 0; i < floatArray.length; i++) {
                    floatArrayWrapped[i] = floatArray[i];
                }
                return (T[]) floatArrayWrapped;
            case "long[]" :
                long[] longArray = (long[]) o;
                Long[] longArrayWrapped = new Long[longArray.length];
                for (int i = 0; i < longArray.length; i++) {
                    longArrayWrapped[i] = longArray[i];
                }
                return (T[]) longArrayWrapped;
            case "char[]" :
                char[] charArray = (char[]) o;
                Character[] characterArrayWrapped = new Character[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    characterArrayWrapped[i] = charArray[i];
                }
                return (T[]) characterArrayWrapped;
            case "byte[]" :
                byte[] byteArray = (byte[]) o;
                Byte[] byteArrayWrapped = new Byte[byteArray.length];
                for (int i = 0; i < byteArray.length; i++) {
                    byteArrayWrapped[i] = byteArray[i];
                }
                return (T[]) byteArrayWrapped;
            case "short[]" :
                short[] shortArray = (short[]) o;
                Short[] shortArrayWrapped = new Short[shortArray.length];
                for (int i = 0; i < shortArray.length; i++) {
                    shortArrayWrapped[i] = shortArray[i];
                }
                return (T[]) shortArrayWrapped;
            case "boolean[]" :
                boolean[] booleanArray = (boolean[]) o;
                Boolean[] booleanArrayWrapped = new Boolean[booleanArray.length];
                for (int i = 0; i < booleanArray.length; i++) {
                    booleanArrayWrapped[i] = booleanArray[i];
                }
                return (T[]) booleanArrayWrapped;
            case "Object[]" : case "Double[]": case "Integer[]": case "Character[]": case "Float[]": case "Long[]": case "Byte[]": case "Boolean[]": case "Short[]": return (T[])o;
            default: extraProcess = true; return (T[])o;
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

    private static boolean isJavaClass(Class clazz) {
        return clazz.getName().startsWith("java");
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
