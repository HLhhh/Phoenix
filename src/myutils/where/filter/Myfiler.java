package myutils.where.filter;

import java.util.List;
import java.util.Map;

/**
 * hl
 * 失败之作
 * 2019.7.20
 */
public class Myfiler {

    private String parm1;
    private String parm2;
    private Map<?,?> parmap;
    private List<Map<?,?>> listparmap;

    public Myfiler(String parm1, String parm2) {
        this.parm1 = parm1;
        this.parm2 = parm2;
    }

    public Myfiler(String parm1, String parm2,Map map) {
        this.parm1 = parm1;
        this.parm2 = parm2;
        this.parmap=map;
    }

    public Myfiler(String parm1, String parm2,Map map,List<Map<?,?>> listparmap) {
        this.parm1 = parm1;
        this.parm2 = parm2;
        this.parmap=map;
        this.listparmap=listparmap;
    }
    /**
     * 自定义过滤条件
     * 出与map相同
     * @param map
     * @return
     */
    public Boolean myfilter(Map<?,?> map){
       if (ifnull(map)){
           return map.get(parm1).equals(parm2);
       }
       return false;
    }

    /**
     * 自定义过滤条件
     * 过滤key不为p1
     * 过滤map不为p2
     * @param map
     * @return
     */
    public Boolean myfilterky(Map<?,?> map){
        if (ifnull(map)){
            return map.containsKey(parm1)&&map.containsKey(parm2);
        }
        return false;
    }


    /**
     * 自定义过滤条件
     * 以map中的ky为过滤点
     * 不需要ky
     * @param map
     * @return 相同true 不同fales
     */
    public Boolean myfilterkylist(Map<?,?> map){
        for ( Map<?,?> mp: listparmap) {
            if (!compareMap(mp,map)){
                return false;
            }
        }
        return true;
    }



    /**
     * 自定义过滤条件
     * 遍历list以map中的ky为过滤点
     * 不需要ky
     * @param map
     * @return
     */
    public Boolean myfilterkys(Map<?,?> map){
        return compareMap(parmap,map);
    }


    /**
     * 比较两个map的是否相同
     * @param m1
     * @param m2
     * @return 不同true  相同false
     */
    private Boolean compareMap(Map<?,?> m1,Map<?,?> m2){
        for (Map.Entry<?, ?> pm : m1.entrySet()) {
            for (Map.Entry<?, ?> m : m2.entrySet()) {
                if (!m.getKey().equals(pm.getKey())&&!m.getValue().equals(pm.getValue())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 空值的判断
     * @param map
     * @return
     */
    private  Boolean ifnull(Map<?,?> map){
        if (parm2==null&&parm1==null) return false;
        if (map.get(parm1)==null||map.get(parm2)==null) return false;
        return true;
    }


}
