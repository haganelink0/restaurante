package fase03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFase03 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int euros5 = 5;
		int euros10 = 10;
		int euros20 = 20;
		int euros50 = 50;
		int euros100 = 100;
		int euros200 = 200;
		int euros500 = 500;
		
		int totalPrice = 0;
		
		ArrayList<String> menuList = new ArrayList<String>();
		ArrayList<Integer> menuPrice = new ArrayList<Integer>();
		
		boolean stopper = true;
		
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
		reader.close();
		
		//Un cop hem acabat de demanar el menjar, haurem de comparar la llista amb l’array que hem fet al principi. 
		//En el cas que la informació que hem introduït a la List coincideixi amb la del array, haurem de sumar el preu del producte demanat;
		//en el cas contrari haurem de mostrar un missatge que digui que el producte que hem demanat no existeix.
		
		for(String food : order) {
			if (menuList.contains(food)) {
				totalPrice += menuPrice.get(menuList.indexOf(food));
			} else {
				System.out.println("el plato " + food + "no existe en nuestro menú");
			}
		}
		System.out.println("El coste total de su menú es de: " + totalPrice);

	}
	
	public static void printMenu(ArrayList<String> menu, ArrayList<Integer> price) {
		for (int i = 0; i < menu.size(); i++) {
			System.out.println(menu.get(i) + "  " + price.get(i) + "€");
		}
	}

}
