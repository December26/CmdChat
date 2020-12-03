package util;

import java.util.UUID;

public class IDUtil {
    public static int uid = 1;
    public static char gid = 'a';
    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
    public static String newId() {
        String id = new Integer(uid).toString();
        uid++;
        return id;
    }

    public static String newGrouoId() {
        String id = String.valueOf(gid);
        gid++;
        return id;
    }
}
