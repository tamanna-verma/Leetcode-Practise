class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
    
        ArrayList<Integer> freeTimes = new ArrayList<>();
        if(startTime[0]>0)freeTimes.add(startTime[0]);
        for(int i=1;i<startTime.length;i++){
            int start = startTime[i];
            int end = endTime[i-1];
            freeTimes.add(start-end);
        }
        if(endTime[endTime.length-1]<eventTime)freeTimes.add(eventTime-endTime[endTime.length-1]);
        
        int max = Integer.MIN_VALUE;
        int curr = 0;

        int i=0;
        int j=0;

        int allowedJoins=0;
       System.out.println(freeTimes);
        while(j<freeTimes.size()){
            curr+=freeTimes.get(j);
            max=Math.max(max,curr);

            allowedJoins++;
            if(allowedJoins==k+1){
                allowedJoins--;
                curr-=freeTimes.get(i);
                i++;
            }
            j++;
        }
       
       return max;
    }
}// k+1 kyuki hum gaps dekhrhe hai objects nhi , 
//phle sab freeTimes ko compute kro , fir unme k+1 size ki sliding window krke max nikalte rho