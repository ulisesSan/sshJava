package org.example;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import net.schmizz.sshj.SSHClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class Ssh {

    public static void sshConnector(String usuario, String servidor, String contrasena) throws Exception{
        JSch js = new JSch();
        Session s = js.getSession(usuario, servidor, 22);
        s.setPassword(contrasena);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        s.setConfig(config);
        s.connect();

        Channel c = s.openChannel("exec");
        ChannelExec ce = (ChannelExec) c;
        ce.setCommand("un comando cualquiera");
        ce.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(ce.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        ce.disconnect();
        s.disconnect();

        System.out.println("Exit status: " + ce.getExitStatus());
    }
}
