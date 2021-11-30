// Initialize a new TaskManager with currentId set to 0
// const itemsController = new ItemsController(0);

function loadItemsFromLocalStorage() {
    localItems = []
    const storageItems = localStorage.getItem("items")
    if (storageItems) {
        const items = JSON.parse(storageItems)
        for (var i = 0, size = items.length; i < size; i++) {
            const item = items[i];
            localItems.push(item);
        }
    }
}

function checkItemType(item){
    if(item.itemtype === "Health & Medical"){
        return "healthMedical"
    }
    else if(item.itemtype === "Rest & Relaxation"){
        return "restRelaxation"
    }
    else if(item.itemtype === "Diet & Nutrition"){
        return "dietNutrition"
    }
}


function addItemCard(item){
    const itemHTML = 
        '<div class= "productslist cardTest">\n' + //cardTest is for testing only. 
        '   <a href="products.html" class="text-decoration-none text-black" target="_blank">\n' +
        '       <img class= "card-img-top" src=" to be solved " alt=" " >\n' + //image not yet done
        '       <div class="card-body">\n' +
        '           <h5 class="card-title">' + item.name + '</h5>\n' +
        '           <p class="card-text">' + item.description + ' </p>\n' +
        '       </div>\n' +
        '   </a\n' +
        '</div>';
    const itemsContainer = document.getElementById(checkItemType(item));
    itemsContainer.innerHTML += itemHTML;
}

function loadCardsListFromLocalStorage(){
    for(var i = 0, size = localItems.length; i < size ; i++){
        const item = localItems[i];
        addItemCard(item);
    }
}

loadItemsFromLocalStorage();
loadCardsListFromLocalStorage();