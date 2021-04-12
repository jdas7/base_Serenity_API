package utils;

import com.google.gson.JsonObject;

public final class DataUserInstance {


    private static DataUserInstance INSTANCE;
    private JsonObject data;

    private DataUserInstance() {
    }

    public static DataUserInstance getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataUserInstance();
        }
        return INSTANCE;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }
}
