package javaplayground.multithreading.printNumber;

public class SharedObject {
        int turn;
        int num;
        int iteration;

        public SharedObject(int turn, int num,int i) {
            this.turn = turn;
            this.num = num;
            this.iteration=i;
        }
    }