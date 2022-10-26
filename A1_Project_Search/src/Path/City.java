package Path;

public class City {

	public int cost=0;
	public int h1=0;
	public int h2=0;
	public String source="city1";
	public String dest="city2";
	

	public City() {
		
	}

	public City(int cost,int h1,int h2,String source,String dest) {
		this.cost=cost;
		this.h1=h1;
		this.h2=h2;
		this.source=source;
		this.dest=dest;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getH1() {
		return h1;
	}


	public void setH1(int h1) {
		this.h1 = h1;
	}


	public int getH2() {
		return h2;
	}


	public void setH2(int h2) {
		this.h2 = h2;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDest() {
		return dest;
	}


	public void setDest(String dest) {
		this.dest = dest;
	}
}
