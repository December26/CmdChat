package protocol.response;

import lombok.Data;
import protocol.Packet;
import session.Session;

import java.util.List;

import static protocol.command.Command.LIST_USERS_RESPONSE;

@Data
public class ListUsersResponsePacket extends Packet {
    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return LIST_USERS_RESPONSE;
    }
}
