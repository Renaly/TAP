package Partidas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RegistradorPartidas {

    public static final int TIME_A_NOME = 0;
    public static final int GOLS_A   = 1;
    public static final int TIME_B_NOME  = 2;
    public static final int GOLS_B  = 3;

    public void gravarPartidas(List<Partida> partidas, String arquivo) throws IOException {
        File file = new File(arquivo+".txt");
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(partidas);
        oos.flush();

        System.out.printf("\nPartida foi gravada com sucesso em "+ arquivo +".txt");

    }

    public List<Partida> lerPartidas(String arquivo) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(arquivo);

        ObjectInputStream objStream = new ObjectInputStream(fileStream);

        return (List<Partida>) objStream.readObject();

    }

    public void gravarPartidasCSV(List<Partida> partidas, String arquivo) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(arquivo + ".csv"));

        StringBuffer csvHeader = new StringBuffer("");
        StringBuffer csvData = new StringBuffer("");
        csvHeader.append("Time A;Gols A;Time B; Gols B\n");

        // write header
        pw.write(csvHeader.toString());

        partidas.stream().forEach(partida -> csvData.append(partida.toStringCSV()));
        pw.write(csvData.toString());
        pw.close();
        System.out.printf("\nPartida foi gravada com sucesso em "+ arquivo +".csv");
    }

    public List<Partida> lerPartidasCSV(String arquivo) throws IOException {
        ArrayList<Partida> partidas = new ArrayList<>();

        BufferedReader entrada = new BufferedReader(new FileReader(arquivo));

        String linha = null;
        boolean primeiraLinha = true;
        while ((linha = entrada.readLine()) != null) {
            if (primeiraLinha) {
                primeiraLinha = false;
                continue;
            }

            String[] valores = linha.split(";");

            Partida p = new Partida();
            p.setNomeTimeA(valores[TIME_A_NOME]);
            p.setGolsTimeA(Integer.parseInt(valores[GOLS_A]));
            p.setNomeTimeB(valores[TIME_B_NOME]);
            p.setGolsTimeB(Integer.parseInt(valores[GOLS_B]));

            partidas.add(p);
        }

        entrada.close();


        return partidas;
    }
}
