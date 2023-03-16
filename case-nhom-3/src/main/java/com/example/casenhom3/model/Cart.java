package com.example.casenhom3.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<ItemCart> cartList;

    public Cart() {

        cartList=new ArrayList<>();
    }

    public Cart(List<ItemCart> cartList) {
        this.cartList = cartList;
    }

    public List<ItemCart> getCartList() {
        return cartList;
    }

    public void setCartList(List<ItemCart> cartList) {
        this.cartList = cartList;
    }
    private ItemCart getItemById(Long id){
        for (ItemCart i:cartList) {
            if (i.getProduct().getId()==id){
                return i;
            }
        }
        return null;
    }
    public int getQuantty(Long id){
        return getItemById(id).getQuantity();
    }
    public void addItemCart(ItemCart itemCart){
        if (getItemById(itemCart.getProduct().getId())!=null){
            ItemCart i=getItemById(itemCart.getProduct().getId());
            i.setQuantity(i.getQuantity()+ itemCart.getQuantity());
        }else {
            cartList.add(itemCart);
        }
    }
    public  void deleteItemCart(Long id){
        if (getItemById(id)!=null){
            cartList.remove(getItemById(id));
        }
    }
    public Double getTotalMoney(){
        Double sum= 0.0;
        for (ItemCart i:cartList) {
            sum+=i.getPrice()*i.getQuantity();
        }
        return sum;

    }
}
