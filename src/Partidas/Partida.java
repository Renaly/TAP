package Partidas;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nomeTimeA;
    private String nomeTimeB;
    private int golsTimeA;
    private int golsTimeB;

    public Partida() {
    }

    public Partida(String nomeTimeA, String nomeTimeB, int golsTimeA, int golsTimeB) {
        this.nomeTimeA = nomeTimeA;
        this.nomeTimeB = nomeTimeB;
        this.golsTimeA = golsTimeA;
        this.golsTimeB = golsTimeB;
    }

    public String getNomeTimeA() {
        return nomeTimeA;
    }

    public void setNomeTimeA(String nomeTimeA) {
        this.nomeTimeA = nomeTimeA;
    }

    public String getNomeTimeB() {
        return nomeTimeB;
    }

    public void setNomeTimeB(String nomeTimeB) {
        this.nomeTimeB = nomeTimeB;
    }

    public int getGolsTimeA() {
        return golsTimeA;
    }

    public void setGolsTimeA(int golsTimeA) {
        this.golsTimeA = golsTimeA;
    }

    public int getGolsTimeB() {
        return golsTimeB;
    }

    public void setGolsTimeB(int golsTimeB) {
        this.golsTimeB = golsTimeB;
    }

    public String toStringCSV(){
        return this.nomeTimeA + ";" + this.golsTimeA + ";" + this.nomeTimeB + ";" + this.golsTimeB + "\n";
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Partida> partidas = new ArrayList<>();
        Partida partida = new Partida("Time A", "Time B", 2,5);
        partidas.add(partida);
        RegistradorPartidas registradorPartidas = new RegistradorPartidas();
        registradorPartidas.gravarPartidas(partidas,"teste");
        registradorPartidas.lerPartidas("teste.txt").stream().forEach((partidaLida -> { System.out.println(partidaLida.toString());}));
        registradorPartidas.gravarPartidasCSV(partidas,"teste");
        registradorPartidas.lerPartidasCSV("teste.csv");
    }
}
