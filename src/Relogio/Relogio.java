package Relogio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Relogio implements Runnable {
    private String prefixo;
    private long delay;
    private Date datasLembretes;
    private String mensagensLembretes;

    public Relogio(String prefixo, long delay) {
        this.prefixo = prefixo;
        this.delay = delay;
    }

    public void run() {
        DateFormat fmt = new SimpleDateFormat("\"yyyy.MM.dd G 'at' HH:mm:ss z\"");

        while (true) {
            // exibir data e hora atuais
            Date dataAtual = new Date();
            if (Objects.nonNull(this.datasLembretes) && dataAtual.after(this.datasLembretes)){
                System.out.println(this.mensagensLembretes);
                this.datasLembretes = null;
                this.mensagensLembretes = null;
            }
            System.out.println(prefixo + " - " + fmt.format(dataAtual));
            try {
                Thread.sleep(delay); // coloco o thread para dormir
            } catch (InterruptedException ex) {
                // ignoro essa exceção - ela só serve para acordar o thread
            }
        }
    }

    public void adicionarLembrete(Date data, String mensagem){
        this.datasLembretes = data;
        this.mensagensLembretes = mensagem;
    }
    public static void main(String[] args) {
        Relogio relogio = new Relogio("R1", 1000);
        Date dataLembrente = new Date();
        dataLembrente.setSeconds(dataLembrente.getSeconds() + 15);
        relogio.adicionarLembrete(dataLembrente,"Chegou");

        Thread relogio1 = new Thread(relogio);

        relogio1.start();
    }
}
