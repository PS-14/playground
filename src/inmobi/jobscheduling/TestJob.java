package inmobi.jobscheduling;  
  /*   
   Bluemoon
   11/04/22 2:33 PM  
   */

public class TestJob extends AbstractJob {

    public TestJob(String jobName, JobPriority priority) {
        super(jobName, priority);
    }

    @Override
    public void run() {
        System.out.println("executing job");
    }
}
