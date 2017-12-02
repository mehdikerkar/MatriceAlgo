package pack;

import java.util.LinkedList;

public class MatriceCreuse implements MatriceCaree{

	static int n=100;
	LinkedList<List3> mtc = new LinkedList<List3>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatriceCreuse mt = new MatriceCreuse();
		double d;

				d=mt.setValue(0, 2, (int)(Math.random()*100));
				d=mt.setValue(3, 4, (int)(Math.random()*100));
				d=mt.setValue(7, 9, (int)(Math.random()*100));
				d=mt.setValue(2, 6, (int)(Math.random()*100));
				d=mt.setValue(9, 1, (int)(Math.random()*100));
				d=mt.setValue(1, 5, (int)(Math.random()*100));
				d=mt.setValue(5, 0, (int)(Math.random()*100));
		System.out.println("######");
		mt.print();
		
	}
	public void print() {
		int i=0;
		System.out.println("{");
		while(mtc!=null) {
			System.out.println("("+mtc.get(i).getI()+", "+mtc.get(i).getJ()+", "+mtc.get(i).getValue()+") ");
		i++;
		}
		System.out.print("}");
	}
	public List3 getElement(int i, MatriceCreuse m) {
		return this.mtc.get(i);
	}

	@Override
	public int taill() {
		return n;
	}
	@Override
	public double getValue(int i, int j) {
		if (i<n && j<n) {
			for(int a = 0;a<mtc.size();a++) {
				if(mtc.get(a).getI()==i) {
					if(mtc.get(a).getJ()==j) {
						return mtc.get(a).getValue();
					}
				}
				if(mtc.get(a).getI()>i || (mtc.get(a).getI()==i && mtc.get(a).getJ()>j) ) {//i>mtc.size()
					return 0;
				}
			}
			return 0;
		}
		return -1;
	}
	@Override
	public double setValue(int i, int j, double v) {
		if (i<n && j<n) {//i>n || j>n
			for(int a = 0;a<mtc.size();a++) {
				if(mtc.get(a).getI()<i && mtc.get(a).getJ()<j) {
					mtc.addFirst(new List3(i, j, v));return 1;
				}
				if(mtc.get(a).getI()<=i && mtc.get(a).getJ()<j  && mtc.get(a+1).getI()>=i && mtc.get(a+1).getJ()>j) {
					mtc.add(a, new List3(i, j, v));return 1;
				}
				if(mtc.get(a).getI()==i && mtc.get(a).getJ()==j) {
					mtc.set(a, new List3(i, j, v));return 1;
				}
				
			}
			mtc.addLast(new List3(i, j, v));return 1;
		}
		return 0;
	}
	@Override
	public void add(MatriceCaree m) {
		MatriceCreuse e =(MatriceCreuse) m;
		if (n==m.taill()) {
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					if(m.getValue(i, j)!=0) {
						if(this.getValue(i, j)==0) this.setValue(i, j, m.getValue(i, j));
						else {
							this.setValue(i, j, m.getValue(i, j)+this.getValue(i, j));
						}
						
					}
				}
			}
		}
		
	}
}
