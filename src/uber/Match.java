package uber;
  /*   
   Bluemoon
   06/04/22 1:17 PM  
   */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Match {

    private static int NO_OF_THREADS = 4;
    private ExecutorService THREAD_POOL = Executors.newFixedThreadPool(NO_OF_THREADS);
    Map<Character, Integer> map;

    public Match() {
        map = new HashMap<>();
    }

    public boolean isMatchingV2(String rule, String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        populateIndexInMap(rule);
        int textLength = text.length();
        int segmentNumber = 0;
        Map<Integer, Future<ProcessingResponse>> responseMap = new HashMap<>();
        int SEGMENT_LENGTH = Math.max(textLength / NO_OF_THREADS, 1);
        while (textLength > 0) {
            String segment = text.substring(segmentNumber * SEGMENT_LENGTH, Math.min((segmentNumber + 1) * SEGMENT_LENGTH, text.length()));
            Future<ProcessingResponse> response = THREAD_POOL.submit(() -> {
                return process(segment);
            });
            responseMap.put(segmentNumber, response);
            segmentNumber++;
            textLength = textLength - SEGMENT_LENGTH;
        }
        ProcessingResponse prevSegmentResponse = null;
        for (int i = 0; i < segmentNumber; i++) {
            try {
                ProcessingResponse response = responseMap.get(i).get();
                if (!response.isMatch) {
                    return false;
                }
                if (prevSegmentResponse != null) {
                    if (response.indexOfFirstChar < prevSegmentResponse.indexOfLastChar) {
                        return false;
                    }
                }
                prevSegmentResponse = response;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return true;

    }

    private ProcessingResponse process(String segment) {
        int firstCharIndex = -1;
        int prevIndex = -1;
        for (int i = 0; i < segment.length(); i++) {
            if (map.containsKey(segment.charAt(i))) {
                int index = map.get(segment.charAt(i));
                if (prevIndex == -1) {
                    firstCharIndex = index;
                } else {
                    if (prevIndex > index) {
                        return new ProcessingResponse(firstCharIndex, prevIndex, false);
                    }
                }
                prevIndex = index;
            }
        }
        return new ProcessingResponse(firstCharIndex, prevIndex, true);
    }


    public boolean isMatching(String rule, String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        populateIndexInMap(rule);
        int lastCharIndex = -1;
        for (int i = 0; i < text.length(); i++) {
            if (map.containsKey(text.charAt(i))) {
                int index = map.get(text.charAt(i));
                if (lastCharIndex != -1 && index < lastCharIndex) {
                    return false;
                }
                lastCharIndex = index;
            }
        }
        return true;
    }

    private void populateIndexInMap(String rule) {
        map.clear();
        if (rule == null || rule.isEmpty()) {
            return;
        }
        for (int i = 0; i < rule.length(); i++) {
            map.put(rule.charAt(i), i);
        }
    }

    public static void main(String[] args) {
        Match match = new Match();
        String rule = "abcdefgh";
        String text = "abc";
        System.out.println(match.isMatchingV2(rule, text));
    }
}
