package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.ListUsersResponsePacket;


public class ListUsersReponseHandler extends SimpleChannelInboundHandler<ListUsersResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListUsersResponsePacket responsePacket) throws Exception {
        System.out.println("当前在线的人：" + responsePacket.getSessionList());
    }
}
