package fase02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFase02 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int euros5 = 5;
		int euros10 = 10;
		int euros20 = 20;
		int euros50 = 50;
		int euros100 = 100;
		int euros200 = 200;
		int euros500 = 500;
		
		int totalPrice;
		
		ArrayList<String> menuList = new ArrayList<String>();
		ArrayList<Integer> menuPrice = new ArrayList<Integer>();
		
		boolean stopper = true;
		//Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. Afegirem el nom del plat i després el preu. (1 punt)
		//el ejercicio pide hacerlo con un For, pero eso solo se puede hacer si conocemos la cantidad exacta de iteraciones que vamso a hacer
		while (stopper) {
			System.out.println("Introduzca un plato del menú o 'salir' para salir");
			String plato = reader.nextLine();
			if (plato.equals("salir")) {
				stopper = false;
			} else {
				menuList.add(plato);
				System.out.println("Introduzca precio del plato");
				int price = Integer.parseInt(reader.nextLine());
				menuPrice.add(price);
			}
		}
		
		//Un cop plens els dos arrays haurem de mostrar-los i preguntar que es vol per menjar, guardarem la informació en una List fent
		//servir un bucle while. (1 punt)
		//Haurem de preguntar si es vol seguir demanant menjar. Podeu fer servir el sistema (1:Si / 0:No), per tant haureu de crear un 
		//altre variable int per guardar la informació. (1 punt)
		printMenu(menuList, menuPrice);
		List<String> order = new ArrayList<String>();
		int keepOrdering = 1;
		
		while(keepOrdering == 1) {
			System.out.println("diga que plato quiere pedir de la lista");
			String orderPlate = reader.nextLine();
			order.add(orderPlate);
			System.out.println("Desea pedir otro plato? (1:Sí / 0:No)");
			keepOrdering = Integer.parseInt(reader.nextLine());
		}
		
	}
	
	public static void printMenu(ArrayList<String> menu, ArrayList<Integer> price) {
		for (int i = 0; i < menu.size(); i++) {
			System.out.println(menu.get(i) + "  " + price.get(i) + "€");
		}
	}

}
