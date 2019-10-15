import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
public class pruebaplc
{
    public static void main(String arg[])
    {
        String[]nombres={"temperatura","calidad"};
        
        ExecutorService exec = Executors.newCachedThreadPool();
        for(String n:nombres)
        {
            plcs e= new plcs(n);
            exec.execute(e);
        }
        exec.shutdown();
        try{
            exec.awaitTermination(100, TimeUnit.SECONDS);
            System.out.println("los plcs han terminado");
        }
        catch(InterruptedException e)
        {
            System.out.println("se interrumpio");
            
        }
       
    }
}