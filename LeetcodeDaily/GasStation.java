// https://leetcode.com/problems/gas-station/description/
class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //gas cost ratio

        int totalCost = 0;
        int totalGas = 0;
        int n = gas.length;
        for(int i=0;i<n;i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if(totalCost > totalGas)
            return -1;

        int startIndex=0, curFuel = 0;

        for(int i=0;i<n;i++){
            if(curFuel < 0){
                curFuel = 0;
                startIndex = i;
            }

            curFuel += (gas[i]-cost[i]);
        }
        return startIndex;

    }
}