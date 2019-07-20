package myutils;

import myutils.where.FilterForFilter;
import myutils.where.parm.Parm;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        FilterForFilter filterForFilter=new FilterForFilter();
        Collection<Map<String, Object>> map = Map();
        Parm parm=new Parm();
        Map<String,String> map1=new HashMap();
        map1.put("1","1");
        Map<String,String> map2=new HashMap();
        map2.put("2","2");
        List<Map<?,?>> mapList=new LinkedList<>();
        mapList.add(map1); mapList.add(map2);
        parm.setParm1("2");  parm.setParm2("2");  parm.setMap(map1); parm.setList(mapList);
        List<Map<?, ?>> where = filterForFilter.whereExlist(map,parm);
        if (where.size()>0){
            where.stream().forEach(a->System.out.println(a));
        }
    }


    public static Collection<Map<String, Object>> Map() {
        Collection<Map<String,Object>> arrayList=new ArrayList<>();
        Map<String,Object> map1=new HashMap();
        Map<String,Object> map2=new HashMap();
        Map<String,Object> map3=new HashMap();
        map1.put("1","1");
        map2.put("2","2");
        map3.put("3","3");
        arrayList.add(map1);
        arrayList.add(map2);
        arrayList.add(map3);
        return arrayList;
    }
}
