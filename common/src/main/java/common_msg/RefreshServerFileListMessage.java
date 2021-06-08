package common_msg;

import java.util.ArrayList;

public class RefreshServerFileListMessage extends AbstractMessage {
    private ArrayList<String> serverFileList;

    public RefreshServerFileListMessage(ArrayList<String> serverFileList) {
        this.serverFileList = serverFileList;
    }

    public RefreshServerFileListMessage() {
    }

    public ArrayList<String> getServerFileList() {
        return serverFileList;
    }
}

