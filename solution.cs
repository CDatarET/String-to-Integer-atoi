public class Solution {
    public int MyAtoi(string s) {
        s = s.Trim();
        string ns = "";
        bool start = false;

        for(int i = 0; i < s.Length; i++){
            if(start && (s[i] == '-' || s[i] == '+')){
                break;
            }

            if(s[i] == '-'){
                if(start){
                    break;
                }
                start = true;
                ns = ns + "-";
                continue;
            }

            if(s[i] == '+'){
                if(start){
                    break;
                }
                start = true;
                continue;
            }

            if(Char.IsDigit(s[i])){
                ns = ns + s[i];
                start = true;
            }
            else{
                break;
            }
        }

        if(ns == "" || ns == "-"){
            return(0);
        }

        BigInteger value = BigInteger.Parse(ns);
        if(value > int.MaxValue){
            return(int.MaxValue);
        }
        else if(value < int.MinValue){
            return(int.MinValue);
        } 
        else{
            return((int)value);
        }
    }
}
