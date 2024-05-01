package canditadura;

import java.util.Random;
import java.util.ArrayList;

public class ProcessoSeletivo {
    static final double SALARIOSBASE = 2000.00;
    static final String[] CANDIDATOS = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "DANIELA", "JORGE"};
    static ArrayList<String> listaCandidatosSelecinados = new ArrayList<>();
    public static void main(String[] args){

        analisaCandidato(1900);
        selecaoCandidato();
        imprimiSelecionados();

        for(String candidato : listaCandidatosSelecinados){
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato){
        boolean atendeu = false;
        boolean continuaTentando = true;
        int tentativas = 1;
        do{
            atendeu = atenderLigacao();
            continuaTentando = !atendeu;
            if(continuaTentando){
                tentativas++;
            }
        }while(continuaTentando && tentativas < 3);

        if(atendeu){
            System.out.println("Conseguimos contato com "+ candidato+" na "+tentativas+" tentativa.");
        }else{
            System.out.println("Não conseguimos contato com "+ candidato+" com "+tentativas+" tentativas.");
        }
    }
    static boolean atenderLigacao(){
        Random random = new Random();
        return random.nextInt(3) == 1;
    }
    static void imprimiSelecionados(){
        for(int indice = 0; indice < listaCandidatosSelecinados.size(); indice++){
            System.out.printf("%d - %s \n", indice, listaCandidatosSelecinados.get(indice));
        }
    }
    static void selecaoCandidato(){
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        while(candidatosSelecionados < 5 && candidatoAtual < CANDIDATOS.length){
            String candidato = CANDIDATOS[candidatoAtual];
            double salarioPretendido = valorPretendido();
            if(SALARIOSBASE > salarioPretendido){
                System.out.println("O candidato "+ candidato+" foi selecioando para a vaga");
                listaCandidatosSelecinados.add(candidato);
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido() {
        Random random = new Random();
        return random.nextDouble(401) + 1800;
    }
    static void analisaCandidato(double salarioPretendido){
        if(salarioPretendido > SALARIOSBASE){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioPretendido == SALARIOSBASE){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }else{
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
