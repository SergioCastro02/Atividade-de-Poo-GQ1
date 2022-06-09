package business.threads;

public class ThreadAdvance implements Runnable {
    private String name;

    public ThreadAdvance(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=10; i>0; i--) {
            System.out.println(name + " - " + i);
        }
    }
}
