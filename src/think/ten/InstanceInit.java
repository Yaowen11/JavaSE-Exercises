package think.ten;

import java.util.Random;

/**
 * @author z
 * @date 2020/5/27 11:36
 */
public class InstanceInit {
    private Random random = new Random();
    private String initString;
    private Integer instanceInteger;
    {
        instanceInteger = random.nextInt();
        System.out.println("exec instance code" + this);
    }

    InstanceInit (String initString) {
        this.initString = initString;
    }

    public String getInitString() {
        return initString;
    }

    public Integer getInstanceInteger() {
        return instanceInteger;
    }

    public static void main(String[] args) {
        InstanceInit instanceInit = new InstanceInit("init 1");
        InstanceInit instanceInit1 = new InstanceInit("init 2");
        System.out.println(instanceInit.getInitString());
        System.out.println(instanceInit1.getInitString());
        System.out.println(instanceInit.getInstanceInteger());
        System.out.println(instanceInit1.getInstanceInteger());
    }
}
