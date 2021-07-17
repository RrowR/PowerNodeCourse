package day19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 使用默认的方式将String转换为Date
     * @return
     */
    public static Date StringConvertToDate(String strDate){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(strDate);
            return date;
        } catch (ParseException e) {
            // 使用try/catch将编译异常转换成运行时异常
            throw new RuntimeException(e);
        }
    }

    // 重载方法，指定想转换的格式类型
    public static Date StringConvertToDate(String strDate,String patten){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patten);
            Date date = simpleDateFormat.parse(strDate);
            return date;
        } catch (ParseException e) {
            // 使用try/catch将编译异常转换成运行时异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期类转换成字符串类
     * @param date
     * @param patten
     * @return
     */
    public static String DateConvertToString(Date date,String patten){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patten);
            String str = simpleDateFormat.format(date);
            return str;
        } catch (Exception e) {
            // 使用try/catch将编译异常转换成运行时异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期类转换成字符串类
     * @param date
     * @return
     */
    public static String DateConvertToString(Date date){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String str = simpleDateFormat.format(date);
            return str;
        } catch (Exception e) {
            // 使用try/catch将编译异常转换成运行时异常
            throw new RuntimeException(e);
        }
    }
}
