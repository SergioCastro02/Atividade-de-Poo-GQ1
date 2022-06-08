package business.threads;

public class ThreadPlay implements Runnable{

    private int time;
    private String name;

    public ThreadPlay(String name, int time){
        this.name = name;
        this.time = time;
        //Thread thread = new Thread(this);
        //thread.start();
    }

    @Override
    public void run() {

        try{
            for(double i=0; i<=this.time; i++) {
                System.out.println(name +  " - " + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Filme finalizado");
    }

}
