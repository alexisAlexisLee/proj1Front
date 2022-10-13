const url = "http://localhost:8080";


function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if (username.length===0 || password.length===0) {
        alert("Fields cannot be empty. Please try again.");
        return;
    }

    console.log(checkIfUsernameExists(username));

    // if (checkIfUsernameExists(username)) {
    //     if (getPasswordByUsername(username)===password) {
    //         location.href = 'search.html';
    //         return;
    //     } else {
    //         alert("The credentials entered did not match any records. Please try again.");
    //         document.getElementsByClassName("password").value = "";
    //         return;
    //     }
    // } else {
    //     alert("That username does not exist. Please try again.");
    //     return;
    // }
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

    const req = new XMLHttpRequest();
    req.open('POST', url+"/users/new-user");
    console.log(JSON.stringify({"username": username, "password": password}));
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({"username": username, "password": password}));
    req.onreadystatechange = (e) => {

    };
    alert("You have successfully created an account!");
    location.href = 'search.html';
    return;
}

function checkIfUsernameExists(username) {
    var a;
    const req = new XMLHttpRequest();
    req.open('GET', url+"/users/find-user/"+username);
    req.send();
    req.onreadystatechange = (e) => {
        if (req.readyState === 4 && req.status === 200) {
            a = exec(req.responseText);
        }
    };
    return a;
}

function exec(text) {
    var bool;
    if (text==='true') {
        console.log("entered");
        bool = true;
    } else {
        bool = false;
    }
    console.log("inside"+bool);
    return bool;
}

function getPasswordByUsername(username) {
    const req = new XMLHttpRequest();
    req.open('GET', url+"/users/match-credentials/"+username);
    req.send();
    req.onreadystatechange = (e) => {
        console.log(req.responseText);
        document.getElementsByClassName("response-text").innerText=req.responseText;
    };
    console.log("test"+document.getElementsByClassName("response-text").innerText);
    return document.getElementsByClassName("response-text").innerText;
}
