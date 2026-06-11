package Game;

import itens.Arma;
import itens.Grimorio;
import itens.Item;
import personagens.Goblin;
import personagens.Guerreiro;
import personagens.Mago;
import personagens.Orc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;z
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        Map<String, String> itens = new HashMap<>();
        try (InputStream is = Main.class.getResourceAsStream("/br/inatel/rpg/config/itensConfig.txt")) {
            if (is == null) throw new IOException("Arquivo itensConfig.txt não encontrado!");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (!linha.isBlank() && linha.contains(":")) {
                        String[] linhaQuebrada = linha.split(":");
                        itens.put(linhaQuebrada[0].strip(), linhaQuebrada[1].strip());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar itensConfig.txt!");
            e.printStackTrace();
        }

        Map<String, Integer> armas = new HashMap<>();
        try (InputStream is = Main.class.getResourceAsStream("/br/inatel/rpg/config/armasConfig.txt")) {
            if (is == null) throw new IOException("Arquivo armasConfig.txt não encontrado!");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (!linha.isBlank() && linha.contains(":")) {
                        String[] linhaQuebrada = linha.split(":");
                        if (linhaQuebrada.length >= 2) {
                            int numero = Integer.parseInt(linhaQuebrada[1].strip());
                            armas.put(linhaQuebrada[0].strip(), numero);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar armasConfig.txt!");
            e.printStackTrace();
        }

        Map<String, Integer> feiticos = new HashMap<>();
        try (InputStream is = Main.class.getResourceAsStream("/br/inatel/rpg/config/feiticosConfig.txt")) {
            if (is == null) throw new IOException("Arquivo feiticosConfig.txt não encontrado!");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (!linha.isBlank() && linha.contains(":")) {
                        String[] linhaQuebrada = linha.split(":");
                        if (linhaQuebrada.length >= 2) {
                            int numero = Integer.parseInt(linhaQuebrada[1].strip());
                            feiticos.put(linhaQuebrada[0].strip(), numero);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar feiticosConfig.txt!");
            e.printStackTrace();
        }

        String chave;

        Item escudo = new Item("Escudo de Carvalho", itens.get("Escudo de Carvalho"));
        Item pocao = new Item("Poção de Vida", itens.get("Poção de Vida"));
        Item pocaof = new Item("Poção de Força", itens.get("Poção de Força"));
        Item anel = new Item("Anel da Mente", itens.get("Anel da Mente"));


        Arma espada = new Arma("Espada de Ferro", armas.get("Espada de Ferro"));
        Arma adaga = new Arma("Adaga de Bronze", armas.get("Adaga de Bronze"));
        Arma cajado = new Arma("Cajado do Aprendiz", armas.get("Cajado do Aprendiz"));
        Arma clava = new Arma("Clava de Madeira", armas.get("Clava de Madeira"));

        Grimorio grimorio = new Grimorio();
        grimorio.addFeitico("Seta de Mana", feiticos.get("Seta de Mana"));
        grimorio.addFeitico("Faísca Elétrica", feiticos.get("Faísca Elétrica"));
        grimorio.addFeitico("Chama Menor", feiticos.get("Chama Menor"));
        grimorio.addFeitico("Dardo de Gelo", feiticos.get("Dardo de Gelo"));

        Mago mago = new Mago("Merlin", 80, 2, cajado, grimorio, 30);
        Orc orc = new Orc("Throk", 110, 12, clava, 8);
        Guerreiro guerreiro = new Guerreiro(5, 100, espada, "Galahad");
        Goblin goblin = new Goblin("Gobby", 95, 5, adaga, 100);

        mago.addItem(anel);
        mago.addItem(pocao);
        guerreiro.addItem(escudo);
        guerreiro.addItem(pocao);
        guerreiro.addItem(pocaof);

        Arena arena1A = new Arena(mago, goblin);
        Arena arena1B = new Arena(goblin, mago);

        System.out.println("\n--- INICIANDO A BATALHA 1 ---");
        Thread t1 = arena1A.iniciarBatalha();
        Thread t2 = arena1B.iniciarBatalha();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("A espera pelas batalhas foi interrompida.");
        }
        System.out.println("\n--- BATALHA 1 TERMINOU! ---\n");

        System.out.println("\n--- INICIANDO A BATALHA 2 ---");
        Arena arena2A = new Arena(guerreiro, orc);
        Arena arena2B = new Arena(orc, guerreiro);

        Thread t3 = arena2A.iniciarBatalha();
        Thread t4 = arena2B.iniciarBatalha();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("A espera pela segunda batalha foi interrompida.");
        }

        System.out.println("\n--- TORNEIO FINALIZADO! ---");
    }
}