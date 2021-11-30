// Initialize a new TaskManager with currentId set to 0
const itemsController = new ItemsController(0);

// Select the New Task Form
const newItemForm = document.querySelector('#newItemForm');

// Add an 'onsubmit' event listener
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();

    // Select the inputs
    const newItemNameInput = document.querySelector('#newItemNameInput');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemPrice = document.querySelector("#newItemPriceInput");
    /*
        Validation code here
    */

    // Get the values of the inputs
    const name = newItemNameInput.value;
    const description = newItemDescription.value;
    const price = newItemPrice.value;
    const createdAt = new Date();

    // Add the task to the task manager
    itemsController.addItem(name, description, price, createdAt);

    // Clear the form
    newItemNameInput.value = '';
    newItemDescription.value = '';
    newItemPrice.value = '';
});


// function addItemCard(item){
//     const itemHTML = '<div class="card" style="width: 18rem;">\n' +
//         '    <img src="'+item.img +'" class="card-img-top" alt="image">\n' +
//         '    <div class="card-body">\n' +
//         '        <h5 class="card-title">'+item.name+'</h5>\n' +
//         '        <p class="card-text">'+item.description+'</p>\n' +
//         '        <a href="#" class="btn btn-primary">Add</a>\n' +
//         '    </div>\n' +
//         '</div>\n' +
//         '<br/>';
//     const itemsContainer = document.getElementById("list-items");
//     itemsContainer.innerHTML += itemHTML;
// }