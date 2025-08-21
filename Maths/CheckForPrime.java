class CheckForPrime {
     static boolean checkForPrime(Long n){
        // if(n == 1) return false;
        // for(Long i=2L; i*i < n; i++){
        //     if(n%i == 0) return false;
        // }
        // return true;

        if(n == 1) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        for(Long i=5L; i*i<=n; i=i+6){
            if(n%i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(checkForPrime(7L));
	}
}
