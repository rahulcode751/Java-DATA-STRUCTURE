class PowerOfNumber {
    public int reverseNumber(int n){
        int revN = 0;
        while(n>0){
            revN = revN*10 + revN%10;
            n = n/10;
        }
        return revN;
    }
    public int powerOfNumber(int b,int p){
        if(b == 0) return 0;
        if(p == 0) return 1;
        if(p%2 == 0){
            int temp = powerOfNumber(b,p/2);
            return temp*temp;
        }else{
            return b*powerOfNumber(b,p-1);
        }
    }
    public int reverseExponentiation(int n) {
        int revN = reverseNumber(n);
        System.out.println(revN + " "+ n);
        return powerOfNumber(n,revN);
    }
}
