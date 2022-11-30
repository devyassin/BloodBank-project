package Modules;

public class Delivery {

    String name;
    String password;
    String email;
    int Qte;
    String location;


    public Delivery(String name, String password, String email, String location,int Qte) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.Qte = Qte;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int qte) {
        Qte = qte;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
