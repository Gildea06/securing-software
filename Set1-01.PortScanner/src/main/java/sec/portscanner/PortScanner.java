package sec.portscanner;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PortScanner {

    final static int MIN_PORT = 1024;
    final static int MAX_PORT = 49151;

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        System.out.println("Which address should I scan?");
        String address = reader.nextLine();
        System.out.println("Start at port?");
        int start = Integer.parseInt(reader.nextLine());
        System.out.println("End at port?");
        int end = Integer.parseInt(reader.nextLine());

        Set<Integer> ports = getAccessiblePorts(address, start, end);
        //Set<Integer> ports = getAccessiblePorts("sec-mooc-1.cs.helsinki.fi", 20050, 20150);
        System.out.println("");

        if (ports.isEmpty()) {
            System.out.println("None found :(");
        } else {
            System.out.println("Found:");
            ports.stream().forEach(p -> System.out.println("\t" + p));
        }
    }

    public static Set<Integer> getAccessiblePorts(String address, int start, int end) throws IOException {
        Set<Integer> accessiblePorts = new TreeSet<>();
        start = Math.max(start, MIN_PORT);
        end = Math.min(end, MAX_PORT);
        for (int port = start; port <= end; port++) {
            try {
                Socket socket = new Socket(address, port);
                Scanner reader = new Scanner(socket.getInputStream());
                accessiblePorts.add(port);
            } catch (Exception e) {

            }

        }

        return accessiblePorts;
    }
}
