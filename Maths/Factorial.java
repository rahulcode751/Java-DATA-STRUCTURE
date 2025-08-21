package maths;

class Factorial {
    static int factIterative(int n)
	{
		int res = 1;
		for(int i=2; i<=n; i++)
		{
			res = res * i;
		}
		return res;
	}
    static int factRecursive(int n){
        if(n == 0) return 1;
        return n = n * factRecursive(n-1);
    }
    public static void main(String[] args) {
        System.out.println(factRecursive(5));
        System.out.println(factIterative(5));
    }
}

