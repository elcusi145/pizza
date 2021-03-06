package modelos;

import Excepciones.DataAccessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CadeteDAO {
    
    public void agregar (Cadete cadete) throws DataAccessException{
         try{
            Connection con = BaseDeDatos.getInstance();
            PreparedStatement ps = con.prepareStatement("INSERT INTO cadetes "
                    + "             (dni_cadete, nombre_cadete, apellido_cadete,"
                    + "estado_cadete, foto_cadete, activo VALUES (?,?,?,?,?,?)");
            ps.setInt(1,cadete.getDni());
            ps.setString(2, cadete.getNombre());
            ps.setString(3, cadete.getApellido());
            ps.setInt(4, cadete.getEstado());
            ps.setString(5, cadete.getFoto());
            ps.setBoolean(6, cadete.getActivo());
            ps.execute();
        }catch(Exception ex){throw new DataAccessException("Error en CadeteDAO.agregar() "+ex);}
        
    }
    
    public void actualizar (Cadete cadete) throws DataAccessException{
    
        try{
            Connection con = BaseDeDatos.getInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE cadetes SET "
                    + "             nombre_cadete = ?, apellido_cadete = ?, estado_cadete = ?,"
                    + "              foto_cadete = ?, activo = ? WHERE dni_cadete=?");

            ps.setString(1, cadete.getNombre());
            ps.setString(2, cadete.getApellido());
            ps.setInt(3, cadete.getEstado());
            ps.setString(4, cadete.getFoto());
            ps.setBoolean(5, cadete.getActivo());
            ps.setInt(6, cadete.getDni());
            ps.execute();
        }catch(Exception ex){throw new DataAccessException("Error en CadeteDAO.actualizar() "+ex);}
        
    }
    
    public void eliminar (int dni) throws DataAccessException{
    
        try{
            Connection con = BaseDeDatos.getInstance();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM cadetes WHERE codigo_cliente='"+dni+"'");
            st.close();
        }catch (Exception ex){throw new DataAccessException("Error en CadeteDAO.eliminar() "+ex);}
        
    }
    
    
    public ArrayList buscarTodo() throws DataAccessException{
        try{
            Connection con = BaseDeDatos.getInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cadetes order by dni_cadete");
            Cadete cadete = null;
            ArrayList lista = new ArrayList();
            while(rs.next())
            {
                cadete = new Cadete();
                cadete.setDni(rs.getInt("dni_cadete"));
                cadete.setNombre(rs.getString("nombre_cadete").trim());
                cadete.setApellido(rs.getString("apellido_cadete").trim());
                cadete.setEstado(rs.getInt("estado_cadete"));
                cadete.setFoto(rs.getString("foto_cadete").trim());
                cadete.setActivo(rs.getBoolean("activo"));
                lista.add(cadete);
            }
            rs.close();
            st.close();
            return lista;
        }catch (Exception ex){throw new DataAccessException("Error en CadeteDAO.buscarTodo() "+ex);}
    
    }
    
    
    public Cadete buscarCadete(int cod) throws DataAccessException{
        try{
            Connection con = BaseDeDatos.getInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cadetes where cod_cadete='"+cod+"'");
            Cadete cadete = null;
             while(rs.next())
            {
                cadete = new Cadete();
                cadete.setDni(rs.getInt("dni_cadete"));
                cadete.setNombre(rs.getString("nombre_cadete").trim());
                cadete.setApellido(rs.getString("apellido_cadete").trim());
                cadete.setEstado(rs.getInt("estado_cadete"));
                //adete.setFoto(rs.getString("foto_cadete").trim());
                cadete.setActivo(rs.getBoolean("activo"));
            }   
            
            rs.close();
            st.close();
            return cadete;
        }catch (Exception ex){throw new DataAccessException("Error en CadeteDAO.buscarCadete() "+ex);}
   
    }
    public Object[][] listadoCadetesCusi() throws DataAccessException{
        try{
            Connection con = BaseDeDatos.getInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cadetes order by cod_cadete asc");
            int tam=0;
            while(rs.next())
                tam++;
            Object[][] lista = new Object[tam][4];
            int i=0;
            rs.close();
            rs = st.executeQuery("SELECT * FROM cadetes order by cod_cadete asc");
            while(rs.next())
            {
                lista[i][0] = rs.getInt("cod_cadete");
                lista[i][1] = rs.getString("apellido_cadete").trim();
                lista[i][2] = rs.getString("nombre_cadete").trim();
                if(rs.getBoolean("activo")==true){
                    lista[i][3]="Cadete";
                }else
                    lista[i][3]="Eliminado";
                i++;
            }
            rs.close();
            st.close();
            return lista;
            
        }catch (Exception ex){throw new DataAccessException("Error en UsuarioDAO.buscarCliente() "+ex);}
    }
    public Object[][] listadoCadeteActivo() throws DataAccessException{
        try{
            Connection con = BaseDeDatos.getInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cadetes where activo=true");
            int tam=0;
            while(rs.next())
                tam++;
            Object[][] lista = new Object[tam][4];
            int i=0;
            rs.close();
            rs = st.executeQuery("SELECT * FROM cadetes where activo=true");
            while(rs.next())
            {
                lista[i][0] = rs.getInt("cod_cadete");
                lista[i][1] = rs.getString("apellido_cadete").trim();
                lista[i][2] = rs.getString("nombre_cadete").trim();
                lista[i][3]="Cadete";
                i++;
            }
            rs.close();
            st.close();
            return lista;            
        }catch (Exception ex){throw new DataAccessException("Error en UsuarioDAO.buscarCliente() "+ex);}
    }
    public Object[][] ordenCadete() throws DataAccessException{
        try{
            Connection con = BaseDeDatos.getInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cadetes where activo=true AND estado_cadete>0");
            int tam=0;
            while(rs.next())
                tam++;
            Object[][] lista = new Object[tam][3];
            int i=0;
            rs.close();
            rs = st.executeQuery("SELECT * FROM cadetes where activo=true AND estado_cadete>0");
            while(rs.next())
            {
                lista[i][0] = rs.getInt("cod_cadete");
                lista[i][1] = rs.getString("apellido_cadete").trim();
                lista[i][2] = rs.getString("nombre_cadete").trim();
                i++;
            }
            rs.close();
            st.close();
            return lista;            
        }catch (Exception ex){throw new DataAccessException("Error en UsuarioDAO.buscarCliente() "+ex);}
    }
    public void actualizarOrden (int cod, int orden) throws DataAccessException{
    
        try{
            Connection con = BaseDeDatos.getInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE cadetes SET estado_cadete = ?"+
                    "WHERE cod_cadete = "+cod);

            ps.setInt(1, orden);
            ps.execute();
        }catch(Exception ex){throw new DataAccessException("Error en CadeteDAO.actualizar() "+ex);}
        
    }
    public int count() throws DataAccessException{
        try{
            Connection con = BaseDeDatos.getInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cadetes where activo=true AND estado_cadete>0");
            int tam=0;
            while(rs.next())
                tam++;
            rs.close();
            st.close();
            return tam;            
        }catch (Exception ex){throw new DataAccessException("Error en UsuarioDAO.buscarCliente() "+ex);}
    }
    public void enviarCadete (int cod) throws DataAccessException{
    
        try{
            Connection con = BaseDeDatos.getInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE cadetes SET estado_cadete = -1"+
                    "WHERE cod_cadete = "+cod);
            ps.execute();
            ps = con.prepareStatement("UPDATE cadetes SET estado_cadete = estado_cadete -1"+
                    "WHERE estado_cadete > 0");
            ps.execute();
            
        }catch(Exception ex){throw new DataAccessException("Error en CadeteDAO.actualizar() "+ex);}
        
    }
    public void agregarALaLista (int cod) throws DataAccessException{
    
        try{
            int i = count()+1;
            Connection con = BaseDeDatos.getInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE cadetes SET estado_cadete = "+i+
                    " WHERE cod_cadete = "+cod);
            ps.execute();
            
        }catch(Exception ex){throw new DataAccessException("Error en CadeteDAO.actualizar() "+ex);} 
    }
    public Cadete disponible() throws DataAccessException{
        try{
            Cadete cadete = new Cadete();
            Connection con = BaseDeDatos.getInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cadetes where estado_cadete = 1");
            while(rs.next()){
                cadete.setNombre(rs.getString("nombre_cadete"));
                cadete.setApellido(rs.getString("apellido_cadete"));
                cadete.setEstado(rs.getInt("estado_cadete"));
            }
            
            rs.close();
            st.close();
            return cadete;            
        }catch (Exception ex){throw new DataAccessException("Error en UsuarioDAO.buscarCliente() "+ex);}
    }
}
    
