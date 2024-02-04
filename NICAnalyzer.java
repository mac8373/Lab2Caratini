/**
 * Project: Solo Lab2 Assignment Networking
 * Purpose Details: Analyzes NIC details
 * Course: IST 242
 * Author: Maximo Caratini
 * Date Developed: 2/4/24
 * Last Date Changed: 2/4/24
 * Rev: 1
 */

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
public class NICAnalyzer {

    /**
     * Shows details about NIC
     */
    public String retrieveNICDetails() {
        StringBuilder nicDetails = new StringBuilder();
        //
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                nicDetails.append("Interface Name: " + networkInterface.getDisplayName());

                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress != null) {
                    nicDetails.append("Interface Hardware Address: ").append(formatMACAddress(hardwareAddress)).append("\n");
                } else {
                    nicDetails.append("Interface Hardware Address: N/A\n");
                }

                Enumeration<java.net.InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    java.net.InetAddress inetAddress = inetAddresses.nextElement();
                    nicDetails.append("IP Address: ").append(inetAddress.getHostAddress()).append("\n");
                }

                nicDetails.append("\n");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return nicDetails.toString();
    }

    /**
     * Helper method to format MAC address.
     *
     * @param macAddress The MAC address bytes.
     * @return The formatted MAC address string.
     */
    private String formatMACAddress(byte[] macAddress) {
        StringBuilder formattedMAC = new StringBuilder();
        for (byte b : macAddress) {
            formattedMAC.append(String.format("%02X;", b));
        }
        if (formattedMAC.length() > 0) {
            formattedMAC.setLength(formattedMAC.length() - 1);
        }
        return formattedMAC.toString();
    }
}