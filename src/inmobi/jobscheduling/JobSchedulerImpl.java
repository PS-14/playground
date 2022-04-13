package inmobi.jobscheduling;  
  /*   
   Bluemoon
   11/04/22 2:43 PM  
   */

import java.util.PriorityQueue;

public class JobSchedulerImpl implements JobScheduler {
    PriorityQueue<AbstractJob> pendingJobsQueue;
    PriorityQueue<AbstractJob> runningJobQueue;
    int capacity;

    public JobSchedulerImpl(int capacity) {
        pendingJobsQueue = new PriorityQueue<>((j1, j2) -> {
            return Integer.compare(j1.getPriority().val, j2.getPriority().val);
        });
        runningJobQueue = new PriorityQueue<>((j1, j2) -> {
            return Integer.compare(j2.getPriority().val, j1.getPriority().val);
        });
        this.capacity = capacity;
    }

    public synchronized void schedulerJob(AbstractJob job) {
        if (runningJobQueue.size() < capacity) {
            runningJobQueue.add(job);
        } else {
            AbstractJob topRunningJob = runningJobQueue.peek();
            if (job.getPriority().val > topRunningJob.getPriority().val) {
                runningJobQueue.remove(topRunningJob);
                suspendJob(topRunningJob);
                runningJobQueue.add(job);
                pendingJobsQueue.add(topRunningJob);
            }

        }
    }

    public String suspendJob(AbstractJob job) {
        //  save context
        return "11234";
    }

    public void perFormCompletion(AbstractJob job) {
        runningJobQueue.remove(job);
        if (!pendingJobsQueue.isEmpty()) {
            AbstractJob job1 = pendingJobsQueue.poll();
            runningJobQueue.add(job1);
        }
    }
}
