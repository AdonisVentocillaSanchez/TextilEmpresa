package Bean;

public class UsuarioBean {
    
    private String server;
    private int port;
    private String sid;
    private String user;
    private String password;

    public UsuarioBean() {
    }

    public UsuarioBean(String server, int port, String sid, String user, String password) {
        this.server = server;
        this.port = port;
        this.sid = sid;
        this.user = user;
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
        
}
