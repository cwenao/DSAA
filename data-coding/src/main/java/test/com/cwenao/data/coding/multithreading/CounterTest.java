package test.com.cwenao.data.coding.multithreading;

import com.cwenao.data.coding.multithreading.Counter;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Counter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3月 9, 2021</pre>
 */
public class CounterTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(int n)
     */
    @Test
    public void testAdd() throws Exception {
        //TODO: Test goes here...
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread thread = new Thread(()->{
            counter1.add(10);
        });
        thread.start();

        Thread thread2 = new Thread(()->{
            counter1.dec(2);
        });
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println(counter1.getCount());

    }

    /**
     * Method: dec(int n)
     */
    @Test
    public void testDec() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: getCount()
     */
    @Test
    public void testGetCount() throws Exception {
        //TODO: Test goes here...
    }
}
