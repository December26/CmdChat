package client.console;

import io.netty.channel.Channel;
import protocol.request.ListUsersRequestPacket;

import java.util.Scanner;

public class ListUsersConsoleCommand implements ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListUsersRequestPacket listUsersRequestPacket = new ListUsersRequestPacket();
        channel.writeAndFlush(listUsersRequestPacket);
    }
}
