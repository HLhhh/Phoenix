package bigdecimalutils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * bigDimalUtils的处理工具类
 */
public class BigDecimalUtils {
    /**
     * 默认DEF_DIV_SCALE
     */
    private static final int DEF_DIV_SCALE = 10;
    /**
     * 加法
     * @return
     */
    public static BigDecimal summation(List<BigDecimal> bigDecimals){
        /**
         * 初始化bignum
         */
        BigDecimal bignum=new BigDecimal(BigInteger.ZERO);
        for (int i = 0; i <bigDecimals.size() ; i++) {
            bignum=bignum.add(bigDecimals.get(i));
        }
        return bignum;
    }

    /**
     * 减法
     * @return
     */
    public static BigDecimal subtract(List<BigDecimal> bigDecimals){
        /**
         * 判断list是否为空
         * 不为空则取出减数
         */
        if (bigDecimals.size()<=0){
            return new BigDecimal(BigInteger.ZERO);
        }
        BigDecimal  bignum=bigDecimals.get(0);
        for (int i = 1; i <bigDecimals.size() ; i++) {
            bignum=bignum.subtract(bigDecimals.get(i));
        }
        return bignum;
    }


    /**
     * 乘法
     * @return
     */
    public static BigDecimal multiply(List<BigDecimal> bigDecimals){
        BigDecimal bignum=new BigDecimal(BigInteger.ZERO);
        for (int i = 0; i <bigDecimals.size() ; i++) {
            bignum=bignum.multiply(bigDecimals.get(i));
        }
        return bignum;
    }



    /**
     * 除法
     * 默认四舍五入
     * 默认保留十位
     * @return 两个参数的商
     */
    public BigDecimal divide(List<BigDecimal> bigDecimals){
        return divide(bigDecimals,DEF_DIV_SCALE);
    }


    /**
     * 除法
     * 默认四舍五入
     * @scale 表示表示需要精确到小数点以后几位
     * @return 两个参数的商
     */
    public BigDecimal divide(List<BigDecimal> bigDecimals,int scale){
        if (bigDecimals.size()<=0){
            return new BigDecimal(BigInteger.ZERO);
        }
        /**
         * 拿到除数
         */
        BigDecimal  bignum=bigDecimals.get(0);
        for (int i = 1; i <bigDecimals.size() ; i++) {
             bignum = bignum.divide(bignum, scale, BigDecimal.ROUND_HALF_UP);
        }
        return bignum;
    }

}

