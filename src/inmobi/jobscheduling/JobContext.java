package inmobi.jobscheduling;  
  /*   
   Bluemoon
   11/04/22 2:35 PM  
   */

public class JobContext {

    public String save(AbstractJob job) {
        return "124567";
    }

    Runnable get(String id) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        };
    }
}
