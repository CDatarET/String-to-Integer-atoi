import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        String ns = "";
        boolean start = false;

        for(int i = 0; i < s.length(); i++){
            if(start && (s.charAt(i) == '-' || s.charAt(i) == '+')){
                break;
            }

            if(s.charAt(i) == '-'){
                if(start){
                    break;
                }
                start = true;
                ns = ns + "-";
                continue;
            }

            if(s.charAt(i) == '+'){
                if(start){
                    break;
                }
                start = true;
                continue;
            }

            if(Character.isDigit(s.charAt(i))){
                ns = ns + s.charAt(i);
                start = true;
            }
            else{
                break;
            }
        }

        if(ns.equals("") || ns.equals("-")){
            return(0);
        }
        System.out.println(ns);
        BigInteger value = new BigInteger(ns);
        if(value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
            return(Integer.MAX_VALUE);
        }
        else if(value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            return(Integer.MIN_VALUE);
        } 
        else{
            return(Integer.parseInt(ns));
        }
    }
}
