import java.lang.Thread;

public class Deadlock{
    public static final String str1="hello";
    public static final String str2 = "hello2";


    public static void main(String args){
       Thread t1 =  new Thread(() -> {
            try {
                synchronized (str1) {
                    Thread.sleep(1500);
                    synchronized (str2) {
                        Thread.sleep(1500);
                    }
                }
            }catch(Exception e){e.printStackTrace();}

            });

        Thread t2 =  new Thread( ()->{
            try {
                synchronized (str2) {
                    Thread.sleep(1500);
                    synchronized (str1) {
                        Thread.sleep(1500);
                    }
                }
            }catch(Exception e){e.printStackTrace();}

        });
        // start the above threads.. t1 will lock str1 and wait for str2 and t2 will do vice versa
        t1.start(); t2.start();
        }
    }
