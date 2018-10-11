package frode.jinx.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: frode
 * @Date: 2018/10/11 14:36
 * @Description:
 */
public class DataMap extends HashMap<String,Object> implements Serializable {

    private static final long serialVersionUID = -5167424701531864219L;

    public DataMap() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public static DataMap error() {
        return error(1, "操作失败");
    }

    public static DataMap error(String msg) {
        return error(500, msg);
    }

    public static DataMap error(int code, String msg) {
        DataMap r = new DataMap();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static DataMap ok(String msg) {
        DataMap r = new DataMap();
        r.put("msg", msg);
        return r;
    }

    public static DataMap ok(Map<String, Object> map) {
        DataMap r = new DataMap();
        r.putAll(map);
        return r;
    }

    public static DataMap ok() {
        return new DataMap();
    }

    @Override
    public DataMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
