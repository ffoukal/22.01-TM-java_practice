package core;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    /**
    *   Converts an integer array to
    *   string list
    *
    *   @param int_list integer array
    *   @return List<String> converted list
    */
    public static List<String> convertArray(int[] int_list){
        List<String> converted_list = new ArrayList<>();

        for(Integer number : int_list){
            converted_list.add(Integer.toString(number));
        }

        return converted_list;
    }

    /**
     * Pad strings with zeros to the left
     * based in the maximum length of the strings
     * in the list
     *
     * @param str_list string list
     * @return padded string list
     */
    public static List<String> padWithZeros(List<String> str_list){

        List<String> padded_list = new ArrayList<>();
        int max_length_string = StringUtil.getMaxLengthFromStringList(str_list);
        String format = "%0" + max_length_string + "d";

        for(String str : str_list){
            String pad = String.format(format, Integer.parseInt(str));
            padded_list.add(pad);
        }

        return padded_list;
    }

    /**
     *  Pad to the left
     *
     * @param s String to pad
     * @param c character to fill string
     * @param places number of times to repeat the character
     */
    public static String lpad(String s, char c, int places){
        String format = "%" + c + places + "s";
        String pad = Character.toString(c).repeat(places - s.length()) + s;
        return pad;
    }

    /**
     *  Pad to the right
     *
     * @param s String to pad
     * @param c character to fill string
     * @param places number of times to repeat the character
     */
    public static String rpad(String s, char c, int places){
        String format = "%" + c + places + "s";
        String pad = s + Character.toString(c).repeat(places - s.length());
        return pad;
    }

    /**
     *  Remove whitespaces from the string beginning
     *  @param s string to trim left
     *  @return trimmed string
     */
    public static String ltrim(String s){
        int i = 0;
        while(i < s.length() && Character.isWhitespace(s.charAt(i))){
            i++;
        }
        return s.substring(i);
    }

    /**
     *  Remove whitespaces from the string ending
     *  @param s string to trim right
     *  @return trimmed string
     */
    public static String rtrim(String s){
        int i = s.length() -1;
        while(i >= 0 && Character.isWhitespace(s.charAt(i))){
            i++;
        }
        return s.substring(0, i+1);
    }

    /**
     *  Remove whitespaces from the beginning and the ending of a string
     *  @param s string to trim
     *  @return trimmed string
     */
    public static String trim(String s){
        return ltrim(rtrim(s));
    }

    /**
     *
     */
    public static int indexOfN(String s, char c, int n){
        int lastIndex = 0;
        int buffer = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                lastIndex = i;
                buffer++;
            }
            if (buffer == n-1) {
                break;
            };
        }
        if( n > buffer) throw new RuntimeException("La repetición nª " + n + " del caracter no existe. Última posición en index: " + lastIndex);
        return lastIndex+1;
    }



    /**
     * Get the maximum length of a
     * string list
     *
     * @param str_list string list
     * @return maximum length
     */
    public static int getMaxLengthFromStringList(List<String> str_list){
        int max_length_string = 0;
        for(String str : str_list){
            if(str.length() > max_length_string){
                max_length_string = str.length();
            }
        }
        return max_length_string;
    }

}
