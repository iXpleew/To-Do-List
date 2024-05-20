public class Task {
    public enum Status{
        TO_DO,
        DOING,
        DONE,
        ALL
    }
    private String name;
    private Status status;
    private int index;

    public Task(String name, Status status, int index){
        this.name = name;
        this.status = status;
        this.index = index;
    }

    public void Clear(){
        this.index = 0;
        this.name = null;
        this.status = null;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }
}
