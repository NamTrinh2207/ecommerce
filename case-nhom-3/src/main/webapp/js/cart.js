// xóa cart
let remove_cart = document.getElementsByClassName("btn-danger");
for (let i = 0; i < remove_cart.length; i++) {
    let button = remove_cart[i]
    button.addEventListener("click", function () {
        let button_remove = event.target
        button_remove.parentElement.parentElement.remove()
    })
}