package uber;
  /*   
   Bluemoon
   06/04/22 1:36 PM  
   */

public class ProcessingResponse {
    int indexOfFirstChar;
    int indexOfLastChar;
    boolean isMatch;

    public ProcessingResponse() {
    }

    public ProcessingResponse(int indexOfFirstChar, int indexOfLastChar, boolean isMatch) {
        this.indexOfFirstChar = indexOfFirstChar;
        this.indexOfLastChar = indexOfLastChar;
        this.isMatch = isMatch;
    }
}
