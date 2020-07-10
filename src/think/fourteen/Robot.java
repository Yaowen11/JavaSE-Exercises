package think.fourteen;

import java.util.List;

/**
 * @author zyw
 * @date 2020/6/21 11:02
 */
public interface Robot {
    String name();
    String mode();
    List<Operation> operations();
    class Test {
        public static void test(Robot robot) {
            if (robot instanceof Null) {
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + robot.name());
            System.out.println("Robot model: " + robot.mode());
            for (Operation operation: robot.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
