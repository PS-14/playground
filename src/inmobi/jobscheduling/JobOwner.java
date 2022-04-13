package inmobi.jobscheduling;  
  /*   
   Bluemoon
   11/04/22 2:27 PM  
   */

public class JobOwner {
    String id;
    String name;
    String emailId;
    String mobile;

    public String getId() {
        return id;
    }

    public JobOwner _setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JobOwner _setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public JobOwner _setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public JobOwner _setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
