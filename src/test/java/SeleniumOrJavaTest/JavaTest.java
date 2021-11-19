package SeleniumOrJavaTest;

import java.text.SimpleDateFormat;
import java.util.*;

public class JavaTest {

    
    public static void main(String arg[])
    {
        String str = "AACCDDDDDXXXXXXjjjjjjjjjjjjjjjjjjjjjjjJDDDDDDDDDDDDDDDDDDEE";
        System.out.println(giveMeCharWithLargestConsecutiveAppearence(str.toLowerCase()));

    }

    public static String giveMeCharWithLargestConsecutiveAppearence(String str)
    {

        char max_Char = 0;
        int max_Lenght,count;
        char currentCharacter, previousChar;
        count=1;
        max_Lenght=1;

        for(int i=2; i<=str.length()-1;i++ )
        {
            previousChar = str.charAt(i-1);
            currentCharacter= str.charAt(i);

            if(previousChar==currentCharacter)
            {
                count=count+1;
            }
            else
            {
                count=1;
            }
            if(count>max_Lenght)
            {
                max_Char = currentCharacter;
                max_Lenght=count;
            }
        }

        return "Mac Char : " + max_Char + " count : " + max_Lenght;
    }
}
