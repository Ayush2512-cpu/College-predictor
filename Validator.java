package app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Pattern r,s;
    private Matcher re,se;
    private boolean cname = false;
    private boolean cmail = false;
    private boolean cmob = false;
    private boolean crank = false;
    public boolean check(String name ,String  email,String mobile,int x) {

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches())
            cmail = true;
        if(x>0 & x<250000)
            crank = true;
        int n = 0;
        for (int i = 0; i < name.length(); i++) {
            if ((name.charAt(i) >= 'A' & name.charAt(i) <= 'Z') | (name.charAt(i) >= 'a' & name.charAt(i) <= 'z') | (name.charAt(i) == ' '))
               n++;
        }
        if(n==name.length())
            cname = true;
        String str = "";
        if(mobile.length() == 10){ cmob = verifymob(mobile);}
        else if(mobile.length() == 11){
            if (mobile.charAt(0) == '0'){
            for(int i = 1;i<mobile.length();i++)
                str +=mobile.charAt(i);
           cmob = verifymob(str); }
        }
        else if(mobile.length() == 12) {
            if (mobile.charAt(0) == '9' && mobile.charAt(1) == '1') {
                for (int i = 2; i < mobile.length(); i++)
                    str += mobile.charAt(i);
                cmob = verifymob(str);
            }
        }
        else
        cmob = false;
        if(cname & cmail & crank & cmob)
            return true;
        return false;
    }

    public boolean verifymob(String s)
    { int x =0;
    if(s.charAt(0)>=55 && s.charAt(0)<=57)
    { for(int i = 1;i<s.length();i++)
        {
            if(s.charAt(i)>=48 && s.charAt(i)<=57){}
              else{x++;}
        }
        if(x==0){return true;}}
        return false;
    }
}
