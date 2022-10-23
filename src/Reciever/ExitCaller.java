package Reciever;

import Interfaces.Command;

public class ExitCaller implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
