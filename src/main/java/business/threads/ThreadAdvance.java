package business.threads;

public class ThreadAdvance implements Runnable {
    private int time;
    private String name;

    public ThreadAdvance(String name, int time){
        this.name = name;
        this.time = time;
        //Thread thread = new Thread(this);
        //thread.start();
    }

    @Override
    public void run() {

        try{
            for(int i=10; i>0; i--){
                System.out.println(name +  " - " + i);
                Thread.sleep(time);
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(name + " finalizou a execução.");
    }
}
