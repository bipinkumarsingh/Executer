import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static volatile ExecutorService executorService =null;
    private static volatile Future futureOneResult=null;
    private static volatile Future futureTwoResult=null;

    public static void main(String[] args) {
        System.out.println("Hello World!");

        executorService= Executors.newFixedThreadPool(2);

        while (true)
        {
            try {
                checkTask();
                Thread.sleep(1000);
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

    private static void  checkTask()
    {
            if(futureOneResult==null || futureOneResult.isDone()||futureOneResult.isCancelled())
            {
                executorService.submit(new TestOne());
            }
        if(futureTwoResult==null || futureTwoResult.isDone()||futureTwoResult.isCancelled())
        {
            executorService.submit(new TestTwo());
        }

    }

}

class TestOne implements  Runnable
{
    @Override
    public void run() {
        while (true)
        {
            try {
                System.out.println("Executing task1");
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }

    }
}

class TestTwo implements  Runnable
{
    @Override
    public void run() {
        while (true)
        {
            try {
                System.out.println("Executing task2");
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }

    }
}






