package Bean;

public class UsuarioBean {
    
    public static String server;
    public static int port;
    public static String sid;
    public static String user;
    public static String password;

    public UsuarioBean() {
    }

    public UsuarioBean(String server, int port, String sid, String user, String password) {
        UsuarioBean.server = server;
        UsuarioBean.port = port;
        UsuarioBean.sid = sid;
        UsuarioBean.user = user;
        UsuarioBean.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        UsuarioBean.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        UsuarioBean.port = port;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        UsuarioBean.sid = sid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        UsuarioBean.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        UsuarioBean.password = password;
    }
    
        
}
