package myutils.where.parm;

import java.util.List;
import java.util.Map;

public class Parm {
    private String parm1;
    private String parm2;
    private Map<String,String> map;
    private List<Map<?,?>> list;

    public List<Map<?, ?>> getList() {
        return list;
    }

    public void setList(List<Map<?, ?>> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getParm1() {
        return parm1;
    }

    public void setParm1(String parm1) {
        this.parm1 = parm1;
    }

    public String getParm2() {
        return parm2;
    }

    public void setParm2(String parm2) {
        this.parm2 = parm2;
    }
}
