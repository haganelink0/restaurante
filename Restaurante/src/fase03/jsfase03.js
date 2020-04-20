function crearMenu() {
	var menuList = [];
	var menuPrice = [];
	let finalPrice = 0;
	let stopper = true;
	
	while(stopper) {
		var plate = prompt("introduzca un plato del menu o 'salir' para salir");
		if (plate == "salir") {
			stopper = false;
		} else {
			menuList.push(plate);
			var price = prompt("introduca el precio del plato");
			menuPrice.push(price);
		}
	}
	printMenu(menuList,menuPrice);
	let order = pedirPlatos();
	let finalOrder = [];
	let missingOrder = [];
	
	for (let i = 0; i < order.length; i++) {
		var plate = order[i]
		if (menuList.indexOf(plate) == -1) {
			missingOrder.push(plate);
		} else {
			finalPrice += parseInt(menuPrice[menuList.indexOf(plate)]);
			finalOrder.push(plate);
		}
	}
	
	document.getElementById("orderErrors").innerHTML = "Los siguientes platos no estaban en nuestro menu: " + missingOrder;
	document.getElementById("finalOrder").innerHTML = "El menu final consta de " + finalOrder + " con un coste de " + finalPrice + "€";
	
}



function printMenu(menuList, menuPrice) {
	for (let i = 0; i < menuList.length; i++) {
		document.getElementById("menuDisplay").innerHTML += menuList[i] + "  " + menuPrice[i] + "<br>";
	}
}

function pedirPlatos() {
	order = [];
	let keepOrdering = 1;
	
	while(keepOrdering == 1) {
		orderPlate = prompt("diga que plato quiere pedir de la lista");
		order.push(orderPlate);
		keepOrdering = prompt("Desea pedir otro plato? (1:Sí / 0:No)");
	}
	return order;
}