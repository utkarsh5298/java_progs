import java.util.Scanner;

abstract class Reservation{
    abstract public boolean reserve(int seat,String typeOfSeat);
    abstract public int getAvailSeats();
}

class ReserveTrain extends Reservation{
    int seat;
    static int nost=72;
    String tos;
    public boolean reserve(int seat, String typeOfSeat) {
        this.seat=seat;
        tos=typeOfSeat;
        if(this.seat>0 && tos!=null && this.seat<=nost) {
            System.out.println("seats available "+getAvailSeats());
            return true;}
        else
            return false;
    }

    public int getAvailSeats() {
        // TODO Auto-generated method stub
        nost = nost-seat;
        return (nost);  //available minus requested for reservation
    }

}
class ReserveBus extends Reservation{
    int seat;
    static int nosb=50;
    String tos;
    public boolean reserve(int seat, String typeOfSeat) {
        this.seat=seat;
        tos=typeOfSeat;
        if(this.seat>0 && tos!=null &&this.seat<=nosb) {
            System.out.println("seats available "+getAvailSeats());
            return true;}
        else
            return false;
    }

    public int getAvailSeats() {
        nosb = nosb-seat;
        return (nosb);     }

}
public class Q13A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ReserveTrain rt=new ReserveTrain();
        ReserveBus rb=new ReserveBus();
        int op,seat;
        String tos;
        boolean b;
        while(true) {
            System.out.println("Select an option 1.Reserve Train 2.Reserve  Bus");
            op=sc.nextInt();
            switch(op) {
            case 1:
            System.out.println("number of seats availabe" +rt.nost);
            System.out.println("enter type of seat (ac/sleeper/general)");
            tos=sc.next();
            System.out.println("enter number of seats to reserve ");
            seat=sc.nextInt();
            b=rt.reserve(seat, tos);
            System.out.println("reservation successful? "+b);
            break;
            case 2:
            System.out.println("number of seats availabe" +rb.nosb);
            System.out.println("enter type of seat (ac/sleeper/general)");
            tos=sc.next();
            System.out.println("enter number of seats to reserve ");
            seat=sc.nextInt();
            b=rb.reserve(seat, tos);
            System.out.println("reservation successful? "+b);
            break;
            }
        }
    }
}
