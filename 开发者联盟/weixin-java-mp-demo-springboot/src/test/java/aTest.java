import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/1/7 9:21
 * @Description:
 **/
public class aTest {
    class Apple<T extends Number>
    {
        T size;
        public Apple()
        {
        }
        public Apple(T size)
        {
            this.size = size;
        }
        public void setSize (T size)
        {
            this.size = size;
        }
        public T getSize()
        {
            return this.size;
        }

        public List<String> getApples()
        {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < 3 ; i++ )
            {
                list.add(new Apple<Integer>(10 * i).toString());
            }
            return list;
        }
    }
    public void info(Object obj , double count)               // ①
    {
        System.out.println("obj参数为：" + obj);
        System.out.println("count 参数为：" + count);
    }
    public void info(Object[] objs , double count)         //②
    {
        System.out.println("objs参数为：" + objs);
        System.out.println("count 参数为：" + count);
    }
    @Test
    public void mainTest(){
        String s = null;
        System.out.println("null 是否是String类的实例：" + (s instanceof String));
        info(null,5);

        ttt ni = null;
        ni.info();
    }


}
