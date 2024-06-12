package basic;

import java.util.Scanner;


public class GestaoFrota {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args ) {
		int opcao;
		do {
		System.out.println("############### DIMENSIONAMENTO DE FROTA ###############");
		System.out.println("");
		System.out.println("1 - Fazer novo calculo.");
		System.out.println("9 - sair.");
		opcao = sc.nextInt();
		if(opcao == 1) {
		System.out.println("");
		System.out.println("Digite o peso do veiculo:");
		double peso = pesoVeiculo();
		double resUtil = cargaUtil(peso);
		double resTotal = viagensMes (resUtil);
		double resTempo = tempoTotalViagem ();
		double tempoOp = tempoDiario();
		CalculoFrota(tempoOp, resTempo, resTotal);	
		}
		} while (opcao != 9);
		}		
	static double pesoVeiculo() {	
		System.out.print("Chassi: ");
		double chassi = sc.nextDouble();
		System.out.print("Semi-Reboque: ");
		double reboque = sc.nextDouble();
		System.out.print("Outros Equipamentos: ");
		double outrosEquip = sc.nextDouble();
		double peso = (chassi + reboque + outrosEquip);
		System.out.println("Peso total do veiculo: "+peso);
		System.out.println("");
		return peso;
		}	
	static double cargaUtil (double peso) {
		System.out.print("Peso Bruto Total (PBT): ");
		double pbt = sc.nextDouble();
		double resUtil = (pbt - peso);
		System.out.println("Carga util do veiculo: "+resUtil);
		System.out.println("");
		return resUtil;	
		}
	static double viagensMes (double resUtil) {
		System.out.print("Carga total do mes: ");
		double cargaTotal = sc.nextDouble();
		double resTotal = (cargaTotal / resUtil);
		System.out.println("Numero de viagens : "+resTotal+" Viagens/mes");
		System.out.println("");
		return resTotal;
		}
	static double tempoTotalViagem ()  {
		System.out.print("Distancia na ida (km): ");
		double kmIda = sc.nextDouble();
		System.out.print("Distancia na volta (km): ");
		double kmVolta = sc.nextDouble();
		System.out.print("Velocidade operacional na ida (km/h): ");
		double velocidadeIda = sc.nextDouble();
		System.out.print("Velocidade operacional na volta (km/h): ");
		double velocidadeVolta = sc.nextDouble();
		System.out.print("Tempo de carga e descarga (min): ");
		double tempoDescarga = sc.nextDouble();
		double resIda = ((kmIda/velocidadeIda)*60 );
		double resVolta = ((kmVolta/velocidadeVolta)*60 );
		double resTempo = (resIda + resVolta + tempoDescarga);
		System.out.println("Tempo total da viagem: "+resTempo+" min.");
		System.out.println("");
		return resTempo;
		}
	static double tempoDiario () {
		System.out.print("Turnos diarios: ");
		double dia = sc.nextDouble();
		System.out.print("Jornada Util (em horas): ");
		double hora = sc.nextDouble();
		double tempoOp = (dia * hora * 60);
		System.out.println("Tempo Diario de Operacao: "+tempoOp +" min./dia");
		return tempoOp;
		}	
	static void CalculoFrota (double tempOp, double resTempo, double resTotal) {
		double viagemVeiculoDia = ( tempOp / resTempo);
		System.out.print("Numeros de dias Uteis: ");
		double numDiasUteis = sc.nextDouble();
		System.out.print("Paradas para manutenção: ");
		double numManutencao = sc.nextDouble();
		double diasUteis = (numDiasUteis - numManutencao);
		System.out.println("Dias uteis trabalhados: "+diasUteis);
		double numViagemVeiculo = (viagemVeiculoDia * diasUteis);
		double frotaNecessaria = (resTotal / numViagemVeiculo);
		double frotaArredondada = Math.ceil(frotaNecessaria);
		System.out.println("Frota Necessaria " +frotaNecessaria+ " Ou seja: " +frotaArredondada+" Veiculos");
		System.out.println("");
		System.out.println("########################################################");
	}
}