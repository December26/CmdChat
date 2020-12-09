package server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.request.ListUsersRequestPacket;
import protocol.response.ListUsersResponsePacket;
import session.Session;
import util.SessionUtil;

import java.util.List;

@ChannelHandler.Sharable
public class ListUsersRequestHandler extends SimpleChannelInboundHandler<ListUsersRequestPacket> {
    public static final ListUsersRequestHandler INSTANCE = new ListUsersRequestHandler();

    private ListUsersRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListUsersRequestPacket requestPacket) throws Exception {
        ListUsersResponsePacket listUsersResponsePacket = new ListUsersResponsePacket();
        List<Session> lu = SessionUtil.getUsersSessions();
        listUsersResponsePacket.setSessionList(lu);
        ctx.writeAndFlush(listUsersResponsePacket);
    }
}
