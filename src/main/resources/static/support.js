let ticketCounter = 0;

function generateTicketNumber() {
    const now = new Date();

    const yy = now.getFullYear().toString().slice(-2);
    const mm = (now.getMonth() + 1).toString().padStart(2, '0');
    const dd = now.getDate().toString().padStart(2, '0');
    const hh = now.getHours().toString().padStart(2, '0');
    const mi = now.getMinutes().toString().padStart(2, '0');
   // const ss = now.getSeconds().toString().padStart(2, '0');
    const sequence = (++ticketCounter).toString().padStart(3, '0');
    
    return `${yy}${mm}${dd}${hh}${mi}${sequence}`;
}

function submitTicket() {
    // Gather form data
    const ticketNumber = generateTicketNumber();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const subject = document.getElementById('subject').value;
    const priority = document.getElementById('priority').value;
    const description = document.getElementById('description').value;

    // Create a new row
    const table = document.getElementById('ticket-list');
    const row = table.insertRow();
    row.insertCell(0).textContent = ticketNumber;
    row.insertCell(1).textContent = name;
    row.insertCell(2).textContent = email;
    row.insertCell(3).textContent = subject;
    row.insertCell(4).textContent = priority;
    row.insertCell(5).textContent = description;
    const actionsCell = row.insertCell(6);
    
    // Create delete button
    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
    deleteButton.onclick = function() {
        table.deleteRow(row.rowIndex - 1);
    };
    actionsCell.appendChild(deleteButton);
    
    // Clear form
    document.getElementById('support-form').reset();

    alert('Ticket submitted successfully!');
}
