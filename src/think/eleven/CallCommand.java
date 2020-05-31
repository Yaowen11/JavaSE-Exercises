package think.eleven;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author zyw
 * @date 2020/5/31 20:18
 */
public class CallCommand {
    static class Command {
        String command;
        Command(String command) { this.command = command; }
        private void operation() {
            System.out.println(command);
        }
    }
    static class StackCommand {

        Queue<Command> commands = new LinkedList<>();

        void insertCommand(Command command) {
            commands.offer(command);
        }

        public Queue<Command> getCommands() {
            return commands;
        }
    }
    public static void main(String[] args) {
        Command command = new Command("pwd");
        StackCommand stackCommand = new StackCommand();
        stackCommand.insertCommand(command);
        Queue<Command> commands = stackCommand.getCommands();
        while (!commands.isEmpty()) {
            commands.poll().operation();
        }
    }
}
