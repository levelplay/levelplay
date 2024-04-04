document.addEventListener("DOMContentLoaded", function() {
    // Targeting necessary elements
    const signupPage = document.getElementById("sign-up-page");
    const mainPage = document.getElementById("main-page");
    const openSearchPlayerPage = document.getElementsByClassName("open-search-player-page")[0]; // Assuming there's only one element with this class
    const openSearchGamePage = document.getElementsByClassName("open-search-game-page")[0];
    const gamePage = document.getElementById("game");
    const loginForm = document.getElementById("login-form");
    const signupForm = document.getElementById("signup-form");

    const registerRedirectButton = document.getElementById("register-redirect");
    const signInRedirectButton = document.getElementById("signin-redirect");

    const openSearchPlayerButton = document.getElementById("open-search-player");
    const openSearchGameButton = document.getElementById("open-search-game");

    const searchButtonPlayer = document.getElementById("search-button-player");
    const searchButtonGame = document.getElementById("search-button-game");

    const loginInCorrectError = document.getElementsByClassName("login-incorrect-error")[0];

    const openGamesListDiv = document.getElementsByClassName("open-games-list")[0];

    const homeButton = document.getElementById("home-button");

    // Function to show login page
    function showLoginPage() {
        signupPage.style.display = "none";
        mainPage.style.display = "none";
        loginInCorrectError.style.display = "none";
        openSearchPlayerPage.style.display = "none";
        openSearchGamePage.style.display = "none";
        gamePage.style.display = "none";
        loginForm.style.display = "block";

    }

    // Function to show main page
    function showMainPage() {
        signupPage.style.display = "none";
        mainPage.style.display = "block";
        openSearchPlayerPage.style.display = "none";
        openSearchGamePage.style.display = "none";
        gamePage.style.display = "none";
        loginInCorrectError.style.display = "none";
    }

    // Function to show find friends page
    function showOpenSearchPlayerPage() {
        signupPage.style.display = "none";
        mainPage.style.display = "block";
        openSearchPlayerPage.style.display = "block";
        openSearchGamePage.style.display = "none";
        gamePage.style.display = "none";
        loginInCorrectError.style.display = "none";

    }
    function showOpenSearchGamePage() {
        signupPage.style.display = "none";
        mainPage.style.display = "block";
        openSearchGamePage.style.display = "block";
        openSearchPlayerPage.style.display = "none";
        gamePage.style.display = "none";
        loginInCorrectError.style.display = "none";
    }


    function showRegisterPage() {
        signupPage.style.display = "block";
        mainPage.style.display = "none";
        openSearchPlayerPage.style.display = "none";
        openSearchGamePage.style.display = "none";
        gamePage.style.display = "none";
        loginForm.style.display = "none";
        loginInCorrectError.style.display = "none";
    }


    // Event listener for login form submission
    loginForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission

        // Get form data
        const formData = new FormData(event.target);

        const formDataObject = {};
        formDataObject["username"] = formData.get("username")
        formDataObject["password"] = formData.get("password")
        console.log(formDataObject)

        // API endpoint
        const apiUrl = 'http://127.0.0.1:8086/levelplay/user/login';

        // Fetch API to send form data
        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataObject)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return true;
            })
            .then(data => {
                console.log('Success:', data);
                showMainPage();
                // Optionally, you can perform actions after successful submission
            })
            .catch(error => {
                loginInCorrectError.style.display = "block";
                console.error('Error:', error);
                // Optionally, you can handle errors here
            });

        // Add your logic here for handling login form submission
        // Example: You can send login credentials to the server and handle the response accordingly

    });

    // Event listener for signup form submission
    signupForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission

        // Get form data
        const formData = new FormData(event.target);

        const formDataObject = {};
        formDataObject["username"] = formData.get("username")
        formDataObject["password"] = formData.get("password")
        formDataObject["email"] = formData.get("email")
        formDataObject["profilePicture"] = ""
        console.log(formDataObject)

        // API endpoint
        const apiUrl = 'http://127.0.0.1:8086/levelplay/user/register';

        // Fetch API to send form data
        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataObject)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return true;
            })
            .then(data => {
                console.log('Success:', data);
                showMainPage();
                // Optionally, you can perform actions after successful submission
            })
            .catch(error => {
                console.error('Error:', error);
                // Optionally, you can handle errors here
            });

        // Add your logic here for handling login form submission
        // Example: You can send login credentials to the server and handle the response accordingly

    });

    searchButtonPlayer.addEventListener("click",function (event) {
        event.preventDefault(); // Prevent form submission

        const playerName = document.getElementsByName("search-player")[0].value;
        const apiUrl = 'http://localhost:8086/levelplay/user/search/user';

        const formDataObject = {"username":playerName};
        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataObject)
        })
            .then(response => {
                if (!response.ok) {
                    alert("user not found");
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {

                // console.log('Success:', data);
                let username = data['username'];
                console.log(username)
                // Create a new <p> element
                let paragraph = document.createElement("p");

                // Set the text content of the <p> element to the username
                paragraph.textContent =  username;
                paragraph.style.textAlign = "center";

                // Append the <p> element to the div
                openGamesListDiv.appendChild(paragraph);

                // openGamesListDiv.innerHtml = `<p>${username}</p>`
                showMainPage();
            })
            .catch(error => {
                console.error('Error:', error);
                // Optionally, you can handle errors here
            });

    })

    searchButtonGame.addEventListener("click",function (event) {
        event.preventDefault(); // Prevent form submission

        const playerName = document.getElementsByName("search-game")[0].value;
        const apiUrl = 'http://localhost:8086/levelplay/api/games/search/game';

        const formDataObject = {"title":playerName};
        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataObject)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return true;
            })
            .then(data => {
                console.log('Success:', data);
                showMainPage();
                // Optionally, you can perform actions after successful submission
            })
            .catch(error => {
                console.error('Error:', error);
                // Optionally, you can handle errors here
            });

    })


    // Event listener for redirect to register page
    registerRedirectButton.addEventListener("click", function() {
        showRegisterPage();
    });
    // Event listener for redirect to signIn page
    signInRedirectButton.addEventListener("click", function() {
        showLoginPage();
    });

    // Event listener for opening search button for add player , search game
    openSearchPlayerButton.addEventListener("click", function() {
        showOpenSearchPlayerPage();
    });

    // Event listener for opening search button for add player , search game
   openSearchGameButton.addEventListener("click", function() {
        showOpenSearchGamePage();
    });

    // Event listener for opening search button for add player , search game
    homeButton.addEventListener("click", function() {
        showMainPage();
    });

    // Initial page load: show login page
    showLoginPage();
    // showMainPage();
});
