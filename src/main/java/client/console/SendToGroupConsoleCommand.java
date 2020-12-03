package client.console;

import io.netty.channel.Channel;
import protocol.request.GroupMessageRequestPacket;
import protocol.request.MessageRequestPacket;

import java.util.Scanner;

public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个群组：");

        String toGroupId = scanner.nextLine();
        System.out.println("发送内容");
        String message = scanner.nextLine();

        while(message.equals("\n")) message = scanner.nextLine();//防止直接按回车发送空内容

        while(!message.equals("swi")){
            System.out.println("To " + toGroupId + ": " + message);
            channel.writeAndFlush(new GroupMessageRequestPacket(toGroupId, message));
            message = scanner.nextLine();
        }

    }
}
