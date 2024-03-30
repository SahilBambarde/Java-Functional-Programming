public class F05Threads {
    public static void main(String...a){
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10000;i++){
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
            }
        };


        Runnable r2 =() ->{
            for(int i=0;i<10000;i++){
                System.out.println(Thread.currentThread().getId() + ":" + i);
            }
        };

        Thread thread =  new Thread(r2);
        thread.start();

        Thread thread1 = new Thread(r2);
        thread1.start();

        Thread thread2 = new Thread(r2);
        thread2.start();

    }
}
