const url = "http://localhost:8080";

function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if (username.length===0 || password.length===0) {
        alert("Fields cannot be empty. Please try again.");
        return;
    }

    if (checkIfUsernameExists(username)) {
        if (getPasswordByUsername(username)===password) {
            location.href = 'search.html';
            return;
        } else {
            alert("The credentials entered did not match any records. Please try again.");
            document.getElementById("password").value = "";
            return;
        }
    } else {
        alert("That username does not exist. Please try again.");
        return;
    }
}

function createUser() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if (username.length===0 || password.length===0) {
        alert("Fields cannot be empty. Please try again.");
        return;
    }

    if (checkIfUsernameExists(username)) {
        alert("Sorry! The username "+" is taken. Please try another.");
        return;
    }

    fetch(url+"/users/new-user", {method: 'POST', mode: 'cors', body: {"username": username, "password": password}})
    .then(response => response.json())
    .then((result) => {
        console.log(result);
        alert("You have successfully created an account!");
        location.href = 'search.html';
    }).catch(error => {
        console.error('Error:', error); 
        alert("Something went wrong while creating your account. Please try again.");
    })
}

function checkIfUsernameExists(username) {
    var res = true;
    fetch(url+"/users/find-user/"+username, {method: 'GET', mode: 'cors'})
    .then(response => response.json())
    .then((result) => {
      console.log(result);
      return result;
    })
    .catch(error => {
        console.error('Error:', error); 
        res = false;
    });
    return res;
}

function getPasswordByUsername(username) {
    var pass;
    fetch(url+"/users/match-credentials/"+username, {method: 'GET', mode: 'cors'})
    .then(response => response.json())
    .then((password) => {
      console.log(password);
      pass = password;
    })
    .catch(error => {
        console.error('Error:', error); 
    });
    return pass;
}
