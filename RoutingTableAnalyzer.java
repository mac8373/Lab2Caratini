/**
 * Project: Solo Lab2 Assignment Networking
 * Purpose Details: Retrieves and prints routing table details.
 * Course: IST 242
 * Author: Maximo Caratini
 * Date Developed: 2/4/24
 * Last Date Changed: 2/4/24
 * Rev: 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoutingTableAnalyzer {

    /**
     * Prints routing table for local computer
     */
    public void printRoutingTable() {
        try {
            // Execute "route print" command in Windows
            Process process = Runtime.getRuntime().exec("route print");

            //Read output of command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}