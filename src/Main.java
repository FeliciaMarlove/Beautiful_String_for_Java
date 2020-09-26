/*
Short demo of the use of BeautifulString abstract class on the ExampleClass
 */

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ExampleClass dummyExample = new ExampleClass(5, true, false, "blablabla", new ExampleClass(), new double[]{5.0, 2.3, 52.2}, new ArrayList(), new HashMap());
        BeautifulString.show(dummyExample);
    }
}
