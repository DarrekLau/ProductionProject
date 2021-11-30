class ItemsController {
    // Set up the items and currentId property in the constructor
    constructor(currentId = 0) {
        this.items = [];
        this.currentId = currentId;
    }

    // Create the addItem method
    addItem(name, description, price, itemtype, image) {
        const item = {
            // Increment the currentId property
            id: this.currentId++,
            name: name,
            description: description,
            price: price,
            itemtype: itemtype,
            image: image
        };

        // Push the item to the items property
        this.items.push(item);
        localStorage.setItem("items", JSON.stringify(this.items));
        // view item stored into local storage
        console.log(this.items)
    }
}



