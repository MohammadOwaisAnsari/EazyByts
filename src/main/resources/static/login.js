document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    if (!username || !password) {
        document.getElementById('error-message').innerText = 'Please enter both username and password.';
        return;
    }
    
    // Here you can add additional client-side validation if needed
    
    // For now, we will simply submit the form
    this.submit();
});
