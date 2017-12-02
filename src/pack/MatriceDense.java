package pack;

public class MatriceDense implements MatriceCaree {

	static int n=10;
	double [][] t= new double[n][n];
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub

		MatriceDense mt = new MatriceDense();
		MatriceDense mv = new MatriceDense();
		double d;
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				d=mt.setValue(i, j, (int)(Math.random()*10));
				System.out.print(mt.getValue(i, j)+"   ");
			}
			System.out.println();
		}
		System.out.println("######");
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				d=mv.setValue(i, j, (int)(Math.random()*10));
				System.out.print(mv.getValue(i, j)+"   ");
			}
			System.out.println();
		}
		System.out.println("######");
		mt.add(mv);
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(mt.getValue(i, j)+"   ");
			}
			System.out.println();
		}
		

	}

	public MatriceDense () {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				t[i][j]=0;
			}
		}
	}
	@Override
	public int taill() {	return t.length;	}
	@Override
	public double getValue(int i, int j){	return t[i][j]; 	}
	@Override
	public double setValue(int i, int j, double v){
		t[i][j] = v;
		return 	1;
		}
	@Override
	public void add(MatriceCaree m) {
		if(t.length==m.taill())
		{
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					t[i][j]=t[i][j]+m.getValue(i, j);
				}
			}	
		}else
		{
			System.out.println("Size not much");
		}
		
		
	}
	


}
