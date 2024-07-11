document.addEventListener('DOMContentLoaded', function() {
    const taskForm = document.getElementById('task-form');
    const taskList = document.getElementById('task-list');
    let editMode = false;
    let currentRow = null;

    taskForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const taskName = document.getElementById('task-name').value;
        const assignedTo = document.getElementById('assigned-to').value;
        const dueDate = document.getElementById('due-date').value;
        const priority = document.getElementById('priority').value;
        const status = document.getElementById('status').value;

        if (taskName.trim() === '' || assignedTo.trim() === '' || dueDate.trim() === '' || priority.trim() === '' || status.trim() === '' ) {
            alert('Please fill in all fields.');
            return;
        }

        if (editMode) {
            // Update the current row
            currentRow.cells[0].textContent = taskName;
            currentRow.cells[1].textContent = assignedTo;
            currentRow.cells[2].textContent = dueDate;
            currentRow.cells[3].textContent = priority;
            currentRow.cells[4].textContent = status;
            editMode = false;
            currentRow = null;
            taskForm.reset();
        } else {
            addTask(taskName, assignedTo, dueDate, priority, status);
            taskForm.reset();
        }
    });

    function addTask(taskName, assignedTo, dueDate, priority, status) {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${taskName}</td>
            <td>${assignedTo}</td>
            <td>${dueDate}</td>
            <td>${priority}</td>
            <td>${status}</td>
            <td>
                <button class="edit-btn">Edit</button>
                <button class="delete-btn">Delete</button>
            </td>
        `;

        taskList.appendChild(row);

        // Add event listeners for edit and delete buttons
        const editButton = row.querySelector('.edit-btn');
        editButton.addEventListener('click', function() {
            editMode = true;
            currentRow = row;
            document.getElementById('task-name').value = row.cells[0].textContent;
            document.getElementById('assigned-to').value = row.cells[1].textContent;
            document.getElementById('due-date').value = row.cells[2].textContent;
            document.getElementById('priority').value = row.cells[3].textContent;
            document.getElementById('status').value = row.cells[4].textContent;
        });

        const deleteButton = row.querySelector('.delete-btn');
        deleteButton.addEventListener('click', function() {
            row.remove();
        });
    }
});
