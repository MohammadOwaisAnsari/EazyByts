// Example script to handle any interactivity needed on the home page
document.addEventListener('DOMContentLoaded', function() {
    console.log('Home page loaded');
});


    // Add active class to the current navigation link
    navLinks.forEach(link => {
        link.addEventListener("click", () => {
            navLinks.forEach(nav => nav.classList.remove("active"));
            link.classList.add("active");
        });
    });

    // Example of a dynamic greeting based on the time of day
    const greeting = document.querySelector("header h1");
    const hours = new Date().getHours();
    let greetingText;

    if (hours < 12) {
        greetingText = "Good Morning!";
    } else if (hours < 18) {
        greetingText = "Good Afternoon!";
    } else {
        greetingText = "Good Evening!";
    }

    greeting.textContent = `${greetingText} Welcome to the CRM System`;

   