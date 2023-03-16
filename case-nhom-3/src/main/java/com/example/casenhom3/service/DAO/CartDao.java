package com.example.casenhom3.service.DAO;

import com.example.casenhom3.model.Cart;
import com.example.casenhom3.model.ItemCart;

import java.util.List;

public class CartDao {
    Cart cart=new Cart();
    List<ItemCart>list=cart.getCartList();
    private ItemCart getItemById(Long id){
        for (ItemCart i:list) {
            if (i.getProduct().getId()==id){
                return i;
            }
        }
        return null;
    }
    public int getQuantity(Long id){
        return getItemById(id).getQuantity();
    }
    public void addItemCart(ItemCart itemCart){
        if (getItemById(itemCart.getProduct().getId())!=null){
            ItemCart i=getItemById(itemCart.getProduct().getId());
            i.setQuantity(i.getQuantity()+ itemCart.getQuantity());
        }else {
            list.add(itemCart);
        }
    }
    public  void deleteItemCart(Long id){
        if (getItemById(id)!=null){
            list.remove(getItemById(id));
        }
    }
    public Double getTotalMoney(){
        Double sum= 0.0;
        for (ItemCart i:list) {
            sum+=i.getPrice()*i.getQuantity();
        }
        return sum;

    }
}
