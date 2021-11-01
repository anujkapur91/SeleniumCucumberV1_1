package SeleniumOrJavaTest;

import java.text.SimpleDateFormat;
import java.util.*;

public class JavaTest {

    public static void main(String...args)
    {
//        List<String> list = Arrays.asList("B", "A", "A", "C", "B", "A");
//
//        Set<String> distinct = new HashSet<>(list);
//        for (String s: distinct) {
//            System.out.println(s + ": " + Collections.frequency(list, s));
//        }

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        timeStamp = timeStamp.replaceAll("[.]*", "");

        System.out.println(timeStamp);

    }

    public void printEnum(ss st)
    {
        String x =  st.toString();
        System.out.println(x);
    }

    enum ss
    {
        FullScreenShot, ElementScreenShot;
    }
}
