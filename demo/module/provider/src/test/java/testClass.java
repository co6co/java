import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/2/23 10:21
 * @Description:
 **/
@Slf4j
public class testClass {
    @Test
    public void testSysProperty(){
        log.info("System.getProperty(\"user.dir\"):{}",System.getProperty("user.dir"));
        log.info("System.getProperty(\"app.home\"):{}",System.getProperty("app.home"));
        log.info("System.getProperty(\"user.home\"):{}",System.getProperty("user.home"));
    }
}
