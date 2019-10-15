import conexion.conectar;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
class  plcs implements Runnable{
    private String nombre;
    
    conectar conn;
    int loop = 0;
    int loop1 = 0;
    public plcs(String nombre)
    {
       this.nombre = nombre;
    }
    public synchronized void run()
    {
        try{

            while(true)
            {
                
               insertar();
               Thread.sleep(100);
                
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
   
      public String temp()
    {
      Calendar calendario = Calendar.getInstance();
      String fechaCadena;
      String tupla= "1"+"," + "1" +"," ;
      loop1++;
        tupla = "1" + "," + "1" + "," + "2441475065" + ",";
        fechaCadena ="'"+ Integer.toString(calendario.get(Calendar.YEAR)) + "-" + Integer.toString(calendario.get(Calendar.MONTH) + 1) + "-" + Integer.toString(calendario.get(Calendar.DATE)) + " " + Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(calendario.get(Calendar.MINUTE)) + ":" + Integer.toString(calendario.get(Calendar.SECOND))+"'";
        tupla += fechaCadena + ",";
        if( loop%25 == 0 )
        {
          if( loop%2 == 0)
            tupla += (Math.random() * (85 - 89) + 89);
          else
            tupla += (Math.random() * (96 - 100) + 100);
        }
        else
          tupla += (Math.random() * (95 - 90) + 90);
        System.out.println("Temperatura: " + tupla);
        return tupla;
    }
        
        
    
    public  synchronized  void insertar ()
    {
        
        if(nombre == "calidad") 
        {
            
            System.out.println(nombre);
            try {
           conn = new conectar(cali(),nombre); //aqui va lo de la consultaa     
            } catch (Exception e) {
            }
           
           
        }
        else
        {
           
            
            System.out.println(nombre);
            try {
                 conn = new conectar(temp(),nombre); //aqui va lo de la consultaa
            } catch (Exception e) {
            }
           
            
             
        }   
    }
    
    public String cali()
    {
      Calendar calendario = Calendar.getInstance();
      String fechaCadena1;
      String tupla= "" ;
      loop++;
      fechaCadena1 ="'"+ Integer.toString(calendario.get(Calendar.YEAR)) + "-" + Integer.toString(calendario.get(Calendar.MONTH) + 1) + "-" + Integer.toString(calendario.get(Calendar.DATE)) + " " + Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(calendario.get(Calendar.MINUTE)) + ":" + Integer.toString(calendario.get(Calendar.SECOND))+"'";
      System.out.println(loop);
      if( loop%21 == 0 )
       {
           tupla = "2"+ "," + "'2441480773'"+ ","+0+","+ fechaCadena1 + ","+ 2;
       }
        else
       {
          tupla = "2"+ "," + "'2441480773'"+ "," +1+","+ fechaCadena1 + ","+ 2;
          loop ++;
           System.out.println("Calidad: " + tupla + "\n");
       }
        //System.out.println(tupla);
        return tupla;
    }
}

