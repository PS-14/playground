package inmobi.jobscheduling;

public enum JobPriority {
    P0(0),
    P1(1),
    P2(2);
    int val;

    JobPriority(int v) {
        this.val = v;
    }

    public int getVal() {
        return val;
    }

    public JobPriority _setVal(int val) {
        this.val = val;
        return this;
    }

}
