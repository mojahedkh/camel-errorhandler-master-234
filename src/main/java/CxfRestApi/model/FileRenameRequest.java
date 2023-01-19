
package CxfRestApi.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FileRenameRequest {

    @SerializedName("fileName")
    private String mFileName;

    public FileRenameRequest() {
    }

    public FileRenameRequest(String mFileName) {
        this.mFileName = mFileName;
    }

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String fileName) {
        mFileName = fileName;
    }

}
