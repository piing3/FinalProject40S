package utillity;

import java.io.Serializable;

/**
 * Project:
 * Author: Davin
 * Date: 19-May-2016
 * Teacher: Mr. Wachs 
 */
public class DataPacket <T> implements Serializable{
    private T data;

    public DataPacket(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
