//https://leetcode.com/problems/boats-to-save-people/
import java.util.*;
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0 , j = people.length - 1;

        int count = 0;
        while(i < j){
            if((people[i] + people[j])< limit) {
                i++;
                j--;
            }
            else if(i+1 < people.length && people[i] + people[i+1] < limit){
                i+=2;
            }
            else i++;

            count++;
        }
        return count;
    }
}
