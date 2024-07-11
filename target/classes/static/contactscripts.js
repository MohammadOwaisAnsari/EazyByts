function addContact() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const company = document.getElementById('company').value;
    const jobTitle = document.getElementById('jobTitle').value;
    const address = document.getElementById('address').value;

    if (name && email && phone && company && jobTitle && address) {
        const table = document.getElementById('contact-list');
        const row = table.insertRow();

        row.insertCell(0).innerHTML = name;
        row.insertCell(1).innerHTML = email;
        row.insertCell(2).innerHTML = phone;
        row.insertCell(3).innerHTML = company;
        row.insertCell(4).innerHTML = jobTitle;
        row.insertCell(5).innerHTML = address;
        row.insertCell(6).innerHTML = '<button onclick="deleteContact(this)">Delete</button>';

        document.getElementById('contact-form').reset();
    } else {
        alert('Please fill in all fields');
    }
}

function deleteContact(button) {
    const row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
}
