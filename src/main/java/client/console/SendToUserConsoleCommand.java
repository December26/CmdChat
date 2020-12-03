package client.console;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import protocol.request.MessageRequestPacket;

import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.nextLine();
        System.out.println("发送内容");
        String message = scanner.nextLine();

        while(message.equals("\n")) message = scanner.nextLine();//防止直接按回车发送空内容

        while(!message.equals("swi")){
            final String msg = message;
            channel.writeAndFlush(new MessageRequestPacket(toUserId, message)).addListener(future -> {
                if(future.isSuccess()) {
                    System.out.println("To " + toUserId + ": " + msg);
                } else {
                    System.out.println("给" + toUserId + "的消息发送失败");
                }
            });
            message = scanner.nextLine();
        }

    }
}
