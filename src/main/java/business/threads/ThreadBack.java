package business.threads;

public class ThreadBack implements Runnable  {
    private String name;

    public ThreadBack(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0; i>=10; i++) {
            System.out.println(name + " - " + i);
        }
        System.out.println(name + " finalizou a execução.");
    }
}


