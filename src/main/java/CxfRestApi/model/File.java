package CxfRestApi.model;

public class File {
    private Integer id;
    private String fileName;
    private String stuts;


    public File() {
    }

    public File(Integer id, String fileName, String stuts) {
        this.id = id;
        this.fileName = fileName;
        this.stuts = stuts;

    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getStuts() {
        return stuts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public void setStuts(String stuts) {
        this.stuts = stuts;
    }
}
