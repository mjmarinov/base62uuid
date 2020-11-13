package xor.base62uuid;

import java.util.UUID;

import io.seruco.encoding.base62.Base62;

public class Base62UUID {
    public static void main(String... args) {
        Base62 base62 = Base62.createInstance();
        UUID uuid;

        if (args.length == 2) {
            switch (args[0]) {
                case "-u": 
                    uuid = UUID.fromString(args[1]);
                    System.out.println("Provided UUID  : " + uuid.toString());
                    System.out.println("Base62 encoded : " + new String(base62.encode(Base62UUID.UUIDToByteArray(uuid))));
                    break;
                case "-b":
                    System.out.println("Provided Base62 : " + args[1]);
                    uuid = Base62UUID.byteArrayToUUID(base62.decode(args[1].getBytes()));
                    System.out.println("Decoded UUID    : " + uuid.toString());
                    break;
                default:
                    System.out.println("Unknown argument '" + args[0] + "'!");
                    Base62UUID.showUsage();
            }
        } else if (args.length == 0) {
            uuid = UUID.randomUUID();
            System.out.println("Generated UUID : " + uuid.toString());
            System.out.println("Base62 encoded : " + new String(base62.encode(Base62UUID.UUIDToByteArray(uuid))));
        } else {
            System.out.println("Wrong number of arguments!");
            Base62UUID.showUsage();
        }
    }

    private static void showUsage() {
        System.out.println("\nUsage: ");
        System.out.println("[no arguments]");
        System.out.println("\t Generates a random UUID v4 and encodes it in Base62");
        System.out.println("-u uuid ");
        System.out.println("\t Encodes the provided \"uuid\" in Base62");
        System.out.println("-b base62 ");
        System.out.println("\t Decodes the provided \"base62\" into a UUID");
    }

    private static byte[] UUIDToByteArray(UUID uuid) {
        byte[] result = new byte[16];
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();

        for (int i = 7; i >= 0; i--) {
            result[i] = (byte) (msb & 0xFF);
            msb >>= 8;
            result[i+8] = (byte) (lsb & 0xFF);
            lsb >>= 8;
        }

        return result;
    }

    private static UUID byteArrayToUUID(byte[] bytes) {
        long msb = 0, lsb = 0;

        for (int i = 0; i <= 7; i++) {
            msb = (msb << 8) | (bytes[i] & 0xFF);
            lsb = (lsb << 8) | (bytes[i+8] & 0xFF);
        }

        return new UUID(msb, lsb);       
    }
}