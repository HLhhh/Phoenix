package bigdecimalutils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/**
 * bigDimalUtils的处理工具类
 *
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

/*RoundingMode.CEILING：取右边最近的整数

RoundingMode.DOWN：去掉小数部分取整，也就是正数取左边，负数取右边，相当于向原点靠近的方向取整

RoundingMode.FLOOR：取左边最近的正数

RoundingMode.HALF_DOWN:五舍六入，负数先取绝对值再五舍六入再负数

RoundingMode.HALF_UP:四舍五入，负数原理同上

RoundingMode.HALF_EVEN:这个比较绕，整数位若是奇数则四舍五入，若是偶数则五舍六入
*/

    /**
     * 四舍五入
     * @param bigDecimal
     * @param scale 保留小数点位数
     * @return
     */
    public BigDecimal scalehalfup(BigDecimal bigDecimal,int scale,RoundingMode roundingMode){
        return bigDecimal.setScale(scale, roundingMode);
    }

}

