package client.console;

import io.netty.channel.Channel;
import util.SessionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleCommandManager implements ConsoleCommand {
    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("sendToUser", new SendToUserConsoleCommand());
        consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
        consoleCommandMap.put("joinGroup", new JoinGroupConsoleCommand());
        consoleCommandMap.put("quitGroup", new QuitGroupConsoleCommand());
        consoleCommandMap.put("listGroupMembers", new ListGroupMembersConsoleCommand());
        consoleCommandMap.put("sendToGroup", new SendToGroupConsoleCommand());
        consoleCommandMap.put("listUsers", new ListUsersConsoleCommand());

        consoleCommandMap.put("u", new SendToUserConsoleCommand());
        //consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("c", new CreateGroupConsoleCommand());
        consoleCommandMap.put("j", new JoinGroupConsoleCommand());
        consoleCommandMap.put("q", new QuitGroupConsoleCommand());
        consoleCommandMap.put("listg", new ListGroupMembersConsoleCommand());
        consoleCommandMap.put("g", new SendToGroupConsoleCommand());
        consoleCommandMap.put("l", new ListUsersConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入指令");
        System.out.println("u:私聊  l:列表  g:群聊  c: 建群  j:加群  q:退群");
        //  获取第一个指令
        String command = scanner.nextLine();

        if (!SessionUtil.hasLogin(channel)) {
            return;
        }

//        if(command.equals("u")) command = "sendToUser";
//        else if(command.equals("g")) command = "sendToGroup";


        ConsoleCommand consoleCommand = consoleCommandMap.get(command);

        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channel);
        } else {
            System.err.println("无法识别[" + command + "]指令，请重新输入!");
        }
    }
}
