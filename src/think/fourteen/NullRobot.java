package think.fourteen;

import java.lang.reflect.Proxy;

public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[] { Null.class, Robot.class},
                new NullRobotProxyHandler(type)
        );
    }
    public static void main(String[] args) {
        Robot[] robots = {new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class)};
        for (Robot robot : robots) {
            Robot.Test.test(robot);
        }
    }
}
