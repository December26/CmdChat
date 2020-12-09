package protocol.request;

import lombok.Data;
import protocol.Packet;

import static protocol.command.Command.LIST_USERS_REQUEST;

@Data
public class ListUsersRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LIST_USERS_REQUEST;
    }
}
