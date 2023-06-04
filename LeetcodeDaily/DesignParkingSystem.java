//https://leetcode.com/problems/design-parking-system/
import java.util.*;
public class DesignParkingSystem {
    int arr[] = new int[3];

    public DesignParkingSystem(int big, int medium, int small) {
        arr[0] = big; arr[1] = medium ; arr[2] = small;
    }

    public boolean addCar(int carType) {
        if(arr[carType-1] > 0){
            arr[carType-1]--;
            return true;
        }
        return false;
    }
}
