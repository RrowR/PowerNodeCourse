package ext.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author Rrow
 * @Date 2021/12/26 23:38
 *
 * jdk1.4就自带的Logger日志包，不过很少用，一般用log4j 或者 slf4j
 *
 */
public class LoggerDemo {

    // 第二种方式
    private static final Logger logger = Logger.getLogger("ext.Logger.LoggerDemo");

    public static void main(String[] args) {
        // 第一种方式
        // Logger logger = Logger.getGlobal();
        logger.setLevel(Level.SEVERE);
        logger.finest("finest");
        logger.finer("finer");
        logger.fine("fine");
        logger.config("config");

        // 这3个级别下的info会被打印出来
        logger.info("info");
        logger.warning("warning");
        logger.severe("severe");
    }
}
