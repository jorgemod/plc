import conexion.conectar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.Random;

//"["alexander","90",12/12/1992]"
public class emulador
{
  public static void main(String[] args)
  {
    TimerTask timerTask = new TimerTask()
    {
      conectar conn;
      Calendar calendario = Calendar.getInstance();
      String fechaCadena;
      String tupla;
      int loop = 0;
      public void run()
      {
        loop++;
        fechaCadena = "'" +Integer.toString(calendario.get(Calendar.YEAR)) + "/" + Integer.toString(calendario.get(Calendar.MONTH) + 1)  + "/" +Integer.toString(calendario.get(Calendar.DATE)) +"'";
        if( loop%25 == 0 )
        {
          if( loop%2 == 0)
            tupla = (Math.random() * (85 - 89) + 89) + "," + fechaCadena + "," + "1";
          else
            tupla = (Math.random() * (96 - 100) + 100) + "," + fechaCadena + "," + "1";
        }
        else
        {
          tupla = (Math.random() * (95 - 90) + 90) + "," + fechaCadena + "," + "1";
        }
        String tabla = "temperatura";
        
        System.out.println(tupla);
        conn = new conectar(tupla,tabla);
      }
    };
    Timer timer = new Timer();
    timer.schedule(timerTask, 0, 1000);
  }
}
