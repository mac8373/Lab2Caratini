/**
 * Project: Solo Lab2 Assignment Networking
 * Purpose Details: Scans ports on target hosts
 * Course: IST 242
 * Author: Maximo Caratini
 * Date Developed: 2/4/24
 * Last Date Changed: 2/4/24
 * Rev: 1
 */
import java.io.IOException;
import java.net.Socket;

/**
 *  Class for performing port scanning on target host.
 */
class PortScanner {

    /**
     *  Performs port scan on target host within port range.
     * @param targetHost The target host to scan.
     * @param minPort    The minimum port number to scan.
     * @param maxPort    The maximum port number to scan
     */
    public void performPortScan(String targetHost, int minPort, int maxPort) {
        System.out.println("Scanning ports on " + targetHost + "...");
        for (int port = minPort; port <= maxPort; port++) {
            try {
                Socket socket = new Socket(targetHost, port);
                socket.close();
            } catch (IOException e) {
            //Port is likely closed
            }
        }
        System.out.println("Port scanning finished.");
    }
}