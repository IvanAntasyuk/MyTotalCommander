package common_msg;

public class DownloadMessage extends AbstractMessage {
    private String filename;

    public DownloadMessage(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}