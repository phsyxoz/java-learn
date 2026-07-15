package inc.lopsys.idk.homework6.task6;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int START_PORT = 0;
    private static final int END_PORT = 49151;

    private static final Map<Integer, String> KNOWN_TCP_PORTS = new HashMap<>();
    private static final Map<Integer, String> KNOWN_UDP_PORTS = new HashMap<>();

    static {
        KNOWN_TCP_PORTS.put(135, "EPMAP");
        KNOWN_TCP_PORTS.put(139, "Служба сеансов NetBIOS");
        KNOWN_TCP_PORTS.put(445, "Microsoft-DS Active Directory");
        KNOWN_TCP_PORTS.put(843, "Adobe Flash");
        KNOWN_TCP_PORTS.put(5939, "Неизвестный/резерв");
        KNOWN_TCP_PORTS.put(6463, "Неизвестный/резерв");
        KNOWN_TCP_PORTS.put(6942, "Неизвестный/резерв");
        KNOWN_TCP_PORTS.put(17500, "Dropbox");
        KNOWN_TCP_PORTS.put(17600, "Dropbox");
        KNOWN_TCP_PORTS.put(27017, "MongoDB");

        KNOWN_UDP_PORTS.put(137, "Служба имен NetBIOS");
        KNOWN_UDP_PORTS.put(138, "Служба датаграмм NetBIOS");
        KNOWN_UDP_PORTS.put(1900, "Simple Service Discovery Protocol (SSDP)");
        KNOWN_UDP_PORTS.put(3702, "Динамическое обнаружение веб-служб");
        KNOWN_UDP_PORTS.put(5040, "Неизвестный/резерв");
        KNOWN_UDP_PORTS.put(5050, "Неизвестный/резерв");
        KNOWN_UDP_PORTS.put(5353, "Многоадресный DNS");
        KNOWN_UDP_PORTS.put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
        KNOWN_UDP_PORTS.put(42420, "Неизвестный/резерв");
    }

    public static void main(String[] args) {
        System.out.printf("%-10s %-10s %-40s%n", "Протокол", "Порт", "Сервис");
        System.out.println("------------------------------------------------------------");

        for (int port = START_PORT; port <= END_PORT; port++) {
            checkTcpPort(port);
            checkUdpPort(port);
        }
    }

    private static void checkTcpPort(int port) {
        String service = KNOWN_TCP_PORTS.get(port);
        if (service == null) {
            return;
        }

        String status;
        try (ServerSocket ss = new ServerSocket(port)) {
            status = "Свободен";
        } catch (Exception e) {
            status = "Занят";
        }

        System.out.printf("%-10s %-10d %-40s (%s)%n", "TCP", port, service, status);
    }

    private static void checkUdpPort(int port) {
        String service = KNOWN_UDP_PORTS.get(port);
        if (service == null) {
            return;
        }

        String status;
        try (DatagramSocket ds = new DatagramSocket(port)) {
            status = "Свободен";
        } catch (Exception e) {
            status = "Занят";
        }

        System.out.printf("%-10s %-10d %-40s (%s)%n", "UDP", port, service, status);
    }
}
