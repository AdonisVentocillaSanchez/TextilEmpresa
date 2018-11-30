package Bean;

public class ConexionBean extends UsuarioBean {
       
    public static void Conexion(UsuarioBean admin) {
       ConexionBean.server = admin.getServer();
       ConexionBean.port = admin.getPort();
       ConexionBean.sid = admin.getSid();
       ConexionBean.user = admin.getUser();
       ConexionBean.password = admin.getPassword();
    }

    @Override
    public String getServer() {
        return server;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String getSid() {
        return sid;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }
    
}
