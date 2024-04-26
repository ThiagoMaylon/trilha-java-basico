import java.util.Scanner;
public class ContaTerminal {
    public static void main(String[] args){
        int numero;
        String agencia;
        String nome;
        float saldo;

        Scanner scan = new Scanner(System.in);
        System.out.print("Por favor, digite o número da Agência !\n>> ");
        agencia = scan.nextLine();
        System.out.print("Por favor, digite o número da Conta!\n>> ");
        numero = scan.nextInt();
        scan.nextLine();
        System.out.print("Por favor, digite o seu Nome !\n>> ");
        nome = scan.nextLine();
        System.out.print("Por favor, digite o Saldo !\n>> ");
        saldo = scan.nextFloat();
        scan.close();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %,.2f já está disponível para saque", nome, agencia, numero, saldo);
    }
}
