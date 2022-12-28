import java.sql.SQLOutput;

//https://leetcode.com/problems/lemonade-change/
public class LemonadeChange {
    static class Cpair{
        int v = 0;
        int c = 0;
        Cpair(int a , int b){
            v = a;
            c = b;
        }

    }
    public static  boolean lemonadeChange(int[] bills) {
        Cpair c5 = new Cpair(5,0);
        Cpair c10 = new Cpair(10,0);
        Cpair c20 = new Cpair(20,0);
        Cpair count[] ={c5,c10,c20};
        for (int bill : bills) {
            if(bill==5) count[0].c++;
            else{
               int got = bill;
               bill-=5;
               for(int i = 2 ; i>=0;i--){
                   int part = bill/count[i].v;
                   if(part!=0 && part <= count[i].c){
                       bill-=(part*count[i].v);
                       count[i].c-=part;
                   }
               }
               if(bill!=0) return false;
               int idx = (got == 10) ? 1 : 2 ;
               count[idx].c++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int change[] ={5,5,10,10,20};
        System.out.println(lemonadeChange(change));
    }
}
