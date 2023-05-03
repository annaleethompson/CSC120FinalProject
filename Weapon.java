
public class Weapon {
    String name;
    int x_pos;
    int y_pos;

    public Weapon(String name, int x_pos, int y_pos) {
        this.name = name;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public void changeCoordinates(int x_pos, int y_pos) {
        this.x_pos = x_pos;
        this.y_pos=y_pos;
    }


}