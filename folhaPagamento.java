import java.util.Scanner;

public class folhaPagamento {
    public static void main(String[] args) {
        String nome;
        Double salarioBruto, salarioHora, salarioLiquido, imposto, inss, bonus, irpf, desconto;
        int horasTrabalhadas, totalHoraMes;

        Scanner lerTeclado = new Scanner(System.in);

        System.out.println("Nome do colaborador: ");
        nome = lerTeclado.nextLine();

        System.out.println("Valor do Salario Bruto:  ");
        salarioBruto = lerTeclado.nextDouble();

        System.out.println("Horas trabalhadas no mês:  ");
        horasTrabalhadas = lerTeclado.nextShort();

        salarioHora = salarioBruto / horasTrabalhadas;
        totalHoraMes = 160;

        if (totalHoraMes > 160) {
            salarioLiquido = salarioBruto;
        }

        irpf = (double) 0;
        if (salarioBruto <= 2259.20) {
            irpf = (double) 0;
        } else if (salarioBruto <= 2826.65) {
            irpf = (salarioBruto * 0.075) - 169.44;
        } else if (salarioBruto <= 3751.05) {
            irpf = (salarioBruto * 0.15) - 381.44;
        } else if (salarioBruto <= 4664.68) {
            irpf = (salarioBruto * 0.225) - 662.77;
        } else {
            irpf = (salarioBruto * 0.275) - 896;
        }

        double faixa1 = 1412, faixa2 = 2666.68, faixa3 = 4000.03, faixa4 = 7786.02,
                aliquota1 = 0.075, aliquota2 = 0.09, aliquota3 = 0.12, aliquota4 = 0.14;

        if (salarioBruto <= faixa1) {
            inss = salarioBruto * aliquota1;
        } else if (salarioBruto <= faixa2) {
            inss = faixa1 * aliquota1 +
                    (salarioBruto - faixa1) * aliquota2;
        } else if (salarioBruto <= faixa3) {
            inss = faixa1 * aliquota1 +
                    (faixa2 - faixa1) * aliquota2 +
                    (salarioBruto - faixa2) * aliquota3;
        } else if (salarioBruto <= faixa4) {
            inss = faixa1 * aliquota1 +
                    (faixa2 - faixa1) * aliquota2 +
                    (faixa3 - faixa2) * aliquota3 +
                    (salarioBruto - faixa3) * aliquota4;
        } else {
            inss = faixa1 * aliquota1 +
                    (faixa2 - faixa1) * aliquota2 +
                    (faixa3 - faixa2) * aliquota3 +
                    (faixa4 - faixa3) * aliquota4;
        }

        bonus = (salarioBruto / 160) * (horasTrabalhadas - 160);
        salarioLiquido = salarioBruto - inss - irpf + bonus;

        System.out.println("* CALCULO DA FOLHA DE PAGAMENTO *");
        System.out.println("Colaborador...........: " + nome);
        System.out.println("Valor do Salario Bruto...: " + salarioBruto);
        System.out.println("IRPF retido...........: " + irpf);
        System.out.println("INSS retido...........: " + inss);
        System.out.println("Horas extra a receber.: " + bonus);
        System.out.println("Salario Liquido..... : " + salarioLiquido);
        System.out.println("* CALCULO DA FOLHA DE PAGAMENTO *");
        lerTeclado.close();
    }

}
