package common_msg;

public class DeleteMessage extends AbstractMessage {
    private String filename;

    public DeleteMessage(String filename) {
        this.filename = filename;
    }

    public String getFilename(){
        return filename;
    }

}
