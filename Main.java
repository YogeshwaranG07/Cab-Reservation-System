



	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Scanner;

	public class Main {
	    Scanner sc = new Scanner(System.in);
	    ArrayList<taxi> t = new ArrayList<taxi>();
	    ArrayList<booking> b = new ArrayList<booking>();
	    int[] h = {0,15,30,45,60,75};
	    int id=1;
	    public static void main(String[] args) {
	       Main ma = new Main();
	       ma.getChoice();
	    }
	    public void getChoice(){
	        System.out.println("Enter a number");
	        System.out.println("1.Start");
	        System.out.println("2.Booking");
	        System.out.println("3.Taxi details");
	        System.out.println("4.Exit");
	        int w = sc.nextInt();
	        switch (w){
	            case 1:{
	                t.add(new taxi(1));
	                t.add(new taxi(2));
	                t.add(new taxi(3));
	                t.add(new taxi(4));
	                getChoice();
	                break;
	            }
	            case 2 :{
	                sc.nextLine();
	                System.out.println("Enter pick up point");
	                String s = sc.nextLine();
	                System.out.println("Enter drop point");
	                String d = sc.nextLine();
	                System.out.println("Enter pick up time");
	                int p = sc.nextInt();
	                int bcn = 0;
	                int cfare = Integer.MAX_VALUE;
	                boolean flag = false;
	                for(taxi x :t){
	                    if(x.pick.equalsIgnoreCase(s)){
	                        if(x.picktime>p) continue;
	                        if(x.earn<cfare){
	                            cfare=x.earn;
	                            bcn=x.taxino;
	                            flag=true;
	                        }
	                    }
	                }
	                if(!flag){
	                    int min=Integer.MAX_VALUE;
	                    for(taxi x  :t){
	                        if(h[s.charAt(0)-'A']-h[x.pick.charAt(0)-'A']<min){
	                            if(x.picktime>p) continue;
	                            min=h[s.charAt(0)-'A']-h[x.pick.charAt(0)-'A'];
	                            bcn=x.taxino;
	                        }
	                    }
	                }
	                for(taxi x : t){
	                    if(x.taxino==bcn){
	                        int[] n = x.book(s,d,p,bcn);
	                        x.pick=d;
	                        x.picktime=x.picktime+n[1];
	                        x.earn=x.earn+n[0];
	                        x.aa.add(new booking(id++,bcn,n[0],p,n[2],s,d));
	                        b.add(new booking(id,bcn,n[0],p,n[2],s,d));
	                    }
	                }
	                getChoice();
	                break;
	            }
	            case 3: {
	                System.out.println("Enter taxi number");
	                int e = sc.nextInt();
	                for(taxi x : t){
	                    if(x.taxino==e){
	                        System.out.print("Taxi no : "+x.taxino+"                 Taxi earnings : "+x.earn);
	                        System.out.println("");
	                        for(booking bk : x.aa){
	                            System.out.print(bk.id+"  "+bk.pick+"  "+bk.drop+"  "+bk.pickt+"  "+bk.dropt+"  "+bk.fare);
	                            System.out.println("");
	                        }
	                    }
	                }
	                getChoice();
	                break;
	            }
	            case 4:{
	            	System.out.println("Thank you...");
	                return;
	            }
	            default:{
	                System.out.print("Invalid option");
	            }
	        }
	    }
	}
	


