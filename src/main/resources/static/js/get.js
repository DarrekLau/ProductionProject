function get(){
// get from session storage
    const num = parseInt(sessionStorage.getItem("index"));
    const product = sessionStorage.getItem("choice")

    if(product === "health package"){
        document.getElementById("health package").selectedIndex = num;
    }
    else if(product === "rest package"){
        document.getElementById("rest package").selectedIndex = num;
    }
    if(product === "diet package"){
        document.getElementById("diet package").selectedIndex = num;
    }

// clear session storage
    sessionStorage.removeItem("index");
// sessionStorage.clear();

}