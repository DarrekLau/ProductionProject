// Initialize a new ItemsController with currentId set to 0
const itemsController = new ItemsController(0);

// Select the New Item Form
const newItemForm = document.querySelector('#newItemForm');

// Add an 'onsubmit' event listener
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();

    // Select the inputs
    const newItemName = document.querySelector('#newItemName');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemPrice = document.querySelector('#newItemPrice');
    const newItemType = document.querySelector('input[type=radio][name=newItemType]:checked');
    const newItemImage = document.querySelector('#newItemImage');    

    // Get the values of the inputs
    const name = newItemName.value;
    const description = newItemDescription.value;
    const price = newItemPrice.value;
    const itemtype = newItemType.value;
    const image = newItemImage.value;

    // testing output
    console.log(newItemType)
    console.log(itemtype)

    /*
        Validation code here
    */

    // Add the item to the ItemsController
    itemsController.addItem(name, description, price, itemtype, image);

    // Clear the form
    // newItemName.value = '';
    // newItemDescription.value = '';
    // newItemPrice.value = ''
    document.querySelector('#newItemForm').reset();
      
});