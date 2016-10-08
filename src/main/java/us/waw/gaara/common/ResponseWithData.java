package us.waw.gaara.common;

import org.springframework.ui.ModelMap;

/**
 * Created by lenn on 16/7/13.
 */
public class ResponseWithData extends Response {
    private ModelMap data;

    public ResponseWithData() {
        super();
        this.data = new ModelMap();
    }

    public ModelMap getData() {
        return data;
    }

    public void setData(ModelMap data) {
        this.data = data;
    }

    public void putData(String key, Object obj){
        this.data.put(key, obj);
    }
}
