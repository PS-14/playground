package inmobi.jobscheduling;

public interface JobScheduler {

   public void schedulerJob(AbstractJob job);

   public String suspendJob(AbstractJob job);

   public void perFormCompletion(AbstractJob job);

}
