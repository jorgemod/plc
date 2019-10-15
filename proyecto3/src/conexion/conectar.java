package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author coque
 */
public class conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/plc";
    private static String values ;
    private static String tabla;
    private PreparedStatement ps;
    public conectar(String values,String tabla)
    {
        ps=null;
        conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null){
                System.out.println("conexion exitosa..");
                if(tabla == "temperatura")
                {
                    System.out.println("temperatura");
                    //temperatura
                    ps = conn.prepareStatement("INSERT INTO"+" "+tabla+"(id_encargado,id_plc,Telefono_encargado,Fecha,Temperatura)"+"values"+"(" +values+ ")");
                    ps.executeUpdate();
                    
                }
                else
                {
                    //calidad
                    ps = conn.prepareStatement("INSERT INTO"+" "+tabla+"(id_encargado,tel_encargado,estado,fecha,id_plc)"+"values"+"(" +values+ ")");
                    ps.executeUpdate();
                }
                
                
                        }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error en la consulta"+e);
        }
        
            
    }
    
}
