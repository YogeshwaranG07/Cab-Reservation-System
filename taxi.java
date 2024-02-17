

	

	import java.util.ArrayList;

	public class taxi {
	    int taxino;
	    String pick;
	    int picktime;
	    int earn;
	    ArrayList<booking> aa;
	    taxi(int a){
	        this.taxino=a;
	        this.pick="A";
	        this.picktime=9;
	        this.earn=0;
	        this.aa = new ArrayList<booking>();
	    }
	    public int[] book(String s, String d, int p, int bcn){
	        int[] h = {0,15,30,45,60,75};
	        int distance= h[d.charAt(0)-'A']-h[s.charAt(0)-'A'];
	        int time=distance/15;
	        int dropt=p + time;
	        int fare=((distance-5)*10) + 100;
	        int[] n ={fare,time,dropt};
	        System.out.println("Your taxi is booked");
	        System.out.println("Taxi number :"+bcn +" and fare is "+fare);
	        return n;
	    }
	}


