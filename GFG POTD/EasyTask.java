//https://practice.geeksforgeeks.org/problems/c928f229cc972671d91c5e9f6b222414912cc88a/1
import java.util.*;
public class EasyTask {
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<q;i++){
            if(queries[i].type=="1"){
                s=getType1(s,Integer.parseInt(queries[i].a),queries[i].b.charAt(0));
            }else{
                list.add(getType2(s,Integer.parseInt(queries[i].a),Integer.parseInt(queries[i].b),Integer.parseInt(queries[i].c)));
            }
        }
        return list;
    }

    public static char getType2(String s,int left,int right,int k){
        int[] freq=new int[26];
        for(int i=left;i<=right;i++){
            freq[(int)(s.charAt(i))-(int)'a']++;
        }
        int count=0;
        for(int i=25;i>=0;i--){
            while(count<k && freq[i]>0){
                count++;
                freq[i]--;
            }
            if(count==k){
                return (char)((int)'a'+i);
            }
        }
        return 'a';
    }

    public static String getType1(String s,int ind,char c){
        return s.substring(0,ind)+c+s.substring(ind+1);
    }
}

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}