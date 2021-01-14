package Model;

public class UserModel {
    private int ID;
    private String name;

    public UserModel(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public UserModel() {
        this.ID = 0;
        this.name = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
