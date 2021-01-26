/**
 * 
 */
window.onload = function() {
	displayTicket();
};


function displayTicket() {

	let xhttp = new XMLHttpRequest()
	let url = "http://localhost:8080/Project_1/api/employee/tickets";
	xhttp.open("GET", url);
	xhttp.send();
	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let item = JSON.parse(xhttp.responseText);
			item.forEach(element => {
				let table = document.getElementById("ticketTable").getElementsByTagName("tbody")[0];
				let row = document.createElement("tr");

				let id = document.createElement("td");
				let user = document.createElement("td");
				let username = document.createElement("td");
				let amount = document.createElement("td");
				let desc = document.createElement("td");
				let type = document.createElement("td");
				let status = document.createElement("td");

				id.innerHTML = element.reimburstment_ticket_id;
				user.innerHTML = element.reimburstment_user_id;
				username.innerHTML = element.username;
				amount.innerHTML = "$ " + element.amount.toFixed(2);
				desc.innerHTML = element.description;
				switch (element.reimburstment_type) {
					case 1:
						type.innerHTML = "Lodging";
						break;
					case 2:
						type.innerHTML = "Travel";
						break;
					case 3:
						type.innerHTML = "Food";
						break;
					case 4:
						type.innerHTML = "Other";
						break;
				}

				switch (element.approved) {

					case 0:
						status.innerHTML = "Denied";
						row.classList.add("table-danger");
						break;
					case 1:
						status.innerHTML = "Approved";
						row.classList.add("table-success");
						break;
					default:
						status.innerHTML = "Pending";
						row.classList.add("table-secondary");
						break;
				}

				row.appendChild(id);
				row.appendChild(user);
				row.appendChild(username);
				row.appendChild(amount);
				row.appendChild(desc);
				row.appendChild(type);
				row.appendChild(status);
				
				table.appendChild(row);
			})
		}
	}

};

function submitTicket(){
	let xhttp = new XMLHttpRequest();
	let url = "http://localhost:8080/Project_1/api/employee/tickets";
	xhttp.open("POST", url);
	let ticket = {
		amount: document.getElementById("amount").value,
		description: document.getElementById("description").value,
		reimburstment_type: document.getElementById("type").value
	}
	xhttp.send(JSON.stringify(ticket));
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			document.getElementById("ticketTable").getElementsByTagName("tbody")[0].innerHTML = "";
			displayTicket();
		}
	}
}

function formatAmount() {
	let amount = document.getElementById("amount");
	amount.value = parseFloat(amount.value).toFixed(2);
}