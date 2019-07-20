package myutils.where;

import myutils.where.filter.Myfiler;
import myutils.where.parm.Parm;

import java.util.*;
import java.util.stream.Collectors;

public class FilterForFilter {
    private String key;
    private String Value;
    private Map map;
    private List<Map<?,?>> mapList;
    /**
     * 将数组list按照parm的参数标准，过滤
     * @param list
     * @param parm
     * @return
     */
    public List<Map<?,?>> where(Collection<Map<String, Object>> list, Parm parm){
        /**
         * 获取参数
         */
        key=parm.getParm1(); Value=parm.getParm2();
        /**
         * 创建过滤器
         */
        Myfiler myfiler=new Myfiler(key,Value);
        return list.stream().filter(myfiler::myfilter).collect(Collectors.toList()) ;
    }

    /**
     * 过滤list中map key不为目标参数1.并且V不是目标参数2
     * @param list
     * @param parm
     * @return
     */
    public List<Map<?,?>> whereEx(Collection<Map<String, Object>> list, Parm parm){
        /**
         * 获取参数
         */
        key=parm.getParm1(); Value=parm.getParm2();
        /**
         * 创建过滤器
         */
        Myfiler myfiler=new Myfiler(key,Value);
        return list.stream().filter(myfiler::myfilterky).collect(Collectors.toList()) ;
    }


    /**
     * 过滤list中map key不为目标参数1.并且V不是目标参数2
     * @param list
     * @param parm
     * @return
     */
    public List<Map<?,?>> whereExs(Collection<Map<String, Object>> list, Parm parm){
        /**
         * 获取参数
         */
        key=parm.getParm1(); Value=parm.getParm2(); map=parm.getMap();
        /**
         * 创建过滤器
         */
        Myfiler myfiler=new Myfiler(key,Value,map);
        return list.stream().filter(myfiler::myfilterkys).collect(Collectors.toList()) ;
    }


    /**
     * 过滤list中map key不为目标参数1.并且V不是目标参数2
     * @param list
     * @param parm
     * @return
     */
    public List<Map<?,?>> whereExlist(Collection<Map<String, Object>> list, Parm parm){
        /**
         * 获取参数
         */
        key=parm.getParm1(); Value=parm.getParm2(); map=parm.getMap(); mapList=parm.getList();
        /**
         * 创建过滤器
         */
        Myfiler myfiler=new Myfiler(key,Value,map,mapList);
        return list.stream().filter(myfiler::myfilterkylist).collect(Collectors.toList()) ;
    }

}
