import java.util.Scanner;

public class teste {

    public static void main(String[] args) {

        String nome;
        double salariobruto, salarioliquido, imposto, irpf, inss, bonus, desconto, valorSalarioHora;
        int horasPorMes;

        Scanner leia = new Scanner(System.in);

        System.out.println("* FOLHA DE PAGAMENTO *");
        System.out.print("Nome do colaborador......: ");
        nome = leia.nextLine();
        System.out.print("Valor do Salario Bruto...: ");
        salariobruto = leia.nextDouble();
        System.out.println("Horas trabalhadas no mês.: ");
        horasPorMes = leia.nextShort();

        if (horasPorMes > 160) {
            salarioliquido = salariobruto;
        }

        irpf = 0;
        if (salariobruto <= 2259.20) {
            irpf = 0;
        } else if (salariobruto <= 2826.65) {
            irpf = (salariobruto * 0.075) - 169.44;
        } else if (salariobruto <= 3751.05) {
            irpf = (salariobruto * 0.15) - 381.44;
        } else if (salariobruto <= 4664.68) {
            irpf = (salariobruto * 0.225) - 662.77;
        } else {
            irpf = (salariobruto * 0.275) - 896;
        }

        double faixa1 = 1412, faixa2 = 2666.68, faixa3 = 4000.03, faixa4 = 7786.02,
                aliquota1 = 0.075, aliquota2 = 0.09, aliquota3 = 0.12, aliquota4 = 0.14;

        if (salariobruto <= faixa1) {
            inss = salariobruto * aliquota1;
        } else if (salariobruto <= faixa2) {
            inss = faixa1 * aliquota1 +
                    (salariobruto - faixa1) * aliquota2;
        } else if (salariobruto <= faixa3) {
            inss = faixa1 * aliquota1 +
                    (faixa2 - faixa1) * aliquota2 +
                    (salariobruto - faixa2) * aliquota3;
        } else if (salariobruto <= faixa4) {
            inss = faixa1 * aliquota1 +
                    (faixa2 - faixa1) * aliquota2 +
                    (faixa3 - faixa2) * aliquota3 +
                    (salariobruto - faixa3) * aliquota4;
        } else {
            inss = faixa1 * aliquota1 +
                    (faixa2 - faixa1) * aliquota2 +
                    (faixa3 - faixa2) * aliquota3 +
                    (faixa4 - faixa3) * aliquota4;
        }
        salarioliquido = salariobruto - inss - irpf + bonus - desconto;

        System.out.println("* CALCULO DA FOLHA DE PAGAMENTO *");
        System.out.println("Colaborador...........: " + nome);
        System.out.println("Valor do Salario Bruto...: " + salariobruto);
        System.out.println("IRPF retido...........: " + irpf);
        System.out.println("INSS retido...........: " + inss);
        System.out.println("Salario Liquido..... : " + salarioliquido);
        System.out.println("* CALCULO DA FOLHA DE PAGAMENTO *");

        leia.close();

    }
}