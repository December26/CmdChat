package client.console;

import io.netty.channel.Channel;
import protocol.request.MessageRequestPacket;

import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.nextLine();
        System.out.println("发送内容");
        String message = scanner.nextLine();
        while(!message.equals("switch")){
            System.out.println("To " + toUserId + ": " + message);
            channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
            message = scanner.nextLine();
        }

    }
}
