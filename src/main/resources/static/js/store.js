function store(index,choice) {
    // save to session storage
    sessionStorage.setItem("index", index)
    sessionStorage.setItem("choice", choice)

    // redirect
    location.href = "booking"

}