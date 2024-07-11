function addDeal() {
    const dealName = document.getElementById('deal-name').value;
    const assignedTo = document.getElementById('assigned-to').value;
    const dealValue = document.getElementById('deal-value').value;
    const status = document.getElementById('status').value;

    if (dealName && assignedTo && dealValue && status) {
        const table = document.getElementById('deal-list');
        const row = table.insertRow();

        row.insertCell(0).innerHTML = dealName;
        row.insertCell(1).innerHTML = assignedTo;
        row.insertCell(2).innerHTML = dealValue;
        row.insertCell(3).innerHTML = status;
        row.insertCell(4).innerHTML = '<button onclick="deleteDeal(this)">Delete</button>';

        updateChart();

        document.getElementById('sales-form').reset();
    } else {
        alert('Please fill in all fields');
    }
}

function deleteDeal(button) {
    const row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
    updateChart();
}

function updateChart() {
    const statusCount = {
        "prospecting": 0,
        "qualification": 0,
        "proposal": 0,
        "negotiation": 0,
        "closed won": 0,
        "closed lost": 0
    };

    const table = document.getElementById('deal-list');
    for (let i = 0; i < table.rows.length; i++) {
        const status = table.rows[i].cells[3].innerHTML;
        statusCount[status]++;
    }

    const ctx = document.getElementById('salesChart').getContext('2d');
    const chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: Object.keys(statusCount),
            datasets: [{
                label: '# of Deals',
                data: Object.values(statusCount),
                backgroundColor: [
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(255, 99, 132, 0.2)'
                ],
                borderColor: [
                    'rgba(75, 192, 192, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(255, 99, 132, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

document.addEventListener('DOMContentLoaded', updateChart);
