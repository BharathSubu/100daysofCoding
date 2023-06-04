//https://leetcode.com/problems/bulb-switcher/description/
import java.util.*;
public class BulbSwitcher {

        public int bulbSwitch(int n) {
            int count = 0;
            int curr = 0;
            int odd = 1;
            while(curr <= n){
                count++;
                curr+=odd;
                odd+=2;
            }
            return count-1;
        }

}
