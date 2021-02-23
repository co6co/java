import org.junit.Test;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/1/7 10:30
 * @Description:
 **/
public class StaticThreadInit {
    static
    {
        //创建匿名内部类来启动新线程
        Thread t = new Thread()
        {
            //启动新线程将website属性设置为www.leegang.org
            public void run()
            {
                System.out.println("进入run方法");
                System.out.println(website);
                website = "www.leegang.org";
                System.out.println(" 退出run方法");
            }
        };

        try{
            t.start();
             Thread.sleep(10);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {

        }

    }
    //定义一个静态field，设置其初始值为www.crazyit.org
    static   String website = "www.crazyit.org";
    @Test
    public void mainTest()
    {
        try{ System.out.println("main:"+ StaticThreadInit.website);
           // Thread.sleep(10*1000);
        }
         /* catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        finally {

        }

    }
}
