package Modules;

public class AdminInfo {

    static private int id;
    static private String name;

    public AdminInfo() {
    }

    public AdminInfo(int id, String name) {
        AdminInfo.id = id;
        AdminInfo.name = name;
    }

    public static void setId(int id) {
        AdminInfo.id = id;
    }

     public static void setName(String name) {
        AdminInfo.name = name;
    }

    public static int getId() {
        return id;
    }

    public static String getName() {
        return name;
    }
}
