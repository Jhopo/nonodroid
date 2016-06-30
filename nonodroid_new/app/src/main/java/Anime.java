
public class Anime {

    private long id;
    private String name;
    private String status;
    private boolean selected;

    public Anime(){
        name = "";
        status = "";
    }

    public Anime(long id, String name, String status){
        this.id = id;
        this.name = name;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
