package interviews.inmobi;  
  /*   
   Bluemoon
   01/04/22 8:39 AM  
   */

/*
1. user select the available seats   cache/db
2. when user go click proceed to payment then we take lock over seats for some time (may be 2 min) using atomic operations
   seatId ->
3. if some concurrent user also selected same seats(intersection) so it will found that lock is taken over some seats exception can be thrown  or message can be shown that seat has been booked please try again
4. for all



 */


public class Main1 {
}
